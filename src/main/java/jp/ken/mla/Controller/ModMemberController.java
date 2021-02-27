package jp.ken.mla.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.mla.dao.MemberDAO;
import jp.ken.mla.dao.PayDAO;
import jp.ken.mla.dao.PlanDAO;
import jp.ken.mla.entity.Member;
import jp.ken.mla.entity.Pay;
import jp.ken.mla.entity.Plan;
import jp.ken.mla.model.LoginModel;

@Controller
@RequestMapping("modMember")
@SessionAttributes("loginModel")
public class ModMemberController {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MemberDAO<Member> memberDAO = (MemberDAO<Member>)context.getBean("memberDAO");
	@SuppressWarnings("unchecked")
	private static PayDAO<Pay> payDAO = (PayDAO<Pay>)context.getBean("payDAO");
	@SuppressWarnings("unchecked")
	private static PlanDAO<Plan> planDAO = (PlanDAO<Plan>)context.getBean("planDAO");

	@RequestMapping(method=RequestMethod.GET)
	public String toAddMember(Model model, LoginModel lModel) {
		if(lModel.getMember_id() == 0) { // 未ログイン時はログイン画面にリダイレクト
			return "redirect:/login";
		}
		return setDispModMember(model, "");
	}

	// 更新ボタン実行処理
	@RequestMapping(method=RequestMethod.POST, params="update")
	public String updateToTop(@Validated @ModelAttribute LoginModel lModel,
		BindingResult result, Model model) {

		// バリデーションチェック
		if(result.hasErrors()) {
			return setDispModMember(model, "");
		}
		// 一旦更新前の会員情報をDBから取得
		Member befor = memberDAO.getById(lModel.getMember_id());
		// 入会日、作成日をDBからモデルにセット
		lModel.setJoin_date(befor.getJoin_date());
		lModel.setMake_date(befor.getMake_date());

		// メールアドレス変更時のみ重複チェック
		if(!befor.getEmail().equals(lModel.getEmail())) {
			List<Member> list = memberDAO.getByMail(lModel.getEmail());
			if(list.size() > 0) {
				return setDispModMember(model, "既に登録済のEmailです。");
			}
		}

		// プラン変更時はプラン情報をモデルにセットする(なぜか更新されない)
       if(befor.getPlan_id() != lModel.getPlan_id()) {
        	lModel.setPlan(planDAO.getById(lModel.getPlan_id()));
        }

		Member member = new Member();
		BeanUtils.copyProperties(lModel, member);

		if(memberDAO.updateMemberData(member)) {
			return "redirect:/index";
		} else {
			return setDispModMember(model, "DB更新に失敗しました。");
		}
	}

	// 削除ボタン実行処理
	@RequestMapping(method=RequestMethod.POST, params="delete")
	public String deleteToTop(@Validated @ModelAttribute LoginModel lModel,
		BindingResult result, Model model) {

		Member member = new Member();
		BeanUtils.copyProperties(lModel, member);

		if(memberDAO.deleteMemberData(member)) {
			return "redirect:/logout";
		} else {
			return setDispModMember(model, "DB更新に失敗しました。");
		}
	}

	// -----------------------------
	// 内部処理メソッド
	// -----------------------------

	// 個人情報管理画面表示データ共通設定
	private String setDispModMember(Model model, String errorMessage) {
		model.addAttribute("errorMessage", errorMessage);
		IndexController.setActiveTab(model, "modMember");
		model.addAttribute("payList", payDAO.allList());
		model.addAttribute("planList", planDAO.allList());
		return "index";
	}
}

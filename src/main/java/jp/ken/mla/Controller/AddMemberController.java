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
@RequestMapping("addMember")
@SessionAttributes("loginModel")
public class AddMemberController {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MemberDAO<Member> memberDAO = (MemberDAO<Member>)context.getBean("memberDAO");
	@SuppressWarnings("unchecked")
	private static PayDAO<Pay> payDAO = (PayDAO<Pay>)context.getBean("payDAO");
	@SuppressWarnings("unchecked")
	private static PlanDAO<Plan> planDAO = (PlanDAO<Plan>)context.getBean("planDAO");

	@ModelAttribute("loginModel")
	public LoginModel setUpLoginModel() {
		return new LoginModel();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String toAddMember(Model model, @ModelAttribute LoginModel lModel) {
		lModel.setMember_name("");
		model.addAttribute("payList", payDAO.allList());
		return "addMember";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String toTop(@Validated @ModelAttribute LoginModel lModel,
		BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("payList", payDAO.allList());
			return "addMember";
		}
		List<Member> list = memberDAO.getByMail(lModel.getEmail());
		if(list.size() > 0) {
			model.addAttribute("errorMessage", "既に登録済のEmailです。");
			model.addAttribute("payList", payDAO.allList());
			return "addMember";
		} else {
			Member member = new Member();
			BeanUtils.copyProperties(lModel, member);

			if(memberDAO.insertMemberData(member)) {
				// IDを取得する為、insertしたレコードを再取得する
				list = memberDAO.getByMail(lModel.getEmail());
				if(list.size() > 0) {
					member = list.get(0);
					lModel.setMember_id(member.getMember_id());
					lModel.setPlan(planDAO.getById(lModel.getPlan_id()));
					return "redirect:/index";
				} else {
					model.addAttribute("errorMessage", "レコード再取得に失敗しました。");
					model.addAttribute("payList", payDAO.allList());
					return "addMember";
				}
			} else {
				model.addAttribute("errorMessage", "DB登録に失敗しました。");
				model.addAttribute("payList", payDAO.allList());
				return "addMember";
			}
		}
	}
}
package jp.ken.mla.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.ken.mla.dao.ItemDAO;
import jp.ken.mla.dao.RentalDAO;
import jp.ken.mla.entity.Item;
import jp.ken.mla.entity.Rental;
import jp.ken.mla.model.LoginModel;
import jp.ken.mla.model.RentalModel;
import jp.ken.mla.model.SearchModel;

@Controller
@SessionAttributes("loginModel")
public class IndexController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static ItemDAO<Item> itemDAO = (ItemDAO<Item>)context.getBean("itemDAO");
	@SuppressWarnings("unchecked")
	private static RentalDAO<Rental> rentalDAO = (RentalDAO<Rental>)context.getBean("rentalDAO");

	private int member_id = 0;

	@ModelAttribute("loginModel")
	public LoginModel setUpLoginModel() {
		return new LoginModel();
	}

	// TOPページ
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String toTop(Model model, @ModelAttribute LoginModel lModel) {
		member_id = lModel.getMember_id();
		setActiveTab(model, "top");
		model.addAttribute("rentalIds", rentalDAO.getByRentalItemIds(member_id));
		return "index";
	}

	// 商品検索
	@RequestMapping(value="/*", method=RequestMethod.POST, params="search")
	public String searchResult(@ModelAttribute SearchModel sModel, Model model) {
		String word = sModel.getWord();
		if(!word.isEmpty()) {
			model.addAttribute("searchList", itemDAO.searchList(word));
		}
		setActiveTab(model, "top");
		model.addAttribute("searchModel", sModel);
		model.addAttribute("rentalIds", rentalDAO.getByRentalItemIds(member_id));
		return "index";
	}

	// 商品の借りるボタン
	@RequestMapping(value="/index", method=RequestMethod.POST, params="rentalAdd")
	public String rentalAddBtn(@ModelAttribute RentalModel rModel, Model model) {
		Rental rental = new Rental();
		rental.setMember_id(member_id);
		rental.setItem_id(rModel.getItem_id());
		if(!rentalDAO.insertRentalData(rental)) {
			System.out.println("レンタル管理テーブルinsertエラー");
		}
		return "redirect:/index";
	}

	// 商品の発送準備中(キャンセル)ボタン
	@RequestMapping(value="/index", method=RequestMethod.POST, params="rentalDel")
	public String rentalDelBtn(@ModelAttribute RentalModel rModel, Model model) {
		Rental rental = rentalDAO.getByItemMemberId(rModel.getItem_id(), member_id) ;
		if(!rentalDAO.deleteRentalData(rental)) {
			System.out.println("レンタル管理テーブルdeleteエラー");
		}
		return "redirect:/index";
	}

	// ログアウトボタン
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String runLogout(SessionStatus status) {
		status.setComplete();
		setUpLoginModel();
		return "redirect:/index";
	}

	// 履歴管理
	@RequestMapping(value="/history", method=RequestMethod.GET)
	public String toHistory(Model model, LoginModel lModel) {
		if(lModel.getMember_id() == 0) { // 未ログイン時はログイン画面にリダイレクト
			return "redirect:/login";
		}
		setActiveTab(model, "history");
		return "index";
	}

	// 在庫管理
	@RequestMapping(value="/stock", method=RequestMethod.GET)
	public String toStock(Model model, LoginModel lModel) {
		if(lModel.getAdmin() != 1) { // 管理ユーザ以外からのアクセスはエラー
			model.addAttribute("errorMessage", "管理者ユーザ以外はアクセス出来ません。");
			setActiveTab(model, "error");
			return "index";
		}
		setActiveTab(model, "stock");
		return "index";
	}

	// 督促管理
	@RequestMapping(value="/remind", method=RequestMethod.GET)
	public String toRemind(Model model, LoginModel lModel) {
		if(lModel.getAdmin() != 1) { // 管理ユーザ以外からのアクセスはエラー
			model.addAttribute("errorMessage", "管理者ユーザ以外はアクセス出来ません。");
			setActiveTab(model, "error");
			return "index";
		}
		setActiveTab(model, "remind");
		return "index";
	}

	// 情報管理
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String toInfo(Model model, LoginModel lModel) {
		if(lModel.getAdmin() != 1) { // 管理ユーザ以外からのアクセスはエラー
			model.addAttribute("errorMessage", "管理者ユーザ以外はアクセス出来ません。");
			setActiveTab(model, "error");
			return "index";
		}
		setActiveTab(model, "info");
		return "index";
	}

	// -----------------------------
	// 内部処理メソッド
	// -----------------------------

	public static void setActiveTab(Model model, String pName) {
		SearchModel sModel = new SearchModel();
		model.addAttribute("searchModel", sModel);
		// Topページの商品情報各種をセット
		if(pName.equals("top")) {
			model.addAttribute("newList", itemDAO.top5List(0));
			model.addAttribute("oldList", itemDAO.top5List(1));
			model.addAttribute("allList", itemDAO.allList());
		}

		// 借りる／発送準備中ボタン用Modelをセット
		if(pName.equals("top") || pName.equals("rental")) {
			RentalModel rModel = new RentalModel();
			model.addAttribute("rentalModel", rModel);
		}

		model.addAttribute("activeTop",       (pName.equals("top"))       ? "active" : "");
		model.addAttribute("activeModMember", (pName.equals("modMember")) ? "active" : "");
		model.addAttribute("activeRental",    (pName.equals("rental"))    ? "active" : "");
		model.addAttribute("activeHistory",   (pName.equals("history"))   ? "active" : "");
		model.addAttribute("activeStock",     (pName.equals("stock"))     ? "active" : "");
		model.addAttribute("activeRemind",    (pName.equals("remind"))    ? "active" : "");
		model.addAttribute("activeInfo",      (pName.equals("info"))      ? "active" : "");
		model.addAttribute("pName", pName);
	}
}

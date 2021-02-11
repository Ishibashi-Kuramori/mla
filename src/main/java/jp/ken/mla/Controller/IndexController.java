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
import jp.ken.mla.entity.Item;
import jp.ken.mla.model.LoginModel;
import jp.ken.mla.model.SearchModel;

@Controller
@SessionAttributes("loginModel")
public class IndexController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	@SuppressWarnings("unchecked")
	private static ItemDAO<Item> itemDAO = (ItemDAO<Item>)context.getBean("itemDAO");

	@ModelAttribute("loginModel")
	public LoginModel setUpLoginModel() {
		return new LoginModel();
	}

	// TOPページ
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String toTop(Model model) {
		setActiveTab(model, "top");
		return "index";
	}

	// 商品検索
	@RequestMapping(value="/index", method=RequestMethod.POST, params="search")
	public String searchResult(@ModelAttribute SearchModel sModel, Model model) {
		String word = sModel.getWord();
		if(!word.isEmpty()) {
			model.addAttribute("searchList", itemDAO.searchList(word));
		}
		setActiveTab(model, "top");
		model.addAttribute("searchModel", sModel);
		return "index";
	}

	// ログアウトボタン
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String runLogout(SessionStatus status) {
		status.setComplete();
		setUpLoginModel();
		return "redirect:/index";
	}

	// レンタル管理
	@RequestMapping(value="/rental", method=RequestMethod.GET)
	public String toRental(Model model) {
		setActiveTab(model, "rental");
		return "index";
	}

	// 履歴管理
	@RequestMapping(value="/history", method=RequestMethod.GET)
	public String toHistory(Model model) {
		setActiveTab(model, "history");
		return "index";
	}

	// 在庫管理
	@RequestMapping(value="/stock", method=RequestMethod.GET)
	public String toStock(Model model) {
		setActiveTab(model, "stock");
		return "index";
	}

	// 督促管理
	@RequestMapping(value="/remind", method=RequestMethod.GET)
	public String toRemind(Model model) {
		setActiveTab(model, "remind");
		return "index";
	}

	// 情報管理
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String toInfo(Model model) {
		setActiveTab(model, "info");
		return "index";
	}

	// -----------------------------
	// 内部処理メソッド
	// -----------------------------

	public static void setActiveTab(Model model, String pName) {
		SearchModel sModel = new SearchModel();
		model.addAttribute("searchModel", sModel);
		if(pName.equals("top")) {
			model.addAttribute("newList", itemDAO.top5List(0));
			model.addAttribute("oldList", itemDAO.top5List(1));
			model.addAttribute("allList", itemDAO.allList());
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

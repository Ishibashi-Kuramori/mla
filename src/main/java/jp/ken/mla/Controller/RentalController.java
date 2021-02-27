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


import jp.ken.mla.dao.RentalDAO;
import jp.ken.mla.entity.Rental;
import jp.ken.mla.model.LoginModel;
import jp.ken.mla.model.RentalModel;

@Controller
@RequestMapping("rental")
@SessionAttributes("loginModel")
public class RentalController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static RentalDAO<Rental> rentalDAO = (RentalDAO<Rental>)context.getBean("rentalDAO");

	private int member_id = 0;
	
	@RequestMapping(method=RequestMethod.GET)
	public String toRental(Model model, LoginModel lModel) {
		if(lModel.getMember_id() == 0) { // 未ログイン時はログイン画面にリダイレクト
			return "redirect:/login";
		}
		member_id = lModel.getMember_id();
		model.addAttribute("rentalList", rentalDAO.getByMemberId(member_id));
		model.addAttribute("rentalIds", rentalDAO.getByRentalItemIds(member_id));
		IndexController.setActiveTab(model, "rental");
		return "index";
	}
	
	// 商品の発送準備中(キャンセル)ボタン
	@RequestMapping(method=RequestMethod.POST, params="rentalDel")
	public String rentalDelBtn(@ModelAttribute RentalModel rModel, Model model) {
		Rental rental = rentalDAO.getByItemMemberId(rModel.getItem_id(), member_id);
		if(!rentalDAO.deleteRentalData(rental)) {
			System.out.println("レンタル管理テーブルdeleteエラー");
		}
		return "redirect:/rental";
	}
}

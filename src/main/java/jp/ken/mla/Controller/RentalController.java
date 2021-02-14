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

@Controller
@RequestMapping("rental")
@SessionAttributes("loginModel")
public class RentalController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static RentalDAO<Rental> rentalDAO = (RentalDAO<Rental>)context.getBean("rentalDAO");

	@RequestMapping(method=RequestMethod.GET)
	public String toRental(Model model, @ModelAttribute LoginModel lModel) {
		model.addAttribute("rentalList", rentalDAO.getByMemberId(lModel.getMember_id()));
		IndexController.setActiveTab(model, "rental");
		return "index";
	}
}

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
import jp.ken.mla.entity.Member;
import jp.ken.mla.model.LoginModel;

@Controller
@RequestMapping("login")
@SessionAttributes("loginModel")
public class LoginController {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static MemberDAO<Member> memberDAO = (MemberDAO<Member>)context.getBean("memberDAO");

	@ModelAttribute("loginModel")
	public LoginModel setUpLoginModel() {
		return new LoginModel();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String toTop(@Validated @ModelAttribute LoginModel lModel,
		BindingResult result, Model model) {
		if(result.hasErrors()) return "login";
		List<Member> list = memberDAO.getByLogin(lModel.getEmail(), lModel.getPassword());
		if(list == null || list.size() == 0) {
			model.addAttribute("errorMessage", "mailもしくはpasswordが間違っています。");
			return "login";
		} else {
			// Modelの内容をDB取得データに差し替える
			Member member = list.get(0);
			BeanUtils.copyProperties(member, lModel);
			return "redirect:/index";
		}
	}
}

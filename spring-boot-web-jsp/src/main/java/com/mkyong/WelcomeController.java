package com.mkyong;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.onyx.bootapp.dao.UserDao;
import it.onyx.bootapp.form.UserForm;
import it.onyx.bootapp.util.Util2;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(@ModelAttribute UserForm userForm, Model model) {
		return "user";
	}
	
	@RequestMapping("/error")
	public String errore(Map<String, Object> model) {
		model.put("message", this.message);
		return "errore";
	}
	
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String savePersonPost(@ModelAttribute UserForm userForm, Model model, RedirectAttributes redirectAttributes) {
		
		String email = userForm.getEmail();
		String password = userForm.getPassword();
		
		if( email != null && password != null ) {
			if (!email.equals("") && !password.equals("")) {
				if (Util2.emailExist(email)) {
					UserDao ud = Util2.login(email, password);
					redirectAttributes.addFlashAttribute("ud", ud);
					return "redirect:/home";
				} else {
					model.addAttribute("Message", "USER NOT FOUND");
					return "/user";					
			}
			}else {
				model.addAttribute("Message", "ALL FIELDS REQUIRED");
				return "/user";
			}
		} else {
			model.addAttribute("Message", "ALL FIELDS REQUIRED");
			return "/user";
		}
	
	}
}
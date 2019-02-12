package com.mkyong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.onyx.bootapp.dao.UserDao;
import it.onyx.bootapp.form.UserForm;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home")
	public String showHome(@ModelAttribute UserForm userForm, Model model, @ModelAttribute("ud") UserDao ud) {
		
		System.out.println("get di home");
		System.out.println(ud.getEmail());
		model.addAttribute("firstName", ud.getNome());
		model.addAttribute("lastName", ud.getCognome());
		model.addAttribute("email", ud.getEmail());
		model.addAttribute("number", ud.getNum_telefono());
		model.addAttribute("password", ud.getPassword());
		model.addAttribute("id", ud.getId_cliente());

			return "home";
		
	}
	

}

package com.kakao.map.search.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kakao.map.search.login.entity.User;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam String id, @RequestParam String passwd) {
		
		User user = loginService.login(id, passwd);
		
		ModelAndView view = new ModelAndView();
		
		if(user == null) {
			view.setViewName("redirect:/");
		}
		else {
			view.setViewName("main");
			view.addObject("user", user);
		}
		
		return view;
	}
}

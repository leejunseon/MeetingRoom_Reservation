package practice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	
	@GetMapping("/customAccessError")
	public void accessDenied(Authentication auth,Model model) {
		model.addAttribute("msg","AccessDenied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error,String logout,Model model) {
		if(error!=null)
			model.addAttribute("error","Login Error Check Your Account");
		if(logout!=null)
			model.addAttribute("logout","Logout!!");
	}
	
	@PostMapping("/customLogout")
	public void logoutPost() {
		
	}

}
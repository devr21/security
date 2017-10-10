package learn.spring.auth.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@RequestMapping(path="/accessDenied",method=RequestMethod.GET)
	public String getSuccessPage(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      System.out.println(name);
	      model.addAttribute("user",name);
		return "accessDenied";
	}
	
}

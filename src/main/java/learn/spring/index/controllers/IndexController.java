package learn.spring.index.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndexPage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("message","Secure Web Application");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    model.addObject("user",name);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(path="/login" ,method=RequestMethod.GET)
	public String getAuthPage(@RequestParam(value="error",required=false) boolean error,ModelMap map) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName() != "anonymousUser") {
			return "redirect:/";
		}
		if(error == true) {
			map.addAttribute("error","Invalid Username or Password");
		}
		return "login";
	}
	
}

package com.anderson.routing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CounterController {
	
	@RequestMapping("/")
    public String index(HttpSession session, Model model) {
		if (session.getAttribute("permission") == null) {
			session.setAttribute("permission", false);
		} else if (session.getAttribute("permission").equals(false)) {
			model.addAttribute("wrong", true);
		}
        return "index.jsp";
    }
	
	@RequestMapping("/code")
	public String count(Model model, HttpSession session) {
		boolean peanut = (boolean) session.getAttribute("permission");
		if (!peanut) {
//			session.setAttribute("count", 0);
			return "redirect:/";
		}
		return "count.jsp";
	}
	
	@RequestMapping(value = "/passsubmit", method=RequestMethod.POST) 
	public String pass(HttpSession session, @RequestParam(value="passcode") String passcode) {
		if (passcode.equals("bushido")) {
			session.setAttribute("permission", true);
			return "redirect:/code";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/clare") 
	public String clear(HttpSession session) {
		session.setAttribute("permission", null);
		return "redirect:/";
	}
	
	
}

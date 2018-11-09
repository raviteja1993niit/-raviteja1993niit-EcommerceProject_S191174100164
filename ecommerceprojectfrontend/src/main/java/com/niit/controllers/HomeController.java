package com.niit.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController 
{
	public HomeController() {
		System.out.println("Home Controller Bean has been created");
	}
	@RequestMapping(value="/home")
	public String getHomePage(Model m)
	{
		
		return "home";
	}
	@RequestMapping(value="/login")
	public String loginPage(Model m)
	{
		
		return "loginpage";
	}
	@RequestMapping(value="/loginerror")
	public String loginErrorPage(Model m)
	{
		m.addAttribute("loginError", "INVALID EMAIL ADDRESS OR PASSWORD...................");
		return "loginpage";
	}
	@RequestMapping(value="/log-out")
	public String loginoutPage(Model m)
	{
		m.addAttribute("message", "LOGGED-OUT SUCCESSFULLY...................");
		return "loginpage";
	}
}

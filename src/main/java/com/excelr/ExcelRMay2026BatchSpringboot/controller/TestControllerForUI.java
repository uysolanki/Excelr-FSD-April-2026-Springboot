package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Player;

@Controller   //to return a webpage
public class TestControllerForUI {

	@RequestMapping("/testui")  //endpoint
	public String testui()
	{
		return "ashish";
	}
	
	@RequestMapping("/rcb")  //endpoint
	public String rcb(Model model)
	{
		String playerName="Rajat Patidar";
		model.addAttribute("player",playerName);
		return "ashish"; //there should be an html file by this name in the resources/templates folder
	}
	
	@RequestMapping("/mi")  //endpoint
	public String mi(ModelMap modelmap)
	{
		//String playerName="Rohit Sharma";
		Player p1=new Player(45,"Rohit Sharma", 100,5000);
		modelmap.addAttribute("player",p1);
		return "ipl"; //there should be an html file by this name in the resources/templates folder
	}
	
	
	@RequestMapping("/csk")  //endpoint
	public ModelAndView csk()
	{
		//String playerName="Rohit Sharma";
		Player p1=new Player(7,"MSD", 200,8000);
		ModelAndView mav =new ModelAndView();
		mav.setViewName("ipl");
		mav.addObject("player",p1);
		
		return mav; //there should be an html file by this name in the resources/templates folder
	}
}

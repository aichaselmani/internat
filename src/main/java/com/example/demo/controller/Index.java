package com.example.demo.controller;
   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.service.*;
@Controller
public class Index { 
	String eMotPass;
	Admin admin;
	 
	@Autowired
	AdminService adminService;
	@Autowired
	EtudiantService etudiantService;
	@GetMapping("/first")
	public String firstGet(Model model) {
		
		return "pages/first";
	}
	
	@GetMapping("/Index")
	public String indexGet(Model model) {
		model.addAttribute("Admin",new Admin());
		
		return "pages/index";
	}
	@PostMapping("/Index")
public String indexPost(@ModelAttribute Admin Admin1) {
	admin= new Admin(Admin1.getUser(),Admin1.getPassWord());
	Etudiant e= new Etudiant(Admin1.getUser(),Admin1.getPassWord());
		
	if(adminService.existAdmin(admin))	
	{
      return "pages/Admin";          
     }
	else {
		if(etudiantService.existEtudiant(e))	
		{
	      return "pages/Etudiant";
	      }
	else{
		return "redirect:Index";
		}
		}
	}
}

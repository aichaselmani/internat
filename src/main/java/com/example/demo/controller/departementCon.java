package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.*;
import com.example.demo.service.DepartementService;
@Controller
public class departementCon {
	@Autowired
	DepartementService departementService;
	
	private String errorMessage="";
	private String supprimeChambre="";
	@GetMapping("/departement")
	public String postD(Model model) {
		model.addAttribute("etage",new Etage());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		model.addAttribute("chambre",new Chambre());
		model.addAttribute("supprimeChambre",supprimeChambre);
		return "pages/departemet";
	}
	@GetMapping("/adminRetour")
	public String postA(Model model) {
		
		return "pages/admin";
	}
	@PostMapping("/departement1")
public String departementAjout(@ModelAttribute Departement departement,Model model) 
	{ Departement d=new Departement(departement.getNumDepartement(),departement.getNombreEtage());
		errorMessage=departementService.ajouter(d);
		model.addAttribute("etage",new Etage());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		model.addAttribute("chambre",new Chambre());
		return "pages/departemet";
	}
	@PostMapping("/supDep")
	public String departementsupp(@ModelAttribute Departement departement,Model model) 
		{ Departement d=new Departement(departement.getNumDepartement());
			errorMessage=departementService.supprimer(d);
			model.addAttribute("etage",new Etage());
			model.addAttribute("departement",new Departement());
			model.addAttribute("errorMessage",errorMessage);
			model.addAttribute("chambre",new Chambre());
			return "pages/departemet";
		}
	@PostMapping("/departementModifier")
	public String departementP(@ModelAttribute Departement departement,Model model) {
		Departement d=new Departement(departement.getNumDepartement(),departement.getNombreEtage());
		errorMessage=departementService.modifier(d);
		model.addAttribute("etage",new Etage());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		model.addAttribute("chambre",new Chambre());
		return "pages/departemet";
	}
	
}

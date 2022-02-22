package com.example.demo.controller;
import com.example.demo.model.*;

import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EtageController {
	@Autowired
EtageService etageService;
	@Autowired
	DepartementService departementService;
	private String errorMessage;
	private String supprimeChambre;
	@PostMapping("/etageAjout")
public String 	Ajoutetage(@ModelAttribute Etage etage,Model model) {
		Etage e=new Etage(etage.getNumEtage(),etage.getCapacite(),etage.getDepartement());
		errorMessage=etageService.ajouter(e);
		model.addAttribute("etage",new Etage());
		model.addAttribute("chambre",new Chambre());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		
		return "pages/departemet";
	
	}
	@PostMapping("/etagesupprimer")
public String 	supprimeretage(@ModelAttribute Etage etage,Model model) {
		
		Etage e=new Etage(etage.getNumEtage());
		errorMessage=etageService.supprimer(e);
		model.addAttribute("etage",new Etage());
		model.addAttribute("chambre",new Chambre());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		
		return "pages/departemet";
	
	}
	@PostMapping("/etagemodifier")
public String 	modifieretage(@ModelAttribute Etage etage,Model model) {
		
		Etage e=new Etage(etage.getNumEtage(),etage.getCapacite());
		errorMessage=etageService.modifier(e);
		model.addAttribute("etage",new Etage());
		model.addAttribute("chambre",new Chambre());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		
		return "pages/departemet";
	
	}
}

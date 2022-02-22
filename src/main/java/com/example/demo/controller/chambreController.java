package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Departement;
import com.example.demo.model.*;
 
import com.example.demo.service.*;

@Controller
public class chambreController {
	@Autowired
	EtageService etageService;
	@Autowired
	ChambreService chambreService;
	private String errorMessage;
	private String supprimeChambre;
	@PostMapping("/ajoutChambre")
public String 	Ajoutetage(@ModelAttribute Chambre chambre ,Model model) {
		
		Chambre e=new Chambre(chambre.getNumChambre(),chambre.getCapacite(),chambre.getEtage());
		errorMessage=chambreService.ajouter(e);
		model.addAttribute("etage",new Etage());
		model.addAttribute("chambre",new Chambre());
		model.addAttribute("departement",new Departement());
		model.addAttribute("errorMessage",errorMessage);
		model.addAttribute("supprimeChambre",supprimeChambre);
		return "pages/departemet";
	
	}
	
	@PostMapping("/chambresupprimer")
	public String 	supprimerChambre(@ModelAttribute Chambre chambre ,Model model) {
			
			Chambre e=new Chambre(chambre.getNumChambre());
			errorMessage=chambreService.supprimer(e);
			
			model.addAttribute("etage",new Etage());
			model.addAttribute("chambre",new Chambre());
			model.addAttribute("departement",new Departement());
			model.addAttribute("errorMessage",errorMessage);
			
			return "pages/departemet";
		
		}
	@PostMapping("/chambremodifier")
	public String 	modifierChambre(@ModelAttribute Chambre chambre ,Model model) {
			
			Chambre e=new Chambre(chambre.getNumChambre(),chambre.getCapacite());
			errorMessage=chambreService.modifier(e);
			
			model.addAttribute("etage",new Etage());
			model.addAttribute("chambre",new Chambre());
			model.addAttribute("departement",new Departement());
			model.addAttribute("errorMessage",errorMessage);
			
			return "pages/departemet";
		
		}
}

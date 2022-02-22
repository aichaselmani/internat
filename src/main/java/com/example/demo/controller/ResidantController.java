package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.*;
import com.example.demo.service.ResidantService;
 

@Controller
public class ResidantController {
	@Autowired
	ResidantService residantService;
	String message;
	@GetMapping("/Residant")
	public String postD(Model model) {
		model.addAttribute("Etudiant",new Etudiant());
		 
		return "pages/residant";
	}
	@PostMapping("/ajouter")
public String Ajout(@ModelAttribute Etudiant etudiant,Model model) 
	{
		message= residantService.ajouter(etudiant);
		model.addAttribute("Etudiant",new Etudiant());
		
		model.addAttribute("message",message);
	
		return "pages/residant";
	}
	@PostMapping("/modifier")
	public String modifier(@ModelAttribute Etudiant etudiant,Model model) 
		{ 
		message=residantService.modifier(etudiant);
			 
			model.addAttribute("Etudiant",new Etudiant());
			model.addAttribute("EtudiantChambre",new EtudiantChambre());
			model.addAttribute("message",message);
		
			return "pages/residant";
		}
	@PostMapping("/supprimer")
	public String supprimer(@ModelAttribute Etudiant etudiant,Model model) 
		{ 
		message=residantService.supprimer(etudiant);
			 
			model.addAttribute("Etudiant",new Etudiant());
			model.addAttribute("EtudiantChambre",new EtudiantChambre());
			model.addAttribute("message",message);
		
			return "pages/residant";
		}
	@PostMapping("/affectuer")
	public String affectuer(@ModelAttribute EtudiantChambre etudiantChambre,Model model) 
		{ 
		message=residantService.affectuer(etudiantChambre);
			 
			model.addAttribute("Etudiant",new Etudiant());
			model.addAttribute("EtudiantChambre",new EtudiantChambre());
			model.addAttribute("message",message);
		
			return "pages/residant";
		}
	@PostMapping("/rechercher1")
	public String rechercher1(@ModelAttribute Etudiant etudiantChambre,Model model) 
		{ 
		message=residantService.infoChambres(etudiantChambre);
			 
			model.addAttribute("Etudiant",new Etudiant());
			model.addAttribute("EtudiantChambre",new EtudiantChambre());
			model.addAttribute("message",message);
		
			return "pages/residant";
		}
}

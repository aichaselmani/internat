package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.service.*;
@Controller
public class indexEtudiant {
	@Autowired
	EtudiantService etudiantService;
	@PostMapping("/indexEtudiant")
public String indexPost(@ModelAttribute Etudiant etudiant) {
		Etudiant e= new Etudiant(etudiant.geteMail(),etudiant.getePassWord());
		
		
	if(etudiantService.existEtudiant(e))	{
      return "pages/Etudiant";}
	else {return "redirect:Index";}
		}

}

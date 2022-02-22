package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.*;
import com.example.demo.repos.*;

@Service
public class ChambreService {
	@Autowired
	EtageRepos etageRepos;
 
	@Autowired
	ChambreRepos chambreRepos;
	@Autowired
    EtageService etageService ;

	public boolean exist(Chambre chambre) {
		boolean exist=false;
		
			exist=chambreRepos.existsById(chambre.getNumChambre());
			
			
		return exist;
	}
	public Etage trouverEtage(Chambre chambre) {
		Etage etage=etageService.etageById(chambre.getEtage().getNumEtage());
		return etage;
	}
	
	public String ajouter(Chambre chambre) {
		String errorMessage;
		if (exist(chambre)) {errorMessage="la chambre exist deja";}
		else {	if (!etageService.exist(chambre.getEtage())) {errorMessage="l'etage  n'exist pas";}
		else {if (trouverEtage(chambre).getCapacite()==etageService.nombreChambre(trouverEtage(chambre)))
		{errorMessage="vous avez depassé la capacité de l'etage";}
		else{chambreRepos.save(chambre);
				errorMessage="l'ajout bien fait";
			}}
		}
		
		return  errorMessage;}
	
 
	
	
	public String supprimer(Chambre chambre) {
		String message="";
		if(exist(chambre)) {
		chambreRepos.deleteById(chambre.getNumChambre());
		message="la suppression est bien faite";}else {
			message="la chambre n'exist pas";
		}
		return message;
		
	}
	public String modifier(Chambre chambre) {
		String message;
		if(!exist(chambre)) {
			message="la chambre n'exist pas";
		}
		else {
			Chambre c=chambreRepos.getById(chambre.getNumChambre());
			c.setCapacite(chambre.getCapacite());
			chambreRepos.save(c);
			message="la modification est bien faite";
		}return message;
		
	}
	
	
}

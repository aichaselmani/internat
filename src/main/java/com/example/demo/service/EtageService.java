package com.example.demo.service;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repos.*;
@Service
public class EtageService {
	@Autowired
	EtageRepos etageRepos;
	@Autowired
	DepartementService departementService;
	@Autowired
	ChambreRepos chambreRepos;
 
	@Autowired
	DepartementRepos departementRepos;

	public boolean exist(Etage etage) {
		boolean exist=false;
		
			exist=etageRepos.existsById(etage.getNumEtage());
			
			
		return exist;
	}
	
	public String ajouter(Etage etage) {
		String errorMessage;
		if (exist(etage)) {errorMessage="l'etage exist deja";}
		else {	if (!departementService.exist(etage.getDepartement())) {errorMessage="le departement n'exist pas";}
		else {if (departementRepos.getById(etage.getDepartement().getNumDepartement()).getNombreEtage()==departementService.nombreEtage(departementRepos.getById(etage.getDepartement().getNumDepartement())))
		{errorMessage="vous avez depassé la capacité de departement";}
		else{etageRepos.save(etage);
				errorMessage="l'ajout bien fait";
			}}
		}
		
		return  errorMessage;}
	
  public Etage etageById(String id) {
	  Etage etage=etageRepos.getById(id);
	  return etage;
  }
	
	

	public int nombreChambre(Etage etage) {
		List <Chambre> chambres=chambreRepos.findAll();
		List<Chambre>  etageChambres=new ArrayList<Chambre>();
		for(int i=0;i<chambres.size();i++) {
			if(chambres.get(i).getEtage().getNumEtage().equals(etage.getNumEtage())) {
				etageChambres.add(chambres.get(i));
			}
		}return etageChambres.size();		}
	public List<Chambre> etageChambres(Etage etage) {
		List <Chambre> chambres=chambreRepos.findAll();
		List<Chambre>  etageChambres=new ArrayList<Chambre>();
		for(int i=0;i<chambres.size();i++) {
			if(chambres.get(i).getEtage().getNumEtage().equals(etage.getNumEtage())) {
				etageChambres.add(chambres.get(i));
			}
		}return etageChambres;		}
	public Departement trouverDepartement(Etage etage) {
		Departement dep=departementRepos.getById(etage.getDepartement().getNumDepartement());
		return dep;
	}
	public String supprimer(Etage etage) {
		String message;
		if (!exist(etage)) {
			message="l'etage n'exist pas";
		}else {
			List <Chambre> chambres= etageChambres( etage);
			for(int i=0;i<chambres.size();i++) {
				chambreRepos.deleteById(chambres.get(i).getNumChambre());
			}etageRepos.deleteById(etage.getNumEtage());
			message="la suppression bien faite";
		}
		return message;
	}
	public String modifier(Etage etage) {
		String message;
		if (!exist(etage)) {
			message="l'etage n'exist pas";
		}else {
			Etage etag=etageRepos.getById(etage.getNumEtage());
			etag.setCapacite(etage.getCapacite());
			etageRepos.save(etag);
			message="la modification bien faite";
		}
		return message;
	}
}

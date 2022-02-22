package com.example.demo.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repos.*;

@Service
public class DepartementService {
	@Autowired
DepartementRepos departementRepos;
	@Autowired
EtageRepos etageRepos;
	@Autowired
ChambreRepos chambreRepos;
	public boolean exist(Departement d) {
		
		boolean exist=departementRepos.existsById(d.getNumDepartement());
	return exist;
		
	}
	public String ajouter(Departement departement) {
		String messageErreur;
		if(!exist(departement)) {
		departementRepos.save(departement); messageErreur="l'ajoutest bien fait";}
		else { messageErreur="le departement déja existe";}
		return messageErreur;
	}
	public int nombreEtage(Departement departement) {
		List <Etage> etages=etageRepos.findAll();
		List <Etage> etagesDepartement=new ArrayList <Etage>();
		for(int i =0;i<etages.size();i++) {
			if( etages.get(i).getDepartement().getNumDepartement().equals(departement.getNumDepartement())) {
				etagesDepartement.add(etages.get(i));
			}
		}
		return etagesDepartement.size();
	}public List <Etage> departementEtage(Departement departement) {
		List <Etage> etages=etageRepos.findAll();
		List <Etage> etagesDepartement=new ArrayList <Etage>();
		for(int i =0;i<etages.size();i++) {
			if( etages.get(i).getDepartement().getNumDepartement().equals(departement.getNumDepartement())) {
				etagesDepartement.add(etages.get(i));
			}
		}
		return etagesDepartement;
	}
	public List<Chambre> etageChambres(Etage etage) {
		List <Chambre> chambres=chambreRepos.findAll();
		List<Chambre>  etageChambres=new ArrayList<Chambre>();
		for(int i=0;i<chambres.size();i++) {
			if(chambres.get(i).getEtage().getNumEtage().equals(etage.getNumEtage())) {
				etageChambres.add(chambres.get(i));
			}
		}return etageChambres;		}
	public String supprimer(Departement departement) {
		String message;
		if(!exist(departement)) {
			message="le departement n'exist pas";
			
		}else {List <Etage> etages=departementEtage(departement);
		for(int i =0;i<etages.size();i++) {
			List <Chambre> chambres= etageChambres( etages.get(i));
			for(int j=0;j<chambres.size();j++) {
				chambreRepos.deleteById(chambres.get(j).getNumChambre());
			}etageRepos.deleteById(etages.get(i).getNumEtage());
			
		}departementRepos.deleteById(departement.getNumDepartement());
		message="la suppression est bien faite";
		}return message;
		}
		
	
	public String  modifier(Departement departement) {
		String message;
		if(!exist(departement)) {
			message="le departement n'exist pas";
			
		}else {Departement d=departementRepos.getById(departement.getNumDepartement());
		d.setNombreEtage(departement.getNombreEtage());
		message="la modification est bien faite";
		}return message;
		
	}
}

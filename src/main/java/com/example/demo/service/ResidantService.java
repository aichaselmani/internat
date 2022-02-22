package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repos.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
@Service
public class ResidantService {
	@Autowired
	EtudiantRepos etudiantRepos;
	@Autowired
	EtudiantChambreRepos  etudiantChambreRepos;
	@Autowired
	ChambreService chambreService;
	public boolean exist(Etudiant etudiant) {
		boolean exist=etudiantRepos.existsById(etudiant.geteCIN()) ;
		return exist;
			
		
	}
	public String ajouter(Etudiant etudiant) {
		String message;
		if(exist(etudiant)) {
			message="le residant déja exist";
		}else {
			message="l'ajout est bien fait";
			etudiantRepos.save(etudiant);
		}return message;
	}
   public String modifier(Etudiant etudiant) {
		String message;
		if(!exist(etudiant)) {
			message="le residant n' exist pas";
		}else {
			message="la modification  est bien faite";
			etudiantRepos.save(etudiant);
		}return message;
		
	}
	
	public String supprimer(Etudiant etudiant) {
		String message;
		if(!exist(etudiant)) {
			message="le residant n' exist  pas";
		}else {
			
			etudiantRepos.deleteById(etudiant.geteCIN());
			message="la suppression  est bien faite";
			
		}return message;
		
	}
	public List<EtudiantChambre> chambres(Etudiant etudiant){
		List  <EtudiantChambre>  chambres=etudiantChambreRepos.findAll();
		List <EtudiantChambre> chambresEtudiant=new ArrayList <EtudiantChambre>();
		for(int i=0;i<chambres.size();i++) {
			if(chambres.get(i).getEtudiant().geteCIN().equals(etudiant.geteCIN())) {
				chambresEtudiant.add(chambres.get(i));
			}
		}return chambresEtudiant;
	}
	public List<EtudiantChambre> residants(Chambre chambre){
		List  <EtudiantChambre>  chambres=etudiantChambreRepos.findAll();
		List <EtudiantChambre> chambresEtudiant=new ArrayList <EtudiantChambre>();
		for(int i=0;i<chambres.size();i++) {
			if(chambres.get(i).getChambre().getNumChambre().equals(chambre.getNumChambre())){
				chambresEtudiant.add(chambres.get(i));
			}
		}return chambresEtudiant;
	}
	public boolean remplieChambre(Chambre chambre) {
		List <EtudiantChambre> EtudiantsChambre=residants(chambre);
		boolean remplie=false;
		int c=0;
		for(int i=0;i<EtudiantsChambre.size();i++) {
			if (EtudiantsChambre.get(i).getDateFin()==null) {
				c++;
				
			}}if(c>=chambre.getCapacite()) {
				remplie=true;
			}
		return remplie;
	}
	public boolean admetChambre(Etudiant etudiant) {
		List <EtudiantChambre> chambresEtudiant=chambres(etudiant);
		boolean admet=false;
		for(int i=0;i<chambresEtudiant.size();i++) {
			if(chambresEtudiant.get(i).getDateFin()==null) {
				admet=true;
			}
		}return admet;
	}
	public 	EtudiantChambre chambreactuel(Etudiant  etudiant) {
		EtudiantChambre e=new EtudiantChambre();
		List <EtudiantChambre> chambresEtudiant=chambres(etudiant);
		
		for(int i=0;i<chambresEtudiant.size();i++) {
			if(chambresEtudiant.get(i).getDateFin()==null) {
				e=chambresEtudiant.get(i);
			}
	}return e;}
	public List<EtudiantChambre> residantActuel(Chambre chambre) {
		 
		List <EtudiantChambre> EtudiantsChambre=residants(chambre);
		List <EtudiantChambre> c=new ArrayList<EtudiantChambre>();
		for(int i=0;i<EtudiantsChambre.size();i++) {
			if (EtudiantsChambre.get(i).getDateFin()==null) {
			c.add(EtudiantsChambre.get(i))	;		
			}}return c;
	}
	public String affectuer(EtudiantChambre etudiantChambre) {
		String message;
		if (!exist(etudiantChambre.getEtudiant())){
			message="l'etudiant n'exist pas";
			}else {
				if(!chambreService.exist(etudiantChambre.getChambre())) {
					message="la chambre n'exsit pas";
				}else {
					if (remplieChambre(etudiantChambre.getChambre())) {
						message="la chambre est remplie";
					}
					else {if (admetChambre(etudiantChambre.getEtudiant())) {
						
						EtudiantChambre chambrenoC=chambreactuel(etudiantChambre.getEtudiant());
						chambrenoC.setDateFin(new Date());
						etudiantChambreRepos.save(chambrenoC);
					}
						
						EtudiantChambre e=new EtudiantChambre(etudiantChambre.getEtudiant(),etudiantChambre.getChambre(),new Date(),null);
					
						etudiantChambreRepos.save(e);
						message="l'affectation est bien faite";
					}
				}
			}return message;
		}
	public String infoResidant(Etudiant etudiant) {
		String message="";
		if (!exist(etudiant)) {
			message="le  résidant n'exist pas";
			
		}else {
			message="<strong>Nom<strong> :"+etudiantRepos.getById(etudiant.geteCIN()).geteNom()+"</br><strong>prenom<strong> :"+etudiantRepos.getById(etudiant.geteCIN()).getePrenom()+"</br><strong>CIN<strong> :"+etudiant.geteCIN()+"</br><strong>email<strong> :"+etudiantRepos.getById(etudiant.geteCIN()).geteMail()+"</br><strong>niveau<strong> :"+etudiantRepos.getById(etudiant.geteCIN()).getePrenom()+"annee"+"</br><strong>prenom<strong> :"+etudiantRepos.getById(etudiant.geteCIN()).getePassWord();
		}return message;
	}
public String infoChambres(Etudiant etudiant) {
	String message="";
	if (!exist(etudiant)) {
		message="le  résidant n'exist pas";
		
	}
	else {DateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		message="<strong> la chambre actuel:</strong>"+chambreactuel(etudiant).getChambre().getNumChambre()+"</br>";
		List <EtudiantChambre> c=residantActuel(chambreactuel(etudiant).getChambre());
		message=message+"<strong>les couches chambres sont :</strong> <br/>";
		for(int i=0;i<c.size();i++) {
			if(!c.get(i).getEtudiant().geteCIN().equals(etudiant.geteCIN())) {
				message=message+c.get(i).getEtudiant().geteCIN()+" "+c.get(i).getEtudiant().geteNom()+" "+c.get(i).getEtudiant().getePrenom()+"</br>";
			}
		}
		List <EtudiantChambre> chambresEtudiant=chambres(etudiant);
		message=message+"<table><tr><th>chambre</th><th>date debut</th><th>date fin</th></tr>";
			
		for(int i=0;i<chambresEtudiant.size();i++) {
			message=message+"<tr>"+"<td/>"+chambresEtudiant.get(i).getChambre().getNumChambre()+"</td>"+"<td>"+format.format(chambresEtudiant.get(i).getDateDebut())+"</td>"+"<td>"+format.format(chambresEtudiant.get(i).getDateFin())+"</td></tr>";
		}message=
				message+"/table>";
	}return message;
}
}

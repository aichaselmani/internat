package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
 	@Id
	String numCommande;
	String typeCommande;
	@ManyToOne 
	@JoinColumn(name="eCIN") 
	Etudiant etudiant;
	 
	
	public Commande(String numCommande, String typeCommande, Etudiant etudiant) {
		super();
		this.numCommande = numCommande;
		this.typeCommande = typeCommande;
		this.etudiant = etudiant;
	}
	public String getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}
	public String getTypeCommande() {
		return typeCommande;
	}
	public void setTypeCommande(String typeCommande) {
		this.typeCommande = typeCommande;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	

}

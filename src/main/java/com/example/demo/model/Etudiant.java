package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etudiant {
	@Id
private String eCIN;
private String ePrenom;
private String eNom;
private String eNiveau;
private String eMail;
private String ePassWord;
@OneToMany(targetEntity=Commande.class,mappedBy="etudiant" ,cascade = CascadeType.REMOVE)
private List <Commande> commandes=new ArrayList<Commande>();
@OneToMany(targetEntity=EtudiantChambre.class,mappedBy="etudiant",cascade = CascadeType.REMOVE)
private List <EtudiantChambre> chambres=new ArrayList<EtudiantChambre>();
public Etudiant() {
	super();
	// TODO Auto-generated constructor stub
}

public Etudiant(String name, String ePassWord) {
	super();
	this.ePrenom = name;
	this.ePassWord = ePassWord;
}

public Etudiant(String eCIN, String ePrenom, String eNom, String eNiveau, String eMail, String ePassWord) {
	super();
	this.eCIN = eCIN;
	this.ePrenom = ePrenom;
	this.eNom = eNom;
	this.eNiveau = eNiveau;
	this.eMail = eMail;
	this.ePassWord = ePassWord;
}

public String geteCIN() {
	return eCIN;
}

public void seteCIN(String eCIN) {
	this.eCIN = eCIN;
}

public List<Commande> getCommandes() {
	return commandes;
}

public void setCommandes(List<Commande> commandes) {
	this.commandes = commandes;
}

public String getePrenom() {
	return ePrenom;
}
public void setePrenom(String ePrenom) {
	this.ePrenom = ePrenom;
}
public String geteNom() {
	return eNom;
}
public void seteNom(String eNom) {
	this.eNom = eNom;
}
public String geteNiveau() {
	return eNiveau;
}
public void seteNiveau(String eNiveau) {
	this.eNiveau = eNiveau;
}
public String geteMail() {
	return eMail;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
public String getePassWord() {
	return ePassWord;
}
public void setePassWord(String ePassWord) {
	this.ePassWord = ePassWord;
}

}

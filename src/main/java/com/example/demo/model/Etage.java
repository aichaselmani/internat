package com.example.demo.model;

import java.util.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Etage {
@Id
private String numEtage;
private int capacite;
@ManyToOne 
@JoinColumn(name="numDepartement",nullable=false)  
protected Departement departement;

@OneToMany(targetEntity=Chambre.class,mappedBy="etage")
private List <Chambre> chambre=new ArrayList<Chambre>();

 

public Etage(String numEtage, int capacite) {
	super();
	this.numEtage = numEtage;
	this.capacite = capacite;
}
public Etage(String numEtage) {
	super();
	this.numEtage = numEtage;
}
public Etage() {
	super();
	// TODO Auto-generated constructor stub
}
public Etage(String numEtage, int capacite, Departement departement) {
	super();
	this.numEtage = numEtage;
	this.capacite = capacite;
	this.departement = departement;
}
public void addChambre(int capacite,String numChambre) {
	if (chambre.size()<=this.capacite) {
	  Chambre ch=new Chambre(numChambre,capacite,this);
	  chambre.add(ch);
	  }
 }
public void suppChambre(String numChambre) {
	boolean find=false;
	int i=0;
	while(i<chambre.size()) {
		if(chambre.get(i).getNumChambre()==numChambre) {chambre.remove(i);find=true;
			break;
			
		}i++;
	}
}
public int getCapacite() {
	return capacite;
}

public void setCapacite(int capacite) {
	this.capacite = capacite;
}

public String getNumEtage() {
	return numEtage;
}

public void setNumEtage(String numEtage) {
	this.numEtage = numEtage;
}
public Departement getDepartement() {
	return departement;
}
public void setDepartement(Departement departement) {
	this.departement = departement;
}
public List<Chambre> getChambre() {
	return chambre;
}
public void setChambre(List<Chambre> chambre) {
	this.chambre = chambre;
}

}

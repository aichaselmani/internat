package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Chambre {
@Id
private String  numChambre;
private int capacite;
@ManyToOne 
@JoinColumn(name="numEtage")  
protected Etage etage;
@OneToMany(targetEntity=EtudiantChambre.class,mappedBy="chambre",cascade = CascadeType.REMOVE)
private List <EtudiantChambre> etudiants=new ArrayList<EtudiantChambre>();
 
public Chambre() {
	super();
	// TODO Auto-generated constructor stub
}

public Chambre(String numChambre) {
	super();
	this.numChambre = numChambre;
}

public Chambre(String numChambre, int capacite) {
	super();
	this.numChambre = numChambre;
	this.capacite = capacite;
}

public Chambre(String numChambre, int capacite, Etage etage) {
	super();
	this.numChambre = numChambre;
	this.capacite = capacite;
	this.etage = etage;
}
public String getNumChambre() {
	return numChambre;
}
public void setNumChambre(String numChambre) {
	this.numChambre = numChambre;
}
public int getCapacite() {
	return capacite;
}
public void setCapacite(int capacite) {
	this.capacite = capacite;
}
public Etage getEtage() {
	return etage;
}
public void setEtage(Etage etage) {
	this.etage = etage;
}


}

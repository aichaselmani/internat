package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

 @Entity
public class Departement {
@Id
private String numDepartement;
private int nombreEtage;
@OneToMany(targetEntity=Etage.class, mappedBy="departement")
private List <Etage> etages=new ArrayList<Etage>();
 


public Departement() {
	super();
	// TODO Auto-generated constructor stub
}


public Departement(String numDepartement) {
	super();
	this.numDepartement = numDepartement;
}


public List<Etage> getEtages() {
	return etages;
}


public void setEtages(List<Etage> etages) {
	this.etages = etages;
}


public Departement(String numDepartement, int nombreEtage) {
	super();
	this.numDepartement = numDepartement;
	this.nombreEtage = nombreEtage;
}


public void addEtage(int capacite,String numChambre) {
	if (etages.size()<=this.nombreEtage) {
	  Etage ch=new Etage(numChambre,capacite,this);
	  etages.add(ch);
	  }
 }
public void suppEtage(String numEtage) {
	boolean find=false;
	int i=0;
	while(i<etages.size()) {
		if(etages.get(i).getNumEtage()==numEtage) {etages.remove(i);find=true;
			break;
			
		}i++;
	}
}
public int getNombreEtage() {
	return nombreEtage;
} 
public void setNombreEtage(int nombreEtage) {
	this.nombreEtage = nombreEtage;
}

public String getNumDepartement() {
	return numDepartement;
}

public void setNumDepartement(String numDepartement) {
	this.numDepartement = numDepartement;
}

}

package com.example.demo.model;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@IdClass( EtudiantChambrePC.class)
public class EtudiantChambre {
  @Id
	@ManyToOne 
	@JoinColumn(name="eCIN")  
Etudiant etudiant;
	@Id
	@ManyToOne 
	@JoinColumn(name="numChambre") 
Chambre chambre;
Date dateDebut;
Date dateFin;

public EtudiantChambre() {
	super();
	// TODO Auto-generated constructor stub
}
public EtudiantChambre(Etudiant etudiant, Chambre chambre, Date dateDebut, Date dateFin) {
	super();
	this.etudiant = etudiant;
	this.chambre = chambre;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
}
public Etudiant getEtudiant() {
	return etudiant;
}
public void setEtudiant(Etudiant etudiant) {
	this.etudiant = etudiant;
}
public Chambre getChambre() {
	return chambre;
}
public void setChambre(Chambre chambre) {
	this.chambre = chambre;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}

}

package com.example.demo.model;

import java.io.Serializable;
public class EtudiantChambrePC  implements Serializable{
	String etudiant ;
	String chambre;
	public EtudiantChambrePC(String etudiant, String chambre) {
		super();
		this.etudiant = etudiant;
		this.chambre = chambre;
	}
	

}

package com.example.demo.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repos.*;
@Service
public class EtudiantService {
@Autowired
EtudiantRepos etudiantRepos;
public boolean existEtudiant(Etudiant etudiant) {
	
	List<Etudiant> etudiants=etudiantRepos.findAll();
	boolean exist=false;
	int i=0;
	while( i<etudiants.size()&& !exist) {
		
		if(etudiants.get(i).geteMail().equals(etudiant.geteMail())&&etudiants.get(i).getePassWord().equals(etudiant.getePassWord())) {
			exist=true;
			
		}i++;
	}return exist;
	
}

}

package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EtudiantChambre;
import com.example.demo.model.EtudiantChambrePC;

public interface EtudiantChambreRepos extends JpaRepository<EtudiantChambre, EtudiantChambrePC> {

}

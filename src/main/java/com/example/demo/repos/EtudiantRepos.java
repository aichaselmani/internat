package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Etudiant;

public interface EtudiantRepos extends JpaRepository<Etudiant, String> {

}

package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Commande;

public interface CommandeRepos extends JpaRepository<Commande, String> {

}

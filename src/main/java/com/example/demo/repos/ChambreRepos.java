package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Chambre;


public interface ChambreRepos extends JpaRepository<Chambre, String> {

}

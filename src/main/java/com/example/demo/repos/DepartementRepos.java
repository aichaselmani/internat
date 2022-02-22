package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Departement;

public interface DepartementRepos extends JpaRepository<Departement, String> {

}

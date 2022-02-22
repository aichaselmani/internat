package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Admin;

public interface AdminRepos extends JpaRepository<Admin, String> {

}

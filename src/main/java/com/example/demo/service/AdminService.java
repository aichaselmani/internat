package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.Admin;
import com.example.demo.repos.AdminRepos;

@Service
public class AdminService {
@Autowired
private AdminRepos adminRepos;

public AdminService() {
	super();
	
}
public List<Admin> getAllAdmin(){
	return adminRepos.findAll();
}
public boolean existAdmin(Admin admin) {
	List<Admin> admins=adminRepos.findAll();
	boolean exist=false;
	int i=0;
	while( i<admins.size()&& !exist) {
		
		if(admins.get(i).getUser().equals(admin.getUser())&&admins.get(i).getPassWord().equals(admin.getPassWord())) {
			exist=true;
			
		}i++;
	}return exist;
	
}

}

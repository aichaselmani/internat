package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
@Id
private String user;
private String passWord;

public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(String user, String passWord) {
	super();
	this.user = user;
	this.passWord = passWord;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}

}

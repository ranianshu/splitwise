package com.scaler.splitwise.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Group extends BaseModel{
	
	private String name;
	private String description;
	@ManyToMany
	private List<User> users;
	@ManyToMany
	private List<User> admins;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<User> getAdmins() {
		return admins;
	}
	public void setAdmins(List<User> admins) {
		this.admins = admins;
	}

}

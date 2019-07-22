package com.brados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quiz_user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	@Column(name="user_name")
	private String user_name;	
	
	public int getId() {
		return user_id;
	}
	public void setId(int user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String name) {
		this.user_name = name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + user_id + ", name=" + user_name + "]";
	}

}

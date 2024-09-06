package com.construclick.construclick.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id_user")
private Long id;

@Column(name="username", length=60, nullable=false, unique=true)
private String username;

@Column(name="password", length=10, nullable=false, unique=false)
private String password;

@Column(name="email", length=120,nullable=false, unique=true)
private String email;

@Column(name="telephone", length=60,nullable=false, unique=true)
private Long telephone;


public User() {
	
}


public User(Long id, String username, String password, String email, Long telephone) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.email = email;
	this.telephone = telephone;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getTelephone() {
	return telephone;
}

public void setTelephone(Long telephone) {
	this.telephone = telephone;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", telephone="
			+ telephone + "]";
}

@Override
public int hashCode() {
	return Objects.hash(email, id, username, password, telephone);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(username, other.username)
			&& Objects.equals(password, other.password) && Objects.equals(telephone, other.telephone);
}


}

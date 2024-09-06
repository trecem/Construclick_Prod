package com.construclick.construclick.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contacto")
	private Long id;
	
	@Column(name= "name", length = 60, nullable = false, unique = true )
	private String name;
	
	@Column(name= "email", length = 120, nullable = false, unique = true )
	private String email;
	
	@Column(name= "phone", length = 10, nullable = false, unique = true )
	private Long phone;
	
	@Column(name= "enterprise", length = 60, nullable = true, unique = false )
	private String enterprise;
	
	@Column(name= "message", length = 2000, nullable = true, unique = false )
	private String message;
	
	//constructor vacío
	public Contacto() {
		
	}
	
	

	public Contacto(Long id, String name, String email, Long phone, String enterprise, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.enterprise = enterprise;
		this.message = message;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", enterprise="
				+ enterprise + ", message=" + message + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, enterprise, id, message, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(email, other.email) && Objects.equals(enterprise, other.enterprise)
				&& Objects.equals(id, other.id) && Objects.equals(message, other.message)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}
	
	
	

}

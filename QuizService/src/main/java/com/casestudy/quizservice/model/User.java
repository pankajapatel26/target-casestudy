package com.casestudy.quizservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@CreationTimestamp
	private LocalDateTime createdDate;

	@NotNull
	private String firstName;

	// @NotNull
	private String lastName;

	@NotNull
	@Column(name = "email_id")
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String phoneNumber;
	
	@Transient
	private List<UserSelection> userSelections;
	
	

	public List<UserSelection> getUserSelections() {
		return userSelections;
	}

	public void setUserSelections(List<UserSelection> userSelections) {
		this.userSelections = userSelections;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String emailId) {
		this.username = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

	public User(long id, LocalDateTime createdDate, @NotNull String firstName, String lastName, @NotNull String emailId,
			@NotNull String password, @NotNull String phoneNumber) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public User() {
		super();
	}

}

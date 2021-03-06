package com.psl.entities;

import java.io.BufferedReader;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommitteeMember {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String personName;
private String contact;
private String role;
private String photo;
public CommitteeMember() {
	super();
	// TODO Auto-generated constructor stub
}
public CommitteeMember(int id, String personName, String contact, String role, String photo) {
	super();
	this.id = id;
	this.personName = personName;
	this.contact = contact;
	this.role = role;
	this.photo = photo;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPersonName() {
	return personName;
}
public void setPersonName(String personName) {
	this.personName = personName;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
@Override
public int hashCode() {
	return Objects.hash(contact, id, personName, photo, role);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CommitteeMember other = (CommitteeMember) obj;
	return contact == other.contact && id == other.id && Objects.equals(personName, other.personName)
			&& Objects.equals(photo, other.photo) && Objects.equals(role, other.role);
}
@Override
public String toString() {
	return "CommiteMembers [id=" + id + ", personName=" + personName + ", contact=" + contact + ", role=" + role
			+ ", photo=" + photo + "]";
}

}

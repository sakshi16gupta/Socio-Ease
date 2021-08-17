package com.psl.entities;

import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SocietyMember {
@Id	
@GeneratedValue(strategy = GenerationType.AUTO)
private int memberId;
private int noOfMember;
private String memberName;
private String email;
private String password;
private String contact;
private int flatNumber;
private int buildingNumber;
private int noOfVechile;
private String photo;
//@OneToMany(mappedBy="societyMember")
//private Set<Guest> guest;
public SocietyMember() {
	super();
	// TODO Auto-generated constructor stub
}

public SocietyMember(int memberId, int noOfMember, String memberName, String email, String password, String contact,
		int flatNumber, int buildingNumber, int noOfVechile, String photo) {
	super();
	this.memberId = memberId;
	this.noOfMember = noOfMember;
	this.memberName = memberName;
	this.email = email;
	this.password = password;
	this.contact = contact;
	this.flatNumber = flatNumber;
	this.buildingNumber = buildingNumber;
	this.noOfVechile = noOfVechile;
	this.photo = photo;
	//this.guest = guest;
}
public int getMemberId() {
	return memberId;
}
public void setMemberId(int memberId) {
	this.memberId = memberId;
}
public int getNoOfMember() {
	return noOfMember;
}
public void setNoOfMember(int noOfMember) {
	this.noOfMember = noOfMember;
}
public String getMemberName() {
	return memberName;
}
public void setMemberName(String memberName) {
	this.memberName = memberName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public int getFlatNumber() {
	return flatNumber;
}
public void setFlatNumber(int flatNumber) {
	this.flatNumber = flatNumber;
}
public int getBuildingNumber() {
	return buildingNumber;
}
public void setBuildingNumber(int buildingNumber) {
	this.buildingNumber = buildingNumber;
}
public int getNoOfVechile() {
	return noOfVechile;
}
public void setNoOfVechile(int noOfVechile) {
	this.noOfVechile = noOfVechile;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
//public Set<Guest> getGuest() {
//	return guest;
//}
//public void setGuest(Set<Guest> guest) {
//	this.guest = guest;
//}
@Override
public int hashCode() {
	return Objects.hash(buildingNumber, contact, email, flatNumber, memberId, memberName, noOfMember,
			noOfVechile, password, photo);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SocietyMember other = (SocietyMember) obj;
	return buildingNumber == other.buildingNumber && contact == other.contact && Objects.equals(email, other.email)
			&& flatNumber == other.flatNumber && memberId == other.memberId
			&& Objects.equals(memberName, other.memberName) && noOfMember == other.noOfMember
			&& noOfVechile == other.noOfVechile && Objects.equals(password, other.password)
			&& Objects.equals(photo, other.photo);
}
@Override
public String toString() {
	return "SocietyMember [memberId=" + memberId + ", noOfMember=" + noOfMember + ", memberName=" + memberName
			+ ", email=" + email + ", password=" + password + ", contact=" + contact + ", flatNumber=" + flatNumber
			+ ", buildingNumber=" + buildingNumber + ", noOfVechile=" + noOfVechile + ", photo=" + photo + "]";
}


}

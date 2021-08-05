package com.psl.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Guest {
@Id	
private int GuestId;


private String guestName;
private String guestContact;
private String guestEmail;
private int guestCode;
private boolean vaccinated;
private LocalDate timestamp;
@ManyToOne
@JoinColumn(name="memberId", nullable=false)
private SocietyMember societyMember;
public Guest() {
	super();
	// TODO Auto-generated constructor stub
}
public Guest(int guestId, String guestName, String guestContact, String guestEmail, int guestCode, boolean vaccinated,
		LocalDate timestamp, SocietyMember societyMember) {
	super();
	GuestId = guestId;
	this.guestName = guestName;
	this.guestContact = guestContact;
	this.guestEmail = guestEmail;
	this.guestCode = guestCode;
	this.vaccinated = vaccinated;
	this.timestamp = timestamp;
	this.societyMember = societyMember;
}
public int getGuestId() {
	return GuestId;
}
public void setGuestId(int guestId) {
	GuestId = guestId;
}
public String getGuestName() {
	return guestName;
}
public void setGuestName(String guestName) {
	this.guestName = guestName;
}
public String getGuestContact() {
	return guestContact;
}
public void setGuestContact(String guestContact) {
	this.guestContact = guestContact;
}
public String getGuestEmail() {
	return guestEmail;
}
public void setGuestEmail(String guestEmail) {
	this.guestEmail = guestEmail;
}
public int getGuestCode() {
	return guestCode;
}
public void setGuestCode(int guestCode) {
	this.guestCode = guestCode;
}
public boolean isVaccinated() {
	return vaccinated;
}
public void setVaccinated(boolean vaccinated) {
	this.vaccinated = vaccinated;
}
public LocalDate getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDate timestamp) {
	this.timestamp = timestamp;
}
public SocietyMember getSocietyMember() {
	return societyMember;
}
public void setSocietyMember(SocietyMember societyMember) {
	this.societyMember = societyMember;
}
@Override
public int hashCode() {
	return Objects.hash(GuestId, guestCode, guestContact, guestEmail, guestName, societyMember, timestamp, vaccinated);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Guest other = (Guest) obj;
	return GuestId == other.GuestId && guestCode == other.guestCode && Objects.equals(guestContact, other.guestContact)
			&& Objects.equals(guestEmail, other.guestEmail) && Objects.equals(guestName, other.guestName)
			&& Objects.equals(societyMember, other.societyMember) && Objects.equals(timestamp, other.timestamp)
			&& vaccinated == other.vaccinated;
}
@Override
public String toString() {
	return "Guest [GuestId=" + GuestId + ", guestName=" + guestName + ", guestContact=" + guestContact + ", guestEmail="
			+ guestEmail + ", guestCode=" + guestCode + ", vaccinated=" + vaccinated + ", timestamp=" + timestamp
			+ ", societyMember=" + societyMember + "]";
}



}

package com.psl.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ServiceProvider {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int providerId;
private String providerName;
private int charges;
private String contact;
private String verificationDoc;
private String photo;
@ManyToOne
@JoinColumn(name="categoryId", nullable=false)
private ServiceCategory serviceCategory;
public ServiceProvider() {
	super();
	// TODO Auto-generated constructor stub
}
public ServiceProvider(int providerId, String providerName, int charges, String contact, String verificationDoc,
		String photo, ServiceCategory serviceCategory) {
	super();
	this.providerId = providerId;
	this.providerName = providerName;
	this.charges = charges;
	this.contact = contact;
	this.verificationDoc = verificationDoc;
	this.photo = photo;
	this.serviceCategory = serviceCategory;
}
public int getProviderId() {
	return providerId;
}
public void setProviderId(int providerId) {
	this.providerId = providerId;
}
public String getProviderName() {
	return providerName;
}
public void setProviderName(String providerName) {
	this.providerName = providerName;
}
public int getCharges() {
	return charges;
}
public void setCharges(int charges) {
	this.charges = charges;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getVerificationDoc() {
	return verificationDoc;
}
public void setVerificationDoc(String verificationDoc) {
	this.verificationDoc = verificationDoc;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public ServiceCategory getServiceCategory() {
	return serviceCategory;
}
public void setServiceCategory(ServiceCategory serviceCategory) {
	this.serviceCategory = serviceCategory;
}
@Override
public int hashCode() {
	return Objects.hash(charges, contact, photo, providerId, providerName, serviceCategory, verificationDoc);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ServiceProvider other = (ServiceProvider) obj;
	return charges == other.charges && contact == other.contact && Objects.equals(photo, other.photo)
			&& providerId == other.providerId && Objects.equals(providerName, other.providerName)
			&& Objects.equals(serviceCategory, other.serviceCategory)
			&& Objects.equals(verificationDoc, other.verificationDoc);
}
@Override
public String toString() {
	return "ServiceProvider [providerId=" + providerId + ", providerName=" + providerName + ", charges=" + charges
			+ ", contact=" + contact + ", verificationDoc=" + verificationDoc + ", photo=" + photo + ", serviceCategory=" + serviceCategory + "]";
}


}

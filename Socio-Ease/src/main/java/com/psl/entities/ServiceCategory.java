package com.psl.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ServiceCategory {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int categoryId;
private String categoryName;
private String categoryImage;
//@OneToMany(mappedBy="serviceCategory")
//private Set<ServiceProvider> serviceProvider;
public ServiceCategory() {
	super();
	// TODO Auto-generated constructor stub
}
public ServiceCategory(int categoryId, String categoryName, String categoryImage) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.categoryImage = categoryImage;
	//this.serviceProvider = serviceProvider;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryImage() {
	return categoryImage;
}
public void setCategoryImage(String categoryImage) {
	this.categoryImage = categoryImage;
}
//public Set<ServiceProvider> getServiceProvider() {
//	return serviceProvider;
//}
//public void setServiceProvider(Set<ServiceProvider> serviceProvider) {
//	this.serviceProvider = serviceProvider;
//}
@Override
public int hashCode() {
	return Objects.hash(categoryId, categoryImage, categoryName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ServiceCategory other = (ServiceCategory) obj;
	return categoryId == other.categoryId && Objects.equals(categoryImage, other.categoryImage)
			&& Objects.equals(categoryName, other.categoryName);
}
@Override
public String toString() {
	return "ServiceCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryImage="
			+ categoryImage + "]";
}

}

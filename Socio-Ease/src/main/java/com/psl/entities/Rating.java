package com.psl.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int ratingId;
private String feedback;
private int rating;
@ManyToOne
@JoinColumn(name="providerId", nullable=false)
private ServiceProvider serviceProvider;
public Rating() {
	super();
	// TODO Auto-generated constructor stub
}
public Rating(int ratingId, String feedback, int rating, ServiceProvider serviceProvider) {
	super();
	this.ratingId = ratingId;
	this.feedback = feedback;
	this.rating = rating;
	this.serviceProvider = serviceProvider;
}
public int getRatingId() {
	return ratingId;
}
public void setRatingId(int ratingId) {
	this.ratingId = ratingId;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public ServiceProvider getServiceProvider() {
	return serviceProvider;
}
public void setServiceProvider(ServiceProvider serviceProvider) {
	this.serviceProvider = serviceProvider;
}
@Override
public int hashCode() {
	return Objects.hash( feedback, rating, ratingId, serviceProvider);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Rating other = (Rating) obj;
	return  Objects.equals(feedback, other.feedback) && rating == other.rating
			&& ratingId == other.ratingId && Objects.equals(serviceProvider, other.serviceProvider);
}
@Override
public String toString() {
	return "Rating [ratingId=" + ratingId +  ", feedback=" + feedback + ", rating="
			+ rating + ", serviceProvider=" + serviceProvider + "]";
}


}

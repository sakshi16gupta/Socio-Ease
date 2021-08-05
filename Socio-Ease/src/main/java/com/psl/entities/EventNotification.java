package com.psl.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventNotification {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int eventId;
private String eventName;
private String notificationBody;
private LocalDate timestamp;
public EventNotification() {
	super();
	// TODO Auto-generated constructor stub
}
public EventNotification(int eventId, String eventName, String notificationBody, LocalDate timestamp) {
	super();
	this.eventId = eventId;
	this.eventName = eventName;
	this.notificationBody = notificationBody;
	this.timestamp = timestamp;
}
public int getEventId() {
	return eventId;
}
public void setEventId(int eventId) {
	this.eventId = eventId;
}
public String getEventName() {
	return eventName;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public String getNotificationBody() {
	return notificationBody;
}
public void setNotificationBody(String notificationBody) {
	this.notificationBody = notificationBody;
}
public LocalDate getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDate timestamp) {
	this.timestamp = timestamp;
}
@Override
public int hashCode() {
	return Objects.hash(eventId, eventName, notificationBody, timestamp);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EventNotification other = (EventNotification) obj;
	return eventId == other.eventId && Objects.equals(eventName, other.eventName)
			&& Objects.equals(notificationBody, other.notificationBody) && Objects.equals(timestamp, other.timestamp);
}
@Override
public String toString() {
	return "EventNotification [eventId=" + eventId + ", eventName=" + eventName + ", notificationBody="
			+ notificationBody + ", timestamp=" + timestamp + "]";
}

}

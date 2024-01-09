package com.notification.notificationService;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor 
@Data
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId ;
	private int toCustomerId ;
	private String  toCustomerEmail ;
	private String sender ;
	private String message ;
	private LocalDateTime sentAt ;
	public int getNotificcaationId() {
		return notificationId;
	}
	public void setNotificcaationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public int getToCustomerId() {
		return toCustomerId;
	}
	public void setToCustomerId(int toCustomerId) {
		this.toCustomerId = toCustomerId;
	}
	public String getToCustomerEmail() {
		return toCustomerEmail;
	}
	public void setToCustomerEmail(String toCustomerEmail) {
		this.toCustomerEmail = toCustomerEmail;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	
	
	

}

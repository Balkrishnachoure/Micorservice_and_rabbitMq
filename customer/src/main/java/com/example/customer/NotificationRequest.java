package com.example.customer;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest {

	private Integer toCustomerId;
	private String toCustomerEmail;
	private String sender;
	private String message;
	private LocalDateTime sentAt;
	
	public NotificationRequest(int toCustomerId, String toCustomerEmail, String message) {
		this.toCustomerId= toCustomerId; 
		this.toCustomerEmail= toCustomerEmail ;
		this.message =message;	
	}
	public Integer getToCustomerId() {
		return toCustomerId;
	}
	public void setToCustomerId(Integer toCustomerId) {
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
	
	   @Override
	    public String toString() {
	        return "NotificationRequest{" +
	                "customerId='" + toCustomerId + '\'' +
	                ", toCustomerEmail='" + toCustomerEmail + '\'' +
	                ", message='" + message + '\'' +
	                '}';
	    }
	
	
	
}

package com.notification.notificationService;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class NotificationRequest {
	
	
	private Integer toCustomerId;
	private String toCustomerEmail;
	private String sender;
	private String message;
	private LocalDateTime sentAt;
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
		return "NotificationRequest [toCustomerId=" + toCustomerId + ", toCustomerEmail=" + toCustomerEmail
				+ ", sender=" + sender + ", message=" + message + ", sentAt=" + sentAt + "]";
	}
	
	
	

}

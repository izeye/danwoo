package com.izeye.danwoo.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date timestamp;
	@Column(name = "from_")
	private String from;
	@Column(name = "to_")
	private String to;
	private String value;
	private String ipAddress;

	public Message() {
	}

	public Message(Date timestamp, String from, String to, String value,
			String ipAddress) {
		this.timestamp = timestamp;
		this.from = from;
		this.to = to;
		this.value = value;
		this.ipAddress = ipAddress;
	}

	public Message(String from, String to, String value) {
		this(new Date(), from, to, value, null);
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "Message [timestamp=" + timestamp + ", from=" + from + ", to="
				+ to + ", value=" + value + ", ipAddress=" + ipAddress + "]";
	}

}

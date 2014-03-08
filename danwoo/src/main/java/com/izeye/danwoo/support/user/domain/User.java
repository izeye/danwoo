package com.izeye.danwoo.support.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	private boolean enabled;

	private Date createdTime;
	private Date modifiedTime;
	private Date deletedTime;

	public User() {
	}

	public User(String username, String password) {
		this(username, password, UserRole.USER);
	}

	public User(String username, String password, UserRole role) {
		this.username = username;
		this.password = password;
		this.role = role;

		this.enabled = true;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Date getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}

	@PrePersist
	private void onCreate() {
		setCreatedTime(new Date());
	}

	@PreUpdate
	private void onUpdate() {
		setModifiedTime(new Date());
	}

	@PreRemove
	private void onDelete() {
		setDeletedTime(new Date());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", role=" + role + ", enabled=" + enabled
				+ ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + ", deletedTime=" + deletedTime + "]";
	}

}

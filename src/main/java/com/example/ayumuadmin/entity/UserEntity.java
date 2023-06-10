package com.example.ayumuadmin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class UserEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;
	@Basic
	@Column(name = "ROLE_ID")
	private int roleId;
	@Basic
	@Column(name = "USERNAME")
	private String username;
	@Basic
	@Column(name = "PASSWORD")
	private String password;
	@Basic
	@Column(name = "STATUS")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserEntity that = (UserEntity) o;
		return id == that.id && roleId == that.roleId && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, roleId, username, password, status);
	}
}

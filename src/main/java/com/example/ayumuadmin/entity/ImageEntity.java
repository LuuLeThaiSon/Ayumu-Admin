package com.example.ayumuadmin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMAGE")
public class ImageEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;
	@Basic
	@Column(name = "PATH")
	private String path;
	@Basic
	@Column(name = "TYPE")
	private String type;
	@Basic
	@Column(name = "STATUS")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		ImageEntity that = (ImageEntity) o;
		return id == that.id && Objects.equals(path, that.path) && Objects.equals(type, that.type) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, path, type, status);
	}
}

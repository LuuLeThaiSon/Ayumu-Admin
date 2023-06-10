package com.example.ayumuadmin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;
	@Basic
	@Column(name = "NAME")
	private String name;
	@Basic
	@Column(name = "STATUS")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		CategoryEntity that = (CategoryEntity) o;
		return id == that.id && Objects.equals(name, that.name) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, status);
	}
}

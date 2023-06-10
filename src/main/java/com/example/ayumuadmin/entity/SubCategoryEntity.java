package com.example.ayumuadmin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategoryEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;
	@Basic
	@Column(name = "CATEGORY_ID")
	private int categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
		SubCategoryEntity that = (SubCategoryEntity) o;
		return id == that.id && categoryId == that.categoryId && Objects.equals(name, that.name) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, categoryId, name, status);
	}
}

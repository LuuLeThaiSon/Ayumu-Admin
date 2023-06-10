package com.example.ayumuadmin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "POST")
public class PostEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID")
	private int id;
	@Basic
	@Column(name = "SUBCATEGORY_ID")
	private int subcategoryId;
	@Basic
	@Column(name = "TITLE")
	private String title;
	@Basic
	@Column(name = "CONTENT")
	private String content;
	@Basic
	@Column(name = "IMAGE")
	private String image;
	@Basic
	@Column(name = "STATUS")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
		PostEntity that = (PostEntity) o;
		return id == that.id && subcategoryId == that.subcategoryId && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(image, that.image) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, subcategoryId, title, content, image, status);
	}
}

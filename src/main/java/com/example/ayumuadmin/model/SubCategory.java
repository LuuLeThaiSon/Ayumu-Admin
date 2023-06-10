package com.example.ayumuadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
	private int id;
	private int categoryId;
	private String name;
	private String status;
}

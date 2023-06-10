package com.example.ayumuadmin.model.response;

import com.example.ayumuadmin.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
	private List<Category> response;
}

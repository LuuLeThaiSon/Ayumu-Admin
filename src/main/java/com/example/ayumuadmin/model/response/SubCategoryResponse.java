package com.example.ayumuadmin.model.response;

import com.example.ayumuadmin.model.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryResponse {
	private List<SubCategory> response;
}

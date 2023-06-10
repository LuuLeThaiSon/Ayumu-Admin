package com.example.ayumuadmin.service;

import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.response.CategoryResponse;

public interface CategoryService {
	CategoryResponse listCategories() throws AyumuException;
}

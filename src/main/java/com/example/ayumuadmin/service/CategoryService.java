package com.example.ayumuadmin.service;

import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.response.CategoriesResponse;

public interface CategoryService {
	CategoriesResponse listCategories() throws AyumuException;
}

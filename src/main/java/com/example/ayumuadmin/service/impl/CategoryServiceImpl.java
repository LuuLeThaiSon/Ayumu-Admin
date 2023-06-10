package com.example.ayumuadmin.service.impl;

import com.example.ayumuadmin.entity.CategoryEntity;
import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.Category;
import com.example.ayumuadmin.model.response.CategoriesResponse;
import com.example.ayumuadmin.repository.CategoryRepository;
import com.example.ayumuadmin.service.CategoryService;
import com.example.ayumuadmin.utils.AyumuErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public CategoriesResponse listCategories() throws AyumuException {
		try {
			List<CategoryEntity> categoryEntities = categoryRepository.findAll();

			List<Category> categories = categoryEntities
				.stream()
				.map(e -> new Category(e.getId(), e.getName()))
				.collect(Collectors.toList());

			return new CategoriesResponse(categories);

		} catch (Exception e) {
			log.error("listCategories error {}", getClass().getSimpleName(), e);
			throw new AyumuException(AyumuErrorCode.DATA_NOT_FOUND, "DATA_NOT_FOUND");
		}
	}
}

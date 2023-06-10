package com.example.ayumuadmin.controller.admin;

import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/ayumu/v1/categories")
public class CategoryController {
	private final CategoryService categoryService;

	@PostMapping("/list")
	public ResponseEntity<?> listCategories() throws AyumuException {
        return ResponseEntity.ok(categoryService.listCategories());
    }
}


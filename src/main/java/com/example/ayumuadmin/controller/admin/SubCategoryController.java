package com.example.ayumuadmin.controller.admin;

import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.FindSubCategoryByCategoryIdRequest;
import com.example.ayumuadmin.model.request.ChangeSubCategoryStatusRequest;
import com.example.ayumuadmin.model.request.CreateSubCategoryRequest;
import com.example.ayumuadmin.model.request.UpdateSubCategoryRequest;
import com.example.ayumuadmin.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/ayumu/v1/sub-categories")
public class SubCategoryController {
	private final SubCategoryService subCategoryService;

	@PostMapping("/create")
	public ResponseEntity<?> createSubCategory(@RequestBody CreateSubCategoryRequest request) throws AyumuException {
		return ResponseEntity.ok(subCategoryService.createSubCategory(request));
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateSubCategory(@RequestBody UpdateSubCategoryRequest request) throws AyumuException {
		return ResponseEntity.ok(subCategoryService.updateSubCategory(request));
	}

	@PostMapping("/change-status")
	public ResponseEntity<?> changeSubCategoryStatus(@RequestBody ChangeSubCategoryStatusRequest request) throws AyumuException {
		return ResponseEntity.ok(subCategoryService.changeSubCategoryStatus(request));
	}

	@PostMapping("/find-by-category-id")
	public ResponseEntity<?> findSubCategoryByCategoryId(@RequestBody FindSubCategoryByCategoryIdRequest request) throws AyumuException {
		return ResponseEntity.ok(subCategoryService.findSubCategoryByCategoryId(request));
	}
}

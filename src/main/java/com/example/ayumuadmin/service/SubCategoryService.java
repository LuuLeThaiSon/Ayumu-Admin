package com.example.ayumuadmin.service;

import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.FindSubCategoryByCategoryIdRequest;
import com.example.ayumuadmin.model.request.ChangeSubCategoryStatusRequest;
import com.example.ayumuadmin.model.request.CreateSubCategoryRequest;
import com.example.ayumuadmin.model.request.UpdateSubCategoryRequest;
import com.example.ayumuadmin.model.response.StatusResponse;
import com.example.ayumuadmin.model.response.SubCategoryResponse;

public interface SubCategoryService {
	StatusResponse createSubCategory(CreateSubCategoryRequest request) throws AyumuException;

	StatusResponse updateSubCategory(UpdateSubCategoryRequest request) throws AyumuException;

	StatusResponse changeSubCategoryStatus(ChangeSubCategoryStatusRequest request) throws AyumuException;

	SubCategoryResponse findSubCategoryByCategoryId(FindSubCategoryByCategoryIdRequest request) throws AyumuException;
}

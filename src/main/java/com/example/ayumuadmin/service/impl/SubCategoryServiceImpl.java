package com.example.ayumuadmin.service.impl;

import com.example.ayumuadmin.entity.CategoryEntity;
import com.example.ayumuadmin.entity.SubCategoryEntity;
import com.example.ayumuadmin.exception.AyumuException;
import com.example.ayumuadmin.model.request.ChangeSubCategoryStatusRequest;
import com.example.ayumuadmin.model.request.CreateSubCategoryRequest;
import com.example.ayumuadmin.model.request.UpdateSubCategoryRequest;
import com.example.ayumuadmin.model.response.StatusResponse;
import com.example.ayumuadmin.repository.CategoryRepository;
import com.example.ayumuadmin.repository.SubCategoryRepository;
import com.example.ayumuadmin.service.SubCategoryService;
import com.example.ayumuadmin.utils.AyumuErrorCode;
import com.example.ayumuadmin.utils.Common;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubCategoryServiceImpl implements SubCategoryService {
	private final SubCategoryRepository subCategoryRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public StatusResponse createSubCategory(CreateSubCategoryRequest request) throws AyumuException {
		try {
			Optional<CategoryEntity> categoryEntity = categoryRepository.findById(request.getCategoryId());

			if (categoryEntity.isPresent() && !subCategoryRepository.existsByName(request.getName())) {
				SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

				subCategoryEntity.setCategoryId(request.getCategoryId());
				subCategoryEntity.setName(request.getName());
				subCategoryEntity.setStatus(Common.STATUS_ACTIVE);

				subCategoryRepository.save(subCategoryEntity);

				return new StatusResponse(Common.STATUS_SUCCESS);
			} else {
				return new StatusResponse(Common.STATUS_FAILED);
			}

		} catch (Exception e) {
			log.error("createSubCategory error {}", getClass().getSimpleName(), e);
			throw new AyumuException(AyumuErrorCode.BAD_REQUEST, "BAD_REQUEST");
		}
	}

	@Override
	public StatusResponse updateSubCategory(UpdateSubCategoryRequest request) throws AyumuException {
		try {
			log.info("{} updateSubCategory request {}", getClass().getSimpleName(), request);
			Optional<SubCategoryEntity> subCategoryEntity = subCategoryRepository.findById(request.getId());

			if (subCategoryEntity.isPresent()) {
				subCategoryEntity.get().setName(request.getName());

				subCategoryRepository.save(subCategoryEntity.get());

				return new StatusResponse(Common.STATUS_SUCCESS);
			} else {
				return new StatusResponse(Common.STATUS_FAILED);
			}

		} catch (Exception e) {
			log.error("updateSubCategory error {}", getClass().getSimpleName(), e);
			throw new AyumuException(AyumuErrorCode.BAD_REQUEST, "BAD_REQUEST");
		}
	}

	@Override
	public StatusResponse changeSubCategoryStatus(ChangeSubCategoryStatusRequest request) throws AyumuException {
		try {
			log.info("{} changeSubCategoryStatus request {}", getClass().getSimpleName(), request);

			Optional<SubCategoryEntity> subCategoryEntity = subCategoryRepository.findById(request.getId());

			if (subCategoryEntity.isPresent()) {
				subCategoryEntity.get().setStatus(subCategoryEntity.get().getStatus().equals(Common.STATUS_ACTIVE) ? Common.STATUS_INACTIVE : Common.STATUS_ACTIVE);

				return new StatusResponse(Common.STATUS_SUCCESS);
			} else {
				return new StatusResponse(Common.STATUS_FAILED);
			}
		} catch (Exception e) {
			throw new AyumuException(AyumuErrorCode.BAD_REQUEST, "BAD_REQUEST");
		}
	}
}

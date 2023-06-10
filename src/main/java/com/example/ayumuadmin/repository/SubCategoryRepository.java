package com.example.ayumuadmin.repository;

import com.example.ayumuadmin.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Integer> {
	Boolean existsByName(String name);

	List<SubCategoryEntity> findAllByCategoryId(int categoryId);
}

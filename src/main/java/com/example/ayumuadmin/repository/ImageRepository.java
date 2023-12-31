package com.example.ayumuadmin.repository;

import com.example.ayumuadmin.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
}

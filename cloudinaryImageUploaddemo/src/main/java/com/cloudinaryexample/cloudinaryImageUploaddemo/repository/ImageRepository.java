package com.cloudinaryexample.cloudinaryImageUploaddemo.repository;

import com.cloudinaryexample.cloudinaryImageUploaddemo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {

}

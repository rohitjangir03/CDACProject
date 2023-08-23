package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
     
}

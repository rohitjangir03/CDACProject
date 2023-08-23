package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Model.Category;
import com.app.Model.Plant;

public interface PlantRepository extends JpaRepository<Plant,Integer>{
	 List<Plant> findByCategory(Category category);
}

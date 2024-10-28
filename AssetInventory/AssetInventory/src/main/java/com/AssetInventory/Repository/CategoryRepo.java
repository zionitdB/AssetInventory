package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	@Query("from Category c where c.categoryName=?1")
	Category getCategoryByName(String categoryName);

}

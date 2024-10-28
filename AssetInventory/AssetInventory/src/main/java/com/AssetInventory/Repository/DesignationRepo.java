package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Designation;

public interface DesignationRepo extends JpaRepository<Designation, Integer> {
	@Query("from Designation where active=1")
	List<Designation> getAllActiveDesignation();
	@Query("from Designation where designationName=?1")
	Designation getDesignationByName(String designationName);

}

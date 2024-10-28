package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer>{
	@Query("from Project p where p.projectName=?1")
	Project getProjectByname(String projectName);

}

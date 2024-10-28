package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadProject;

public interface UploadProjectRepo extends JpaRepository<UploadProject, Integer>{
	@Query("from UploadProject where projectName=?1")
	UploadProject getProjectByname(String projectName);
	@Query("from UploadProject where uploadDetial.id=?1")
	List<UploadProject> findByUserDetailsId(int id);

}

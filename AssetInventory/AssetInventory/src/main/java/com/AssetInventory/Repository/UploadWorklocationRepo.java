package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadWorklocation;

public interface UploadWorklocationRepo extends JpaRepository<UploadWorklocation, Integer> {
	@Query("From UploadWorklocation where workLocationName=?1")
	UploadWorklocation getWorklocationByName(String workLocationName);

}

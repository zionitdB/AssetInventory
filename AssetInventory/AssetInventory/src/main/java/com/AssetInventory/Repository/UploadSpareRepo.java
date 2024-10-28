package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadSpare;

public interface UploadSpareRepo extends JpaRepository<UploadSpare, Integer> {
	@Query("from UploadSpare where uploadDetial.id=?1")
	List<UploadSpare> findByUserDetailsId(int id);

}

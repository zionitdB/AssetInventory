package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadDesk;

public interface UploadDeskRepo extends JpaRepository<UploadDesk, Integer>{
	@Query("from UploadDesk where deskCode=?1")
	UploadDesk getDeskByDeskCode(String deskCode);
	@Query("from UploadDesk where uploadDetial.id=?1")
	List<UploadDesk> findByUserDetailsId(int id);

}

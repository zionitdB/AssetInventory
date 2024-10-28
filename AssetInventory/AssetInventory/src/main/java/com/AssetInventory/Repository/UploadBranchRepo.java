package com.AssetInventory.Repository;

import java.util.List;

import org.apache.xmlbeans.impl.jam.JParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadBranch;

public interface UploadBranchRepo extends JpaRepository<UploadBranch, Integer> {
	@Query("from UploadBranch  where branchName=?1")
	UploadBranch getBranchByCode(String branchName);
	@Query("from UploadBranch where uploadDetial.id=?1")
	List<UploadBranch> findByUserDetailsId(int id);

}

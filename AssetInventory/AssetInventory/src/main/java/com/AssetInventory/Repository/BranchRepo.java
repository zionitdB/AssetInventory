package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
	@Query("from Branch b where b.active=1")
	List<Branch> getAllActiveBranches();
	@Query("from Branch b where b.branchCode=?1")
	Branch getBranchByCode(String branchName);
	@Query("from Branch b where b.branchName=?1")

	Branch getBranchByName(String branchName);

}

package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.AssetAllocationHistory;

public interface AssetAllocationHistoryRepo extends JpaRepository<AssetAllocationHistory, Integer> {

}

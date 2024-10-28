package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.TransferAsset;

public interface TransferAssetRepo extends JpaRepository<TransferAsset, Integer> {

}

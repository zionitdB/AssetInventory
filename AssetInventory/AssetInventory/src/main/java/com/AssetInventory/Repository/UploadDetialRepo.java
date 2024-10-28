package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.UploadDetial;

public interface UploadDetialRepo extends JpaRepository<UploadDetial, Integer>,UploadDetialCustomeRepo {

	

}

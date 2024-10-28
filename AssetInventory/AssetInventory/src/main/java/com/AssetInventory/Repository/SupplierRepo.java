package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Supplier;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface SupplierRepo extends JpaRepository<Supplier, Integer>,SupplierCustomeRepo{
	@Query("from  Supplier s where s.supplierCode=?1")
	Supplier getSupplierByCode(String supplierCode);




}

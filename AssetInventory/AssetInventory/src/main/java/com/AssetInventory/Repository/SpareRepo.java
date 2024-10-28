package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.Spare;

public interface SpareRepo extends JpaRepository<Spare, Integer>{

}

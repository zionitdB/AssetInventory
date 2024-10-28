package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.State;

public interface StateRepo extends JpaRepository<State, Integer>{

}

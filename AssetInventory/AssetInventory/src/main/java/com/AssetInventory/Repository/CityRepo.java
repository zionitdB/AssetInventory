package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.City;

public interface CityRepo extends JpaRepository<City, Integer> {
	@Query("from City c where c.state.stateId=?1")
	List<City> getCitiesByState(int stateId);
	@Query("from City c where c.cityName=?1")
	City getAllCityByName(String cityName);

}

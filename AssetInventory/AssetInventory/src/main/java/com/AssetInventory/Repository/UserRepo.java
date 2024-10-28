package com.AssetInventory.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.User;

public interface UserRepo extends JpaRepository<User, Integer>,UserCustomeRepo{
	@Query("from User u where u.userName=?1")
	Optional<User> getUserByUserName(String userName);
	@Query("from User u where u.userName=?1 and u.password=?2 ")
	Optional<User> getUserByUserNameAndPassword(String userName, String password);
	@Query("from User u where u.employeeId=?1")
	Optional<User> getUserByEmployeeId(int employeeId);
	
	
	
}

package com.AssetInventory.Service;

import java.util.List;

import com.AssetInventory.DTO.LoginResponce;
import com.AssetInventory.Model.Role;
import com.AssetInventory.Model.User;

public interface UserServices {

	LoginResponce loginUser(User user);

	List<User> getUsersListByPagination(int pageNo, int perPage);

	List<User> getAllUsers();

	List<User> getUsersListByPaginationAndSearch(String searchText, int pageNo, int perPage);

	int getUserCount();

	int getUserCountAndSearch(String searchText);

	List<Role> getAllRole();

	void updateUser(User user);

}

package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.User;

public interface UserCustomeRepo {

	List<User> getUsersListByPagination(int pageNo, int perPage);
	List<User> getUsersListByPaginationAndSearch(String searchText, int pageNo, int perPage);
	int getUserCountAndSearch(String searchText);
}

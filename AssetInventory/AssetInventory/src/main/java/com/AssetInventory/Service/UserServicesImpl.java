package com.AssetInventory.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.DTO.LoginResponce;
import com.AssetInventory.Model.Role;
import com.AssetInventory.Model.User;
import com.AssetInventory.Repository.RoleRepo;
import com.AssetInventory.Repository.UserRepo;

@Service
public class UserServicesImpl implements UserServices {

	
	
	@Autowired 
	UserRepo userRepo;
	
	@Autowired 
	RoleRepo roleRepo;
	
	@Override
	public LoginResponce loginUser(User user) {
		// TODO Auto-generated method stub
		LoginResponce loginResponce= new LoginResponce();
		Optional<User>  users= userRepo.getUserByUserName(user.getUserName());
		if(users.isPresent()){
			Optional<User> validUser= userRepo.getUserByUserNameAndPassword(user.getUserName(),user.getPassword());
			System.out.println("ValidUser : "+validUser.isPresent());
			if(validUser.isPresent()){
				if(validUser.get().getActive()==0){
					loginResponce.setResponceCode(500);
					loginResponce.setResponceMsg("Inactive User ");
				}else{
					loginResponce.setResponceCode(200);
					loginResponce.setResponceMsg("Login successfully");
					validUser.get().setUserType(validUser.get().getRole().getRoleName());
					loginResponce.setData(validUser.get());
				}
				
			}else{

				loginResponce.setResponceCode(500);
				loginResponce.setResponceMsg("Invalid Password");
			}
		}else{
			loginResponce.setResponceCode(500);
			loginResponce.setResponceMsg("Invalid Username");
		}
		return loginResponce;
	}
	@Override
	public List<User> getUsersListByPagination(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return userRepo.getUsersListByPagination(pageNo,perPage);
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	@Override
	public List<User> getUsersListByPaginationAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return userRepo.getUsersListByPaginationAndSearch(searchText,pageNo,perPage);
	}
	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return (int) userRepo.count();
	}
	@Override
	public int getUserCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		return userRepo.getUserCountAndSearch(searchText);
	}
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

}

package com.AssetInventory.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssetInventory.DTO.LoginResponce;
import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.Model.Role;
import com.AssetInventory.Model.User;
import com.AssetInventory.Service.UserServices;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("/userLogin")
public class UserLoginController {
	@Autowired
	UserServices userServices;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LoginResponce loginUser(@RequestBody User user) {
	System.out.println("User code:" + user.getUserName() + " Password:" + user.getPassword());
		LoginResponce responce = new LoginResponce();
		try {
			responce = userServices.loginUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responce;
	}
	

	/**********************************User By limit only************************************/
	@RequestMapping(value = "/getUsersListByPagination", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsersListByPagination(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<User> userList = null;
		try {
			userList = userServices.getUsersListByPagination(pageNo,perPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	/*******************getAllUsers*****************************************************/
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		List<User> userList = null;
		try {
			userList = userServices.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	/**************************User BY limit and searchText********************************/
	@RequestMapping(value = "/getUsersListByPaginationAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsersListByPaginationAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<User> userList = null;
		try {
			userList = userServices.getUsersListByPaginationAndSearch(searchText,pageNo,perPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	/***********************************User count  ****************************************/
	@RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
	public @ResponseBody int  getUserCount() {
		int userCount=0;
		try {
			userCount = userServices.getUserCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCount;
	}
	/**************************************************************************************/
	
	/***********************************User count by search text ****************************************/
	@RequestMapping(value = "/getUserCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int getUserCountAndSearch(@RequestParam("searchText") String searchText) {
		int userCount=0;
		try {
			userCount = userServices.getUserCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userCount;
	}
	/**************************************************************************************/
	@RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
	public @ResponseBody List<Role> getAllRole() {
		List<Role> roleList = null;
		try {
			roleList = userServices.getAllRole();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleList;
	}
	
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody ResponceObject updateUser(@RequestBody User user) {
		
		ResponceObject response=new ResponceObject();
		try {
			
			userServices.updateUser(user);
					
		/*	Employee employee=employeeService.getEmployeeById(user.getEmployeeId());	
			if(!employee.getEmailId().equalsIgnoreCase("")){
				if(user.getActive()==0) {
					response.setCode(200);
					response.setMsg("Selected user status has been changed successfully");
					String message="<h5> Hello "+employee.getTitle()+" "+employee.getfName()+" "+employee.getlName()+",</h5> Your User credentials are disabled ,Please contact if not requested by you <br><br> Regards,<br>";
					emailSmsService.sendMail(employee.getEmailId(), "User has been disabled", message);
				}else { 
					response.setCode(200);
					response.setMsg("Selected user status has been changed successfully");
				String message="<h5> Hello "+employee.getTitle()+" "+employee.getfName()+" "+employee.getlName()+",</h5> Your User credentials are now ,Please refer following detials <br><br>  UserName :"+user.getUserName()+"<br> Password : "+user.getPassword()+"<br>"+"<br>Regards,<br>";
				emailSmsService.sendMail(employee.getEmailId(), "User has been activated", message);
			}
			
			}
			*/
		}catch(Exception e) {
			e.printStackTrace();
			response.setCode(500);
			response.setMsg("An error has occurred,please try again");
		}
		
		return response;
	}
	
}

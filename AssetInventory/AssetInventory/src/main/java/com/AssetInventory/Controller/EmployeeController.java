package com.AssetInventory.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.Role;
import com.AssetInventory.Model.User;
import com.AssetInventory.Repository.UserRepo;
import com.AssetInventory.Service.EmployeeService;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addEmployee(@RequestBody Employee employee) {
		ResponceObject responceObject = new ResponceObject();
		try {
			Employee emp=new Employee();
			
			if(employee.getUpdDatetime()!=null) {
				emp.setUpdDatetime(employee.getUpdDatetime());	
				
				Optional<User> userOp=userRepo.getUserByEmployeeId(employee.getEmployeeId());
				if(userOp.isPresent()) {
					User user=userOp.get();
					user.setFirstName(employee.getfName());
					user.setLastName(employee.getlName());
					
					userRepo.save(user);
				}
			
			}else {
				emp.setUpdDatetime(employee.getUpdDatetime());	
			}
			
			employeeService.addEmployee(employee);
			
			
			Employee emlpoyee1=employeeService.getEmployeeById(employee.getEmployeeId());
			//User user=userLoginServices.getUserByEmployeeId(emlpoyee1.getEmployeeId());
		/*	if(employee.getUpdDatetime()==null) {
				if(!employee.getEmailId().equalsIgnoreCase("")){
				String message="<h5> Hello"+emlpoyee1.getTitle()+" "+emlpoyee1.getfName()+" "+emlpoyee1.getlName()+",</h5> Your registration  have been successfull <br><br> "+"<br><br>"+"Regards<br>";
				//System.out.println("pass :"+ user.getPassword().toString());
				emailSmsService.sendMail(emlpoyee1.getEmailId(), "Registration has been Successfull", message);
				}
				responceObject.setCode(200);
				responceObject.setMsg("Employee Added Successfully");
			}else {
				
					if(!employee.getEmailId().equalsIgnoreCase("")){
					String message="<h5> Welcome "+emlpoyee1.getTitle()+" "+emlpoyee1.getfName()+" "+emlpoyee1.getlName()+",</h5> Your data  have been edited successfully <br><br> "+"<br><br>"+"Regards<br>";
					//System.out.println("pass :"+ user.getPassword().toString());
					emailSmsService.sendMail(emlpoyee1.getEmailId(), "Data has been edited Successfully", message);
					}
					responceObject.setCode(200);
					responceObject.setMsg("selected employee data has been updated Successfully");
			
		}*/
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	
	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeStatus(@RequestBody Employee employee) {
		ResponceObject responceObject = new ResponceObject();
		try {
			employeeService.addEmployee(employee);
			Optional<User> userOp=userRepo.getUserByEmployeeId(employee.getEmployeeId());
			User user = null;
			if(userOp.isPresent()) {
				user=userOp.get();
			}
			if(employee.getUserCreated()==1) {
				
				if(employee.getActive()==1) {				
					user.setActive(1);
				}else{				
					user.setActive(0);
					}
				userRepo.save(user);
			}		
			
			
			
			responceObject.setCode(200);
			responceObject.setMsg("Status Changed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong , please try again");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployee() {
		List<Employee> list = null;
		try {
			list = employeeService.getAllEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@RequestMapping(value = "/getAllAvtiveEmployee", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllAvtiveEmployee() {
		List<Employee> list = null;
		try {
			list = employeeService.getAllAvtiveEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllEmployeeByManager", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployeeByManager(@RequestParam("employeeId") int employeeId) {
		List<Employee> list = null;
		try {
			list = employeeService.getAllEmployeeByManager(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAllManagers", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllManagers() {
		List<Employee> list = null;
		try {
			list = employeeService.getAllManagers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAllEngineers", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEngineers() {
		List<Employee> list = null;
		try {
			list = employeeService.getAllEngineers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getlistEmployeeByLimit", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getlistEmployeeByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<Employee> list= new  ArrayList<Employee>();
		try {	
			list=employeeService.getlistEmployeeByLimit(pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getlistEmployeeByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getlistEmployeeByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<Employee> list= new  ArrayList<Employee>();
		try {	
			
			list=employeeService.getlistEmployeeByLimitAndSearch(searchText,pageNo,perPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getEmployeesCount", method = RequestMethod.GET)
	public @ResponseBody int  getEmployeesCount() {
		int  supplierCount= 0;
		try {
			supplierCount= employeeService.getEmployeesCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	@RequestMapping(value = "/getEmployeesCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getEmployeesCountAndSearch(@RequestParam("searchText") String searchText) {
		int  supplierCount= 0;
		try {
			supplierCount= employeeService.getEmployeesCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody ResponceObject createUser(@RequestBody Employee employee) {
		ResponceObject responceObject = new ResponceObject();
		try {
			User  user = new User();
					user.setActive(1);
					user.setAddedDate(new Date());
					//user.setBranch(1);
					user.setFirstName(employee.getfName());
					user.setLastName(employee.getlName());
					user.setPassword("Reset123");
					user.setEmployeeId(employee.getEmployeeId());
					user.setAddedBy(employee.getAddedBy());
					Role role = new Role();
					System.out.println("Des :: "+employee.getDesignation().getDesignationId());
					
					if(employee.getDesignation().getDesignationId()==2){
						role.setRoleId(4);
					}else if (employee.getDesignation().getDesignationId()==3){
						role.setRoleId(3);
					}else{
						role.setRoleId(2);
					}
					
					
					user.setBranch(employee.getBranch());
					user.setRole(role);
					user.setUpdatedDatetime(new Date());
					user.setUserName(employee.getEmoloyeeCode());
					user.setAddedBy(employee.getAddedBy());
					userRepo.save(user);
			
					employee.setUserCreated(1);
					employeeService.addEmployee(employee);
					/*if(!employee.getEmailId().equalsIgnoreCase("")){
						String message="<h5> Hello "+employee.getTitle()+" "+employee.getfName()+" "+employee.getlName()+",</h5> Your User Registration has done Successfully ,Please refer following detials <br><br>  UserName :"+user.getUserName()+"<br> Password : "+user.getPassword()+"<br>";
						emailSmsService.sendMail(employee.getEmailId(), "User Registration Sucessfull", message);
					}
					*/
			responceObject.setCode(200);
			responceObject.setMsg("User Created Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	

}

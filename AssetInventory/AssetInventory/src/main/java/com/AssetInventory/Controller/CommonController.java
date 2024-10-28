package com.AssetInventory.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.Model.Branch;
import com.AssetInventory.Model.Brand;
import com.AssetInventory.Model.BussinessUnit;
import com.AssetInventory.Model.Category;
import com.AssetInventory.Model.City;
import com.AssetInventory.Model.CostCenter;
import com.AssetInventory.Model.Department;
import com.AssetInventory.Model.Designation;
import com.AssetInventory.Model.Desk;
import com.AssetInventory.Model.Project;
import com.AssetInventory.Model.Room;
import com.AssetInventory.Model.State;
import com.AssetInventory.Model.Subsidiary;
import com.AssetInventory.Model.UnitOfMeasurement;
import com.AssetInventory.Model.Worklocation;
import com.AssetInventory.Repository.BranchRepo;
import com.AssetInventory.Repository.BrandRepo;
import com.AssetInventory.Repository.BussinessUnitRepo;
import com.AssetInventory.Repository.CategoryRepo;
import com.AssetInventory.Repository.CityRepo;
import com.AssetInventory.Repository.CostCenterRepo;
import com.AssetInventory.Repository.DepartmentRepo;
import com.AssetInventory.Repository.DesignationRepo;
import com.AssetInventory.Repository.DeskRepo;
import com.AssetInventory.Repository.ProjectRepo;
import com.AssetInventory.Repository.RoomRepo;
import com.AssetInventory.Repository.StateRepo;
import com.AssetInventory.Repository.SubsidiaryRepo;
import com.AssetInventory.Repository.UnitOfMeasurementRepo;
import com.AssetInventory.Repository.WorklocationRepo;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("/common")
public class CommonController {
	
	
	@Autowired
	CityRepo cityRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	StateRepo sateRepo;
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	BussinessUnitRepo bussinessUnitRepo;
	@Autowired
	CostCenterRepo costCenterRepo;
	@Autowired
	DepartmentRepo departmentRepo; 
	@Autowired
	DesignationRepo designationRepo;
	@Autowired
	SubsidiaryRepo subsidiaryRepo;
	@Autowired
	WorklocationRepo worklocationRepo;
	@Autowired
	DeskRepo deskRepo;
	@Autowired
	RoomRepo roomRepo;
	@Autowired
	ProjectRepo projectRepo;
	@Autowired
	BrandRepo brandRepo;
	@Autowired
	UnitOfMeasurementRepo unitOfMeasurementRepo;
	

	// Get All City List
	@RequestMapping(value = "/getAllUnitOfMeasurement", method = RequestMethod.GET)
	public @ResponseBody List<UnitOfMeasurement> getAllUnitOfMeasurement() {
		List<UnitOfMeasurement> cities = null;
		try {
			cities = unitOfMeasurementRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}
	

	// Get All City List
	@RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory() {
		List<Category> cities = null;
		try {
			cities = categoryRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}
	
	
	
	
	// Get All City List
	@RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
	public @ResponseBody List<City> getAllCity() {
		List<City> cities = null;
		try {
			cities = cityRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}
	
	
	// Get City List By State
	@RequestMapping(value = "/getCitiesByState", method = RequestMethod.GET)
	public @ResponseBody List<City> getCitiesByState(@RequestParam("stateId") int StateId) {
		List<City> cities= null;
		try {
			cities = cityRepo.getCitiesByState(StateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}
	
	@RequestMapping(value = "/getAllState", method = RequestMethod.GET)
	public @ResponseBody List<State> getAllState() {
		List<State> states = null;
		try {
			states = sateRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addBranch(@RequestBody Branch branch) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 branchRepo.save(branch);
			responceObject.setCode(200);
			responceObject.setMsg("Branch Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/changeBranchStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeBranchStatus(@RequestBody Branch branch) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(branch.getActive()==1){branch.setActive(0);}else{branch.setActive(1);}
			branchRepo.save(branch);
			responceObject.setCode(200);
			responceObject.setMsg("Branch Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllBranches", method = RequestMethod.GET)
	public @ResponseBody List<Branch> getAllBranches() {
		List<Branch> branches= new ArrayList<Branch>();
		try {
			branches= branchRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branches;
	}

	@RequestMapping(value = "/getAllActiveBranches", method = RequestMethod.GET)
	public @ResponseBody List<Branch> getAllActiveBranches() {
		List<Branch> branches= new ArrayList<Branch>();
		try {
			branches= branchRepo.getAllActiveBranches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return branches;
	}

	
	
	@RequestMapping(value = "/addBussinessUnit", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addBussinessUnit(@RequestBody BussinessUnit bussinessUnit) {
		ResponceObject responceObject = new ResponceObject();
		try {
			bussinessUnitRepo.save(bussinessUnit);
			responceObject.setCode(200);
			responceObject.setMsg("Bussiness Unit Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllBussinessUnit", method = RequestMethod.GET)
	public @ResponseBody List<BussinessUnit> getAllBussinessUnit() {
		List<BussinessUnit> list = null;
		try {
			list = bussinessUnitRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	@RequestMapping(value = "/addCostCenter", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addCostCenter(@RequestBody CostCenter costCenter) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 costCenterRepo.save(costCenter);
			responceObject.setCode(200);
			responceObject.setMsg("Cost Center Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/changeCostCenterStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeCostCenterStatus(@RequestBody CostCenter costCenter) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(costCenter.getActive()==1){costCenter.setActive(0);}else{costCenter.setActive(1);}
			costCenterRepo.save(costCenter);
			responceObject.setCode(200);
			responceObject.setMsg("Status Change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllCostCenter", method = RequestMethod.GET)
	public @ResponseBody List<CostCenter> getAllCostCenter() {
		List<CostCenter> list = null;
		try {
			list = costCenterRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveCostCenter", method = RequestMethod.GET)
	public @ResponseBody List<CostCenter> getAllActiveCostCenter() {
		List<CostCenter> list = null;
		try {
			list = costCenterRepo.getAllActiveCostCenter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addDepartment(@RequestBody Department department) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 departmentRepo.save(department);
			responceObject.setCode(200);
			responceObject.setMsg("Department Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllDepartment", method = RequestMethod.GET)
	public @ResponseBody List<Department> getAllDepartment() {
		List<Department> list = null;
		try {
			list = departmentRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveDepartment", method = RequestMethod.GET)
	public @ResponseBody List<Department> getAllActiveDepartment() {
		List<Department> list = null;
		try {
			list = departmentRepo.getAllActiveDepartment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/changeStastusDepartment", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeStastusDepartment(@RequestBody Department department) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(department.getActive()==1){
				department.setActive(0);
			}else{
				department.setActive(1);
			}
			departmentRepo.save(department);
			responceObject.setCode(200);
			responceObject.setMsg("Status change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	

	@RequestMapping(value = "/addDesignation", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addDesignation(@RequestBody Designation designation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 designationRepo.save(designation);
			responceObject.setCode(200);
			responceObject.setMsg("Designation Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/changeDesignationStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeDesignationStatus(@RequestBody Designation designation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(designation.getActive()==1){designation.setActive(0);}else{designation.setActive(1);}
			designationRepo.save(designation);
			responceObject.setCode(200);
			responceObject.setMsg("Status Change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllDesignation", method = RequestMethod.GET)
	public @ResponseBody List<Designation> getAllDesignation() {
		List<Designation> list = null;
		try {
			list = designationRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveDesignation", method = RequestMethod.GET)
	public @ResponseBody List<Designation> getAllActiveDesignation() {
		List<Designation> list = null;
		try {
			list = designationRepo.getAllActiveDesignation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/addSubsidiary", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addSubsidiary(@RequestBody Subsidiary subsidiary) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 subsidiaryRepo.save(subsidiary);
			responceObject.setCode(200);
			responceObject.setMsg("Subsidiary Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/changeSubsidiaryStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeSubsidiaryStatus(@RequestBody Subsidiary subsidiary) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(subsidiary.getActive()==1){subsidiary.setActive(0);}else{subsidiary.setActive(1);}
			subsidiaryRepo.save(subsidiary);
			responceObject.setCode(200);
			responceObject.setMsg("Subsidiary Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllSubsidiary", method = RequestMethod.GET)
	public @ResponseBody List<Subsidiary> getAllSubsidiary() {
		List<Subsidiary> list = null;
		try {
			list = subsidiaryRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveSubsidiary", method = RequestMethod.GET)
	public @ResponseBody List<Subsidiary> getAllActiveSubsidiary() {
		List<Subsidiary> list = null;
		try {
			list = subsidiaryRepo.getAllActiveSubsidiary();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/addWorklocation", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addWorklocation(@RequestBody Worklocation worklocation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 worklocationRepo.save(worklocation);
			responceObject.setCode(200);
			responceObject.setMsg("Worklocation Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/changeWorkLocationStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeWorkLocationStatus(@RequestBody Worklocation worklocation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(worklocation.getActive()==1){worklocation.setActive(0);}else{worklocation.setActive(1);}
			worklocationRepo.save(worklocation);
			responceObject.setCode(200);
			responceObject.setMsg("Worklocation Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllWorklocation", method = RequestMethod.GET)
	public @ResponseBody List<Worklocation> getAllWorklocation() {
		List<Worklocation> list = null;
		try {
			list = worklocationRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveWorklocation", method = RequestMethod.GET)
	public @ResponseBody List<Worklocation> getAllActiveWorklocation() {
		List<Worklocation> list = null;
		try {
			list = worklocationRepo.getAllActiveWorklocation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/changeDeskStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeDeskStatus(@RequestBody Desk desk) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(desk.getActive()==1){
				desk.setActive(0);
			}else{
				desk.setActive(1);
			}
			deskRepo.save(desk);
			responceObject.setCode(200);
			responceObject.setMsg("Status change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/addDesk", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addDesk(@RequestBody Desk desk) {
		ResponceObject responceObject = new ResponceObject();
		try {
			deskRepo.save(desk);
			responceObject.setCode(200);
			responceObject.setMsg("Desk Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllDesk", method = RequestMethod.GET)
	public @ResponseBody List<Desk> getAllDesk() {
		List<Desk> list = null;
		try {
			list = deskRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAvailableDesk", method = RequestMethod.GET)
	public @ResponseBody List<Desk> getAvailableDesk() {
		List<Desk> list = null;
		try {
			list = deskRepo.getAvailableDesk();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addRoom(@RequestBody Room room) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 roomRepo.save(room);
			responceObject.setCode(200);
			responceObject.setMsg("RoomAdded Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/changeRoomStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeRoomStatus(@RequestBody Room room) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(room.getActive()==1){
				room.setActive(0);
			}else{
				room.setActive(1);
			}
			
			roomRepo.save(room);
			responceObject.setCode(200);
			responceObject.setMsg("Status change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllRoom", method = RequestMethod.GET)
	public @ResponseBody List<Room> getAllRoom() {
		List<Room> list = null;
		try {
			list = roomRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveRoom", method = RequestMethod.GET)
	public @ResponseBody List<Room> getAllActiveRoom() {
		List<Room> list = null;
		try {
			list = roomRepo.getAllActiveRoom();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addProject(@RequestBody Project project) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 projectRepo.save(project);
			responceObject.setCode(200);
			responceObject.setMsg("Project Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/changeProjectStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeProjectStatus(@RequestBody Project project) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(project.getActive()==1){
				project.setActive(0);
			}else{
				project.setActive(1);
			}
			projectRepo.save(project);
			responceObject.setCode(200);
			responceObject.setMsg("Status Change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllProject", method = RequestMethod.GET)
	public @ResponseBody List<Project> getAllProject() {
		List<Project> list = null;
		try {
			list = projectRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/addBrand", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addBrand(@RequestBody Brand brand) {
		ResponceObject responceObject = new ResponceObject();
		try {
			 brandRepo.save(brand);
			responceObject.setCode(200);
			responceObject.setMsg("Brand Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/changeBrandStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeBrandStatus(@RequestBody Brand brand) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(brand.getActive()==1){
				brand.setActive(0);
			}else{
				brand.setActive(1);
			}
			brandRepo.save(brand);
			responceObject.setCode(200);
			responceObject.setMsg("Status Change Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllBrands", method = RequestMethod.GET)
	public @ResponseBody List<Brand> getAllBrands() {
		List<Brand> list = null;
		try {
			list = brandRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllActiveBrands", method = RequestMethod.GET)
	public @ResponseBody List<Brand> getAllActiveBrands() {
		List<Brand> list = null;
		try {
			list = brandRepo.getAllActiveBrands();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * @RequestMapping(value = "/getAllReason", method = RequestMethod.GET)
	 * public @ResponseBody List<ReasonForOutPass> getAllReason() {
	 * List<ReasonForOutPass> list = null; try { list =
	 * commomService.getAllReason(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 */
}

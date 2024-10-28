	package com.AssetInventory.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.AssetInventory.DTO.AssetRequestDto;
import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.DTO.UploadDataResDTO;
import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.AssetRequestDetials;
import com.AssetInventory.Model.Branch;
import com.AssetInventory.Model.Brand;
import com.AssetInventory.Model.Category;
import com.AssetInventory.Model.City;
import com.AssetInventory.Model.CostCenter;
import com.AssetInventory.Model.Department;
import com.AssetInventory.Model.Designation;
import com.AssetInventory.Model.Desk;
import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Project;
import com.AssetInventory.Model.Room;
import com.AssetInventory.Model.Spare;
import com.AssetInventory.Model.Subsidiary;
import com.AssetInventory.Model.Supplier;
import com.AssetInventory.Model.UploadBranch;
import com.AssetInventory.Model.UploadBrand;
import com.AssetInventory.Model.UploadCostCenter;
import com.AssetInventory.Model.UploadDepartment;
import com.AssetInventory.Model.UploadDesignation;
import com.AssetInventory.Model.UploadDesk;
import com.AssetInventory.Model.UploadDetial;
import com.AssetInventory.Model.UploadEmployee;
import com.AssetInventory.Model.UploadMaterial;
import com.AssetInventory.Model.UploadProject;
import com.AssetInventory.Model.UploadRoom;
import com.AssetInventory.Model.UploadSpare;
import com.AssetInventory.Model.UploadSubsidiary;
import com.AssetInventory.Model.UploadSupplier;
import com.AssetInventory.Model.UploadWorklocation;
import com.AssetInventory.Model.User;
import com.AssetInventory.Model.Worklocation;
import com.AssetInventory.Repository.BranchRepo;
import com.AssetInventory.Repository.BrandRepo;
import com.AssetInventory.Repository.CategoryRepo;
import com.AssetInventory.Repository.CityRepo;
import com.AssetInventory.Repository.CostCenterRepo;
import com.AssetInventory.Repository.DepartmentRepo;
import com.AssetInventory.Repository.DesignationRepo;
import com.AssetInventory.Repository.DeskRepo;
import com.AssetInventory.Repository.EmployeeRepo;
import com.AssetInventory.Repository.MaterialRepo;
import com.AssetInventory.Repository.ProjectRepo;
import com.AssetInventory.Repository.RoomRepo;
import com.AssetInventory.Repository.SpareRepo;
import com.AssetInventory.Repository.SubsidiaryRepo;
import com.AssetInventory.Repository.SupplierRepo;
import com.AssetInventory.Repository.UploadBranchRepo;
import com.AssetInventory.Repository.UploadBrandRepo;
import com.AssetInventory.Repository.UploadCostCenterRepo;
import com.AssetInventory.Repository.UploadDepartmentRepo;
import com.AssetInventory.Repository.UploadDesignationRepo;
import com.AssetInventory.Repository.UploadDeskRepo;
import com.AssetInventory.Repository.UploadDetialRepo;
import com.AssetInventory.Repository.UploadEmployeeRepo;
import com.AssetInventory.Repository.UploadMaterialRepo;
import com.AssetInventory.Repository.UploadProjectRepo;
import com.AssetInventory.Repository.UploadRoomRepo;
import com.AssetInventory.Repository.UploadSpareRepo;
import com.AssetInventory.Repository.UploadSubsidiaryRepo;
import com.AssetInventory.Repository.UploadSupplierRepo;
import com.AssetInventory.Repository.UploadWorklocationRepo;
import com.AssetInventory.Repository.UserRepo;
import com.AssetInventory.Repository.WorklocationRepo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	UploadDetialRepo uploadDetialRepo;

	@Autowired
	UploadSpareRepo uploadSpareRepo;

	@Autowired
	UploadDeskRepo uploadDeskRepo;

	@Autowired
	UploadProjectRepo uploadProjectRepo;

	@Autowired
	UploadRoomRepo uploadRoomRepo;

	@Autowired
	UploadDepartmentRepo uploadDepartmentRepo;

	@Autowired
	UploadBranchRepo uploadBranchRepo;
	@Autowired
	UploadBrandRepo uploadBrandRepo;
	@Autowired
	UploadDesignationRepo uploadDesignationRepo;

	@Autowired
	UploadCostCenterRepo uploadCostCenterRepo;
	@Autowired
	UploadWorklocationRepo uploadWorklocationRepo;

	@Autowired
	UploadSubsidiaryRepo uploadSubsidiaryRepo;
	@Autowired
	UploadSupplierRepo uploadSupplierRepo;

	@Autowired
	UploadMaterialRepo uploadMaterialRepo;
	@Autowired
	UploadEmployeeRepo uploadEmployeeRepo;
	@Autowired
	SpareRepo spareRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	DeskRepo deskRepo;

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	RoomRepo roomRepo;

	@Autowired
	DepartmentRepo departmentRepo;

	@Autowired
	BranchRepo branchRepo;
	@Autowired
	BrandRepo brandRepo;
	@Autowired
	DesignationRepo designationRepo;
	@Autowired
	CostCenterRepo costCenterRepo;
	@Autowired
	WorklocationRepo worklocationRepo;
	@Autowired
	SubsidiaryRepo subsidiaryRepo;
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	MaterialRepo materialRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	CityRepo cityRepo;
	@Autowired
	CategoryRepo categoryRepo;
	
	
	
	
	@RequestMapping(value = "/getAllUploadDetialByLimit", method = RequestMethod.GET)
	public @ResponseBody List<UploadDetial> getAllUploadDetialByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<UploadDetial> list= new  ArrayList<UploadDetial>();
		try {	
			list=uploadDetialRepo.getAllUploadDetialByLimit(pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getUploadDetialSByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<UploadDetial> getUploadDetialSByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<UploadDetial> list= new  ArrayList<UploadDetial>();
		try {	
			
			list=uploadDetialRepo.getUploadDetialSByLimitAndSearch(searchText,pageNo,perPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getUploadDetialCount", method = RequestMethod.GET)
	public @ResponseBody int  getUploadDetialCount() {
		int  supplierCount= 0;
		try {
			supplierCount= (int) uploadDetialRepo.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	@RequestMapping(value = "/getUploadDetialsCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getAssetInventorysCountAndSearch(@RequestParam("searchText") String searchText) {
		int  supplierCount= 0;
		try {
			supplierCount= uploadDetialRepo.getUploadDetialsCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/getUploadDataById", method = RequestMethod.GET)
	public @ResponseBody UploadDataResDTO getUploadDataById(@RequestParam("userDetailsId") int userDetailsId) {
		UploadDataResDTO uploadDataResDTO= new  UploadDataResDTO();
		try {	
			Optional<UploadDetial> optional=uploadDetialRepo.findById(userDetailsId);
			if(optional.isPresent()) {
				if(optional.get().getModuleName().equalsIgnoreCase("Spare")) {
					List<UploadSpare> uploadSpares=uploadSpareRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setSpares(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Desk")) {
					List<UploadDesk> uploadSpares=uploadDeskRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setDesks(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Project")) {
					List<UploadProject> uploadSpares=uploadProjectRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setProjects(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Room")) {
					List<UploadRoom> uploadSpares=uploadRoomRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setRooms(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Department")) {
					List<UploadDepartment> uploadSpares=uploadDepartmentRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setDepartments(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Branch")) {
					List<UploadBranch> uploadSpares=uploadBranchRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setBranchs(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Brand")) {
					List<UploadBrand> uploadSpares=uploadBrandRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setBrands(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Designation")) {
					List<UploadDesignation> uploadSpares=uploadDesignationRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setDesignations(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Cost Center")) {
					List<UploadCostCenter> uploadSpares=uploadCostCenterRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setCostCenters(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Supplier")) {
					List<UploadSupplier> uploadSpares=uploadSupplierRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setSuppliers(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Material")) {
					List<UploadMaterial> uploadSpares=uploadMaterialRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setMaterials(uploadSpares);
				}
				if(optional.get().getModuleName().equalsIgnoreCase("Employee")) {
					List<UploadEmployee> uploadSpares=uploadEmployeeRepo.findByUserDetailsId(optional.get().getId());
					uploadDataResDTO.setEmployees(uploadSpares);
				}
				uploadDataResDTO.setCode(200);
				uploadDataResDTO.setMessage("Data Fetch Successfully");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploadDataResDTO;
	}
	
	
	
	
	@RequestMapping(value = "/approveSpare", method = RequestMethod.POST)
	public @ResponseBody ResponceObject approveSpare(@RequestBody List<UploadSpare> list) {
		ResponceObject responceObject = new ResponceObject();
		try {
			for(UploadSpare obj:list) {
				Spare spare= new Spare();
			}
		
			
			responceObject.setCode(200);
			responceObject.setMsg("Asset request added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@PostMapping(value = "/uploaSpare", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploaSpare(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		MultipartFile file = files[0];
		System.out.println(file.getOriginalFilename());

		try {
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;

						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Spare");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);
						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}

							String type = row.getCell(1).toString();
							String category = row.getCell(2).toString();
							String brand = row.getCell(3).toString();
							String spareName = row.getCell(4).toString();
							String specification = row.getCell(5).toString();
							int noofSpare = Integer.parseInt(row.getCell(6).toString().replace(".0", ""));
							System.out.println("Type  :: " + type);
							System.out.println("Category  :: " + category);
							System.out.println("Brand  :: " + brand);
							System.out.println("spareName  :: " + spareName);
							System.out.println("specification  :: " + specification);
							System.out.println("noofSpare  :: " + noofSpare);
							for (int k = 0; k <= noofSpare; k++) {
								int x = k;
								int y = x++;
								String uniquCode = spareName + y;

								UploadSpare spare = new UploadSpare();
								spare.setBrand(brand);
								spare.setCategory(category);
								spare.setConsumeBit(0);
								spare.setSpareName(spareName);
								spare.setSpareUniqueCode(uniquCode);
								spare.setSpecification(specification);
								spare.setType(type);
								spare.setUploadDetial(uploadDetial1);
								uploadSpareRepo.save(spare);

							}

						}
						

						workbook.close();
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadDesk", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadDesk(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		MultipartFile file = files[0];
		System.out.println(file.getOriginalFilename());
		try {
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Desk");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());
							System.out.println("ROW 2  " + row.getCell(2).toString());
							System.out.println("ROW 3  " + row.getCell(3).toString());
							String deskCode = row.getCell(3).toString();
							String allocation = row.getCell(4).toString().replace(".0", "");
							System.out.println("allocation 0  " + allocation);
							UploadDesk desk2 = new UploadDesk();
							UploadDesk desk = uploadDeskRepo.getDeskByDeskCode(deskCode);
							if (desk != null) {
								desk2 = desk;
								desk2.setUploadDetial(uploadDetial1);
								desk2.setAllocate(Integer.parseInt(allocation));
								desk2.setFloor(row.getCell(1).toString());
								desk2.setBay(row.getCell(2).toString());
								desk2.setActive(1);
							} else {
								desk2.setAllocate(Integer.parseInt(allocation));
								desk2.setFloor(row.getCell(1).toString());
								desk2.setBay(row.getCell(2).toString());
								desk2.setDeskCode(row.getCell(3).toString());
								desk2.setUploadDetial(uploadDetial1);
								desk2.setActive(1);
							}
							uploadDeskRepo.save(desk2);
						}

						System.out.println("Successfully imported");
						workbook.close();
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadProject", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadProject(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		MultipartFile file = files[0];
		System.out.println(file.getOriginalFilename());
		try {
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Project");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String projectName = row.getCell(1).toString();
							UploadProject project = new UploadProject();
							UploadProject project2 = uploadProjectRepo.getProjectByname(projectName);
							if (project2 != null) {
								project = project2;
								project.setProjectName(projectName);
								project.setActive(1);

							} else {
								project.setProjectName(projectName);
								project.setActive(1);
							}
							project.setUploadDetial(uploadDetial1);
							uploadProjectRepo.save(project);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadRoom", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadRoom(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {

			MultipartFile file = files[0];
			System.out.println(file.getOriginalFilename());

			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Room");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String roomName = row.getCell(1).toString();
							UploadRoom room = new UploadRoom();
							UploadRoom room2 = uploadRoomRepo.getRoomByname(roomName);
							if (room2 != null) {
								room = room2;
								room.setRoomName(roomName);
								room.setActive(1);

							} else {
								room.setRoomName(roomName);
								room.setActive(1);
							}
							room.setUploadDetial(uploadDetial1);
							uploadRoomRepo.save(room);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadDepartment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadDepartment(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			System.out.println(file.getOriginalFilename());
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Department");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String departmentName = row.getCell(1).toString();
							UploadDepartment department = new UploadDepartment();
							UploadDepartment department2 = uploadDepartmentRepo.getDepartmentByname(departmentName);
							if (department2 != null) {
								department = department2;
								department.setDepartmentName(departmentName);
								department.setActive(1);

							} else {
								department.setDepartmentName(departmentName);
								department.setActive(1);
							}
							department.setUploadDetial(uploadDetial1);
							uploadDepartmentRepo.save(department);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");

					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(value = "/branchUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject branchUpload(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();

		try {
			MultipartFile file = files[0];
			System.out.println(file.getOriginalFilename());
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Branch");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String branchName = row.getCell(2).toString();
							String branchCode = row.getCell(1).toString();
							String branchAddress = row.getCell(3).toString();
							String location = row.getCell(4).toString();
							UploadBranch branch = new UploadBranch();
							UploadBranch branch2 = uploadBranchRepo.getBranchByCode(branchName);
							if (branch2 != null) {
								branch = branch2;
								branch.setBranchName(branchName);
								branch.setBranchAddress(branchAddress);
								branch.setBranchName(branchName);
								branch.setLocation(location);
								branch.setDelet_bit(0);
								branch.setUpdDatetime(new Date());
								branch.setActive(1);
								branch.setAddedDate(new Date());

							} else {

								branch.setBranchAddress(branchAddress);
								branch.setBranchName(branchName);
								branch.setLocation(location);
								branch.setDelet_bit(0);
								branch.setUpdDatetime(new Date());
								branch.setActive(1);
								branch.setAddedDate(new Date());
							}
							branch.setUploadDetial(uploadDetial1);
							uploadBranchRepo.save(branch);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(value = "/brandUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject brandUpload(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			System.out.println(file.getOriginalFilename());
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Brand");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String brandName = row.getCell(1).toString();

							UploadBrand brand = new UploadBrand();
							UploadBrand brand2 = uploadBrandRepo.getBrandByName(brandName);
							if (brand2 != null) {
								brand = brand2;
								brand.setActive(1);
								brand.setBrandName(brandName);
								brand.setUpdDatetime(new Date());
								brand.setDeletBit(1);

							} else {
								brand.setAddedDate(new Date());
								brand.setActive(1);
								brand.setBrandName(brandName);
								brand.setUpdDatetime(new Date());
								brand.setDeletBit(1);
							}
							brand.setUploadDetial(uploadDetial1);
							uploadBrandRepo.save(brand);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/brandDesignation", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject DesignationUpload(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Designation");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String designationName = row.getCell(1).toString();

							UploadDesignation designation = new UploadDesignation();
							UploadDesignation designation2 = uploadDesignationRepo
									.getDesignationByName(designationName);
							if (designation2 != null) {
								designation = designation2;
								designation.setActive(1);
								designation.setDesignationName(designationName);

							} else {
								designation.setActive(1);
								designation.setDesignationName(designationName);
							}
							designation.setUploadDetial(uploadDetial1);
							uploadDesignationRepo.save(designation);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Is Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadCostCenter", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadCostCenter(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Cost Center");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String costCenterName = row.getCell(1).toString();

							UploadCostCenter costCenter = new UploadCostCenter();
							UploadCostCenter costCenter2 = uploadCostCenterRepo.getCostCenterByName(costCenterName);
							if (costCenter2 != null) {
								costCenter = costCenter2;
								costCenter.setActive(1);
								costCenter.setCostCenterName(costCenterName);

							} else {
								costCenter.setActive(1);
								costCenter.setCostCenterName(costCenterName);
							}
							costCenter.setUploadDetial(uploadDetial1);
							uploadCostCenterRepo.save(costCenter);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something is Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadWorkLocation", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadWorkLocation(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Work Location");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String workLocationName = row.getCell(1).toString();

							UploadWorklocation worklocation = new UploadWorklocation();
							UploadWorklocation worklocation2 = uploadWorklocationRepo
									.getWorklocationByName(workLocationName);
							if (worklocation2 != null) {
								worklocation = worklocation2;
								worklocation.setActive(1);
								worklocation.setWorkLocationName(workLocationName);

							} else {
								worklocation.setActive(1);
								worklocation.setWorkLocationName(workLocationName);
							}
							worklocation.setUploadDetial(uploadDetial1);
							uploadWorklocationRepo.save(worklocation);
						}

						System.out.println("Successfully imported");
						workbook.close();
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadSubsidiary", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadSubsidiary(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Spare");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String subsidiaryName = row.getCell(1).toString();

							UploadSubsidiary subsidiary = new UploadSubsidiary();
							UploadSubsidiary subsidiary2 = uploadSubsidiaryRepo.getSubsidiaryByName(subsidiaryName);
							if (subsidiary2 != null) {
								subsidiary = subsidiary2;
								subsidiary.setActive(1);
								subsidiary.setSubsidiaryName(subsidiaryName);

							} else {
								subsidiary.setActive(1);
								subsidiary.setSubsidiaryName(subsidiaryName);
							}
							subsidiary.setUploadDetial(uploadDetial1);
							uploadSubsidiaryRepo.save(subsidiary);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something is Wrong");

					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadSupplier", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadSupplier(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Supplier");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String supplierCode = row.getCell(1).toString();
							String supplierName = row.getCell(2).toString();
							String contactPerson = row.getCell(3).toString();
							String contactNo1 = row.getCell(4).toString();
							String contactNo2 = row.getCell(5).toString();
							String emailId = row.getCell(6).toString();
							String billingAddress = row.getCell(7).toString();
							String billingCityName = row.getCell(8).toString();
							City billingCity = cityRepo.getAllCityByName(billingCityName);
							String billingPincode = row.getCell(9).toString();
							String shippingAddress = row.getCell(10).toString();
							String shippingCityName = row.getCell(11).toString();
							City shippingCity = cityRepo.getAllCityByName(shippingCityName);
							String shippingPincode = row.getCell(12).toString();
							String location = row.getCell(13).toString();
							String gstn = row.getCell(14).toString();
							String paymentMode = row.getCell(15).toString();
							String paymentTerm = row.getCell(16).toString();
							String branchName = row.getCell(17).toString();
							Branch branch = branchRepo.getBranchByName(branchName);

							UploadSupplier supplier2 = uploadSupplierRepo.getSupplierByCode(supplierCode);

							UploadSupplier supplier = new UploadSupplier();

							if (supplier2 != null) {
								supplier = supplier2;
								supplier.setActive(1);
								supplier.setBillingAddress(billingAddress);
								supplier.setBillingCity(billingCity);
								supplier.setBillingPincode(billingPincode);
								supplier.setBranch(branch);
								supplier.setContactNo1(contactNo1);
								supplier.setContactNo2(contactNo2);
								supplier.setContactPerson(contactPerson);
								supplier.setDeletBit(0);
								supplier.setEmailId(emailId);
								supplier.setGstn(gstn);
								supplier.setLocation(location);
								supplier.setPaymentMode(paymentMode);
								supplier.setPaymentTerm(paymentTerm);
								supplier.setShippingAddress(shippingAddress);
								supplier.setShippingCity(shippingCity);
								supplier.setShippingPincode(shippingPincode);
								supplier.setSupplierCode(supplierCode);
								supplier.setUpdDatetime(new Date());
								supplier.setSupplierName(supplierName);
								supplier.setSupplierCode(supplierCode);

							} else {
								supplier.setActive(1);
								supplier.setBillingAddress(billingAddress);
								supplier.setBillingCity(billingCity);
								supplier.setBillingPincode(billingPincode);
								supplier.setBranch(branch);
								supplier.setContactNo1(contactNo1);
								supplier.setContactNo2(contactNo2);
								supplier.setContactPerson(contactPerson);
								supplier.setDeletBit(0);
								supplier.setEmailId(emailId);
								supplier.setGstn(gstn);
								supplier.setLocation(location);
								supplier.setPaymentMode(paymentMode);
								supplier.setPaymentTerm(paymentTerm);
								supplier.setShippingAddress(shippingAddress);
								supplier.setShippingCity(shippingCity);
								supplier.setShippingPincode(shippingPincode);
								supplier.setSupplierCode(supplierCode);
								supplier.setUpdDatetime(new Date());
								supplier.setSupplierName(supplierName);
								supplier.setSupplierCode(supplierCode);

							}
							supplier.setUploadDetial(uploadDetial1);
							uploadSupplierRepo.save(supplier);
						}

						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something is Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadMaterial", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadMaterial(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Material");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String materialCode = row.getCell(1).toString();
							String materialName = row.getCell(2).toString();
							String materialSpecification = row.getCell(3).toString();
							String brandName = row.getCell(4).toString();
							Brand brand = brandRepo.getBrandByName(brandName);
							String categoryName = row.getCell(5).toString();
							Category category = categoryRepo.getCategoryByName(categoryName);
							String uom = row.getCell(6).toString();

							UploadMaterial material2 = uploadMaterialRepo.getMaterialByCode(materialCode);

							UploadMaterial material = new UploadMaterial();

							if (material2 != null) {
								material = material2;
								material.setActive(1);
								material.setBrand(brand);
								material.setCategory(category);
								material.setDeletBit(0);
								material.setMaterialCode(materialCode);
								material.setMaterialName(materialName);
								material.setMaterialSpecification(materialSpecification);
								material.setUom(uom);

							} else {
								material.setBrand(brand);
								material.setCategory(category);
								material.setDeletBit(0);
								material.setMaterialCode(materialCode);
								material.setMaterialName(materialName);
								material.setMaterialSpecification(materialSpecification);
								material.setUom(uom);
								material.setAddedDate(new Date());
							}
							material.setUploadDetial(uploadDetial1);
							uploadMaterialRepo.save(material);
						}
						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						responceObject.setCode(500);
						responceObject.setMsg("Something Wrong");
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responceObject;
	}

	@PostMapping(value = "/uploadEmployee", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponceObject uploadEmployee(@RequestParam("files") MultipartFile[] files,
			@RequestParam("uploadedBy") String uploadedBy

	) throws ParseException {
		ResponceObject responceObject = new ResponceObject();
		try {
			MultipartFile file = files[0];
			if (!(file == null)) {
				if (file.isEmpty()) {
					System.out.println("File not found");
					responceObject.setCode(500);
					responceObject.setMsg("File is Empty");
				} else {
					System.out.println(file.getOriginalFilename());
					try {
						File dir = new File(System.getProperty("catalina.base"), "uploads");
						File uplaodedFile = new File(dir + file.getOriginalFilename());
						file.transferTo(uplaodedFile);
						FileInputStream excelFile = new FileInputStream(uplaodedFile);
						System.out.println("hiiii@  :: " + excelFile);
						Workbook workbook = new XSSFWorkbook(excelFile);
						Sheet datatypeSheet = workbook.getSheetAt(0);
						int i = 1;
						UploadDetial uploadDetial = new UploadDetial();

						Optional<User> optional = userRepo.findById(Integer.valueOf(uploadedBy));
						String filename = file.getOriginalFilename();
						uploadDetial.setFileName(filename);
						uploadDetial.setModuleName("Employee");
						uploadDetial.setNoOfData(datatypeSheet.getLastRowNum());
						uploadDetial.setStatus("Pending");
						uploadDetial.setUploadedBy(optional.get());
						UploadDetial uploadDetial1 =uploadDetialRepo.save(uploadDetial);

						while (i <= datatypeSheet.getLastRowNum()) {

							XSSFRow row = null;
							row = (XSSFRow) datatypeSheet.getRow(i++);
							String str = row.getCell(0).toString();
							if (str.length() == 0) {
								continue;
							}
							System.out.println("ROW 0  " + row.getCell(0).toString());
							System.out.println("ROW 1  " + row.getCell(1).toString());

							String employeeCode = row.getCell(1).toString();
							String title = row.getCell(2).toString();
							String fName = row.getCell(3).toString();
							String lName = row.getCell(4).toString();
							String emailId = row.getCell(5).toString();
							String contactNo = row.getCell(6).toString();
							String gender = row.getCell(7).toString();
							String departmentName = row.getCell(8).toString();
							Department department = departmentRepo.getDepartmentByname(departmentName);
							String branchName = row.getCell(9).toString();
							Branch branch = branchRepo.getBranchByName(branchName);

							String designationName = row.getCell(10).toString();
							Designation designation = designationRepo.getDesignationByName(designationName);
							String dob = row.getCell(11).toString();
							Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
							String doj = row.getCell(12).toString();
							Date dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(doj);

							String manager = row.getCell(13).toString();
							String workLocation = row.getCell(14).toString();
							String costCenter = row.getCell(15).toString();
							String businessUnit = row.getCell(16).toString();
							String subsidiary = row.getCell(17).toString();
							String deskNo = row.getCell(18).toString();
							String uhfCode = row.getCell(19).toString();

							UploadEmployee employee2 = uploadEmployeeRepo.getEmployeeByCode(employeeCode);

							UploadEmployee employee = new UploadEmployee();

							if (employee2 != null) {
								employee = employee2;
								employee.setBranch(branch);
								employee.setBusinessUnit(businessUnit);
								employee.setContactNo(contactNo);
								// employee.set
								employee.setCostCenter(costCenter);
								employee.setDateOfBirth(dateOfBirth);
								employee.setDateOfJoining(dateOfJoining);
								employee.setDepartment(department);
								employee.setDesignation(designation);
								employee.setDeskNo(deskNo);
								employee.setEmailId(emailId);
								employee.setEmoloyeeCode(employeeCode);
								employee.setfName(fName);
								employee.setlName(lName);
								employee.setGender(gender);
								// employee.setManagerId(managerId);
								employee.setSubsidiary(subsidiary);
								employee.setTitle(title);
								employee.setUhfCode(uhfCode);
								employee.setWorkLocation(workLocation);

							} else {
								employee.setAddedDate(new Date());

								employee.setBranch(branch);
								employee.setBusinessUnit(businessUnit);
								employee.setContactNo(contactNo);
								employee.setCostCenter(costCenter);
								employee.setDateOfBirth(dateOfBirth);
								employee.setDateOfJoining(dateOfJoining);
								employee.setDepartment(department);
								employee.setDesignation(designation);
								employee.setDeskNo(deskNo);
								employee.setEmailId(emailId);
								employee.setEmoloyeeCode(employeeCode);
								employee.setfName(fName);
								employee.setlName(lName);
								employee.setGender(gender);
								// employee.setManagerId(managerId);
								employee.setSubsidiary(subsidiary);
								employee.setTitle(title);
								employee.setUhfCode(uhfCode);
								employee.setWorkLocation(workLocation);
							}
							employee.setUploadDetial(uploadDetial1);
							uploadEmployeeRepo.save(employee);
						}
						System.out.println("Successfully imported");
						workbook.close();
						uploadDetialRepo.save(uploadDetial);
						responceObject.setCode(200);
						responceObject.setMsg("File is Uploaded");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

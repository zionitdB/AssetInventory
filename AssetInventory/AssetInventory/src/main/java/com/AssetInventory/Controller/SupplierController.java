package com.AssetInventory.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.DTO.SupplierDetials;
import com.AssetInventory.DTO.SupplierMaterialDto;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Supplier;
import com.AssetInventory.Model.SupplierAccounts;
import com.AssetInventory.Model.SupplierMaterial;
import com.AssetInventory.Repository.MaterialRepo;
import com.AssetInventory.Repository.SupplierMaterialRepo;
import com.AssetInventory.Service.SupplierService;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("/supplier")  
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	@Autowired
	SupplierMaterialRepo supplierMaterialRepo;
	
	@Autowired
	MaterialRepo materialRepo;
	
	@RequestMapping(value = "/addSupplierDetials", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addSupplierDetials(@RequestBody SupplierDetials supplierDetials) {
		ResponceObject responceObject = new ResponceObject();
		try {
			responceObject = supplierService.addSupplierDetials(supplierDetials);
			
		/*	if(!supplier.getEmailId().equalsIgnoreCase("")){
				String message="<h5> Hello "+supplier.getSupplierName()+" "+",</h5> Your details has been  added "+" "+"<br><br>"+"Regards<br>";
				System.out.println("pass :"+ supplier.getSupplierName().toString());
				emailSmsService.sendMail(supplier.getEmailId(), "Supplier has been added Successfully", message);
			}
			*/

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
		}
		return responceObject;
	}
	
		@RequestMapping(value = "/getlistSupplierByLimit", method = RequestMethod.GET)
		public @ResponseBody List<Supplier> getlistSupplierByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
			List<Supplier> list= new  ArrayList<Supplier>();
			try {	
				list=supplierService.getlistSupplierByLimit(pageNo,perPage);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		@RequestMapping(value = "/getlistSupplierLimitAndSearch", method = RequestMethod.GET)
		public @ResponseBody List<Supplier> getlistSupplierLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
			List<Supplier> list= new  ArrayList<Supplier>();
			try {	
				list=supplierService.getlistSupplierLimitAndSearch(searchText,pageNo,perPage);			
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}


		@RequestMapping(value = "/getSupplierCount", method = RequestMethod.GET)
		public @ResponseBody int  getSupplierCount() {
			int  supplierCount= 0;
			try {
				supplierCount= supplierService.getSupplierCount();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return supplierCount;
		}

		
		@RequestMapping(value = "/getSupplierCountAndSearch", method = RequestMethod.GET)
		public @ResponseBody int  getSupplierCountAndSearch(@RequestParam("searchText") String searchText) {
			int  supplierCount= 0;
			try {
				supplierCount= supplierService.getgetSupplierCountAndSearch(searchText);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return supplierCount;
		}
		

		@RequestMapping(value = "/changeSupplierStatus", method = RequestMethod.POST)
		public @ResponseBody ResponceObject changeSupplierStatus(@RequestBody Supplier supplier) {
			ResponceObject responceObject = new ResponceObject();
			try {
				if(supplier.getActive()==1){supplier.setActive(0);}else{
					supplier.setActive(1);
				}
				 supplierService.addSupplier(supplier);
				 responceObject.setCode(200);
					responceObject.setMsg("Status Change Successfully");

			} catch (Exception e) {
				System.err.println(e.toString());
			}
			return responceObject;
		}
		@RequestMapping(value = "/getAllActiveSupplier", method = RequestMethod.GET)
		public @ResponseBody List<Supplier> getAllActiveSupplier() {
			List<Supplier> suppliers= null;
			try {
				suppliers = supplierService.getAllActiveSupplier();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suppliers;
		}
		@RequestMapping(value = "/getAllSupplier", method = RequestMethod.GET)
		public @ResponseBody List<Supplier> getUsers() {
			List<Supplier> suppliers= null;
			try {
				suppliers = supplierService.getAllSupplier();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return suppliers;
		}
		
		@RequestMapping(value = "/getSupplierAccountBySupplier", method = RequestMethod.GET)
		public @ResponseBody List<SupplierAccounts> getSupplierAccountBySupplier(@RequestParam("supplierId") int supplierId) {
			List<SupplierAccounts> supplierAccounts= null;
			try {
				supplierAccounts= supplierService.getSupplierAccountBySupplier(supplierId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return supplierAccounts;
		}
		@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
		public @ResponseBody ResponceObject changeStatus(@RequestBody Supplier supplier) {
			ResponceObject responceObject = new ResponceObject();
			try {
				if(supplier.getActive()==1){
					supplier.setActive(0);
				}else{
					supplier.setActive(1);
				}
				 supplierService.addSupplier(supplier);
				 responceObject.setCode(200);
				 responceObject.setMsg("Status Change successfully");

			} catch (Exception e) {
				System.err.println(e.toString());
				 responceObject.setCode(500);
				 responceObject.setMsg("Something Wrong");
			}
			return responceObject;
		}
		
		
		
		
		@RequestMapping(value = "/addSupplierMaterial", method = RequestMethod.POST)
		public @ResponseBody ResponceObject addSupplierMaterial(@RequestBody SupplierMaterialDto supplierMaterialDto) {
			ResponceObject responceObject = new ResponceObject();
			try {
				for(Material material:supplierMaterialDto.getMaterials()){
					
					SupplierMaterial supplierMaterial= new SupplierMaterial();
					supplierMaterial.setMaterial(material);
					supplierMaterial.setSupplier(supplierMaterialDto.getSupplier());
					supplierMaterial.setActive(1);
					supplierMaterial.setAddedBy(supplierMaterialDto.getAddedBy());
					supplierMaterial.setAddedDate(supplierMaterialDto.getAddedDate());
					supplierMaterial.setUpdDatetime(supplierMaterialDto.getAddedDate());
					supplierMaterialRepo.save(supplierMaterial);
				}
				 responceObject.setCode(200);
				 responceObject.setMsg("Material saved for Supplierr successfully");

			} catch (Exception e) {
				System.err.println(e.toString());
				 responceObject.setCode(500);
				 responceObject.setMsg("Something Wrong");
			}
			return responceObject;
		}
		
		
		@RequestMapping(value = "/getAllUnassingedMaterialToSupplier", method = RequestMethod.GET)
		public @ResponseBody List<Material> getAllUnassingedMaterialToSupplier(@RequestParam("supplierId") int supplierId) {
			List<Material> list= new ArrayList<Material>();
			try {
				List<Material> suplist = supplierService.getAllMaterialBySupplier(supplierId);
				List<Material> allMaterials=materialRepo.getAllActiveMaterial();
				if(suplist.size()!=0){
					for(Material material:suplist){
						for(Material material2:allMaterials){
							if(material.getMaterialId()!=material2.getMaterialId()){
								list.add(material2);
							}
						}
					}
				}else{
				list=	allMaterials;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		@RequestMapping(value = "/getAllMaterialBySupplier", method = RequestMethod.GET)
		public @ResponseBody List<Material> getAllMaterialBySupplier(@RequestParam("supplierId") int supplierId) {
			List<Material> list= null;
			try {
				list = supplierService.getAllMaterialBySupplier(supplierId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}

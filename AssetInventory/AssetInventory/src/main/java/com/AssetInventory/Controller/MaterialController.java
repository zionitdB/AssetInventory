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
import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.Brand;
import com.AssetInventory.Model.Category;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.UnitOfMeasurement;
import com.AssetInventory.Repository.AssetInventoryRepo;
import com.AssetInventory.Service.MaterialService;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	MaterialService materialService;
	@Autowired
	AssetInventoryRepo assetInventoryRepo;

	@RequestMapping(value = "/addMaterial", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addMaterial(@RequestBody Material material) {
		ResponceObject responceObject = new ResponceObject();
		try {
			Material material2 = materialService.addMaterial(material);
			responceObject.setCode(200);
			responceObject.setMsg("Material Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/deleteMaterial", method = RequestMethod.POST)
	public @ResponseBody ResponceObject deleteMaterial(@RequestBody Material material) {
		ResponceObject responceObject = new ResponceObject();
		try {
			List<AssetInventory> list  = assetInventoryRepo.getAssetInventoryByMaterialId(material.getMaterialId());
			if(list.size()==0) {
				responceObject.setCode(200);
				responceObject.setMsg("Material Deleted Successfully");
				materialService.deleteMaterial(material);
			}else {
				responceObject.setCode(500);
				responceObject.setMsg("Material Can't Be Deleted ...already proccess");
			}
			
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}

	
	
	@RequestMapping(value = "/getlistMaterialsByLimit", method = RequestMethod.GET)
	public @ResponseBody List<Material> getlistMaterialsByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPag) {
		List<Material> list= new  ArrayList<Material>();
		try {	
			list=materialService.getlistMaterialsByLimit(pageNo,perPag);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	@RequestMapping(value = "/getlistMaterialByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<Material> getlistMaterialByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<Material> list= new  ArrayList<Material>();
		try {	
			list=materialService.getlistMaterialByLimitAndSearch(searchText,pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	@RequestMapping(value = "/getMaterialsCount", method = RequestMethod.GET)
	public @ResponseBody int  getMaterialsCount() {
		int  supplierCount= 0;
		try {
			supplierCount= materialService.getMaterialsCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	


	
	@RequestMapping(value = "/getMaterialsCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getMaterialsCountAndSearch(@RequestParam ("searchText") String searchText) {
		int  materialCount= 0;
		try {
			materialCount= materialService.getMaterialsCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materialCount;
	}
	
	
	
	@RequestMapping(value = "/getMaterialByCategoryAndBrand", method = RequestMethod.GET)
	public @ResponseBody List<Material> getMaterialByCategoryAndBrand(@RequestParam("categoryId") int categoryId,@RequestParam("brandId") int brandId) {
		List<Material> list= new ArrayList<Material>();
		try {
			list = materialService.getMaterialByCategoryAndBrand(categoryId,brandId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addCategory(@RequestBody Category category) {
		ResponceObject responceObject = new ResponceObject();
		try {
			Category category2 = materialService.addCategory(category);
			responceObject.setCode(200);
			responceObject.setMsg("Category Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	

	@RequestMapping(value = "/addBrand", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addBrand(@RequestBody Brand brand) {
		ResponceObject responceObject = new ResponceObject();
		try {
			System.out.println("ADD BRNAD");
			Brand brand2 = materialService.addBrand(brand);
			responceObject.setCode(200);
			responceObject.setMsg("Brand Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllBrand", method = RequestMethod.GET)
	public @ResponseBody List<Brand> getAllBrand() {
		List<Brand> brands= null;
		try {
			brands = materialService.getAllBrand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brands;
	}
	@RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategory() {
		List<Category> categories= new ArrayList<Category>();
		try {
			categories = materialService.getAllCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	public @ResponseBody ResponceObject changeStatus(@RequestBody Material material) {
		ResponceObject responceObject = new ResponceObject();
		try {
			if(material.getActive()==1){
				material.setActive(0);
			}else{
				material.setActive(1);
			}
			 materialService.addMaterial(material);
			responceObject.setCode(200);
			responceObject.setMsg("Material Status Change  Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/getAllActiveMaterial", method = RequestMethod.GET)
	public @ResponseBody List<Material> getAllActiveMaterial() {
		List<Material> list= new ArrayList<Material>();
		try {
			list = materialService.getAllActiveMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAllMaterial", method = RequestMethod.GET)
	public @ResponseBody List<Material> getAllMaterial() {
		List<Material> list= new ArrayList<Material>();
		try {
			list = materialService.getAllMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@RequestMapping(value = "/addUnitOfMeasurement", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addUnitOfMeasurement(@RequestBody UnitOfMeasurement unitOfMeasurement) {
		ResponceObject responceObject = new ResponceObject();
		try {
		
			UnitOfMeasurement brand2 = materialService.addUnitOfMeasurement(unitOfMeasurement);
			responceObject.setCode(200);
			responceObject.setMsg("UnitOfMeasurement Added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllUnitOfMeasurement", method = RequestMethod.GET)
	public @ResponseBody List<UnitOfMeasurement> getAllUnitOfMeasurement() {
		List<UnitOfMeasurement> brands= null;
		try {
			brands = materialService.getAllUnitOfMeasurement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brands;
	}
}

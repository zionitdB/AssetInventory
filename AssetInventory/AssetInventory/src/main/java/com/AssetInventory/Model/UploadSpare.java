
package com.AssetInventory.Model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="upload_spare_data")
public class UploadSpare {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="category")
	private String category;
	
	
	@Column(name="spare_name")
	private String spareName;
	
	@Column(name="spare_unique_code")
	private String spareUniqueCode;
	
	
	@Column(name="consume_bit")
	private int consumeBit;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="specification")
	private String specification;
	
	
	@ManyToOne
	@JoinColumn(name="upload_detials_id")
	private UploadDetial uploadDetial;

	public UploadDetial getUploadDetial() {
		return uploadDetial;
	}

	public void setUploadDetial(UploadDetial uploadDetial) {
		this.uploadDetial = uploadDetial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSpareName() {
		return spareName;
	}

	public void setSpareName(String spareName) {
		this.spareName = spareName;
	}

	public String getSpareUniqueCode() {
		return spareUniqueCode;
	}

	public void setSpareUniqueCode(String spareUniqueCode) {
		this.spareUniqueCode = spareUniqueCode;
	}

	public int getConsumeBit() {
		return consumeBit;
	}

	public void setConsumeBit(int consumeBit) {
		this.consumeBit = consumeBit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	

}

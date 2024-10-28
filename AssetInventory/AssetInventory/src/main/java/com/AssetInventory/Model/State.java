package com.AssetInventory.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="state_mst")
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="state_id")
	private int stateId;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="state_code")
	private String stateCode;

}

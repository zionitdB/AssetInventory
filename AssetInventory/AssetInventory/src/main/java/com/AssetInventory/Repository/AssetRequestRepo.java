package com.AssetInventory.Repository;

import java.util.List;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.Employee;

public interface AssetRequestRepo extends JpaRepository<AssetRequest, Integer>,AssetRequestCustomeRepo{

	
	

}

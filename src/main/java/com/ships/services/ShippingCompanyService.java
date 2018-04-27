package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepository;

@Service
public class ShippingCompanyService {
	
	@Autowired
	ShippingCompanyRepository companyRepository;
	
	public List<ShippingCompany> findAllShipCompany(){
		
		 List<ShippingCompany> companies = (List<ShippingCompany>) companyRepository.findAll();
		  
		  return companies;
		
		
	}
	  public ShippingCompany findByIdShipCompany(Integer id){
		  
			return  companyRepository.findOne(id);
		  }
	  
	 public ShippingCompany addShipCompany(ShippingCompany company){
		  
		  
		  return companyRepository.save(company);
		  
	  }

}

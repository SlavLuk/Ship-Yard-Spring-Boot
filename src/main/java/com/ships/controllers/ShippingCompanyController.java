package com.ships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {

	@Autowired
	ShippingCompanyService companyService;
	
	
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String showShippingCompany(Model model){
		
		List<ShippingCompany> shippingCompany = companyService.findAllShipCompany();
		
		model.addAttribute("shippingCompany", shippingCompany);
		
		return "showShippingCompanies";
		
	}
	
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("shipCompany") ShippingCompany shipCompany, BindingResult result){
		
		if (result.hasErrors()) {
			
			
			return "addShippingCompany";
		}
		
		companyService.addShipCompany(shipCompany);	
		
			return "redirect:showShippingCompanies";
		
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String addShip(@ModelAttribute("shipCompany") ShippingCompany shipCompany){
		
		
		
		
			return "addShippingCompany";
		
	}
	
	
	
}

package com.ships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ships.model.Ship;
import com.ships.services.ShipService;


@Controller
public class ShipController {

	@Autowired
	ShipService shipService;
	
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String showShips(Model model){
		List<Ship> ships = shipService.findAllShips();
		model.addAttribute("ships", ships);
			return "showShips";
		
	}

	
	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("ship") Ship ship, BindingResult result){
		
		if (result.hasErrors()) {
			return "addShip";
		}
		
		shipService.addShip(ship);
		
			return "redirect:showShips";
		
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addShip(@ModelAttribute("ship") Ship ship){
		
		
		
		
			return "addShip";
		
	}
	
}

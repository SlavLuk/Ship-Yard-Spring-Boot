package com.ships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
  @Autowired
  ShipRepository shipRepository;
  
  public List<Ship> findAllShips(){
	  
	  List<Ship>ships = (List<Ship>) shipRepository.findAll();
	  
	  return ships;
  }
  
  public Ship findByIdShip(Integer id){
	  
	return  shipRepository.findOne(id);
  }
  
  public Ship addShip(Ship s){
	  
	  
	  return shipRepository.save(s);
	  
  }
  
  public List<Ship> shipNotWithCompany() {
	
	  return shipRepository.shipNotWithCompany();
}
  
}

package com.ships.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	ShipService shipService;
	@Autowired
	ShippingCompanyService shipCompanyService;

	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showOrder(Model model) {
		List<OrderInfo> orders = orderService.findAllOrderInfo();
		model.addAttribute("orders", orders);
		return "showOrders";

	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(@ModelAttribute("info") OrderInfo info) {

		if (info != null) {

			Ship s = shipService.findByIdShip(info.getShip().getSid());
			ShippingCompany sc = shipCompanyService.findByIdShipCompany(info.getShippingCompany().getScid());

			OrderInfo order = new OrderInfo();

			Date now = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			
			order.setDate(ft.format(now));
			order.setShip(s);
			order.setShippingCompany(sc);
			
			orderService.addOrder(order);

			return "redirect:showOrders";
		}

		return "createOrder";

	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String createOrder(Model model) {

		List<Ship> ships = shipService.shipNotWithCompany();
		List<ShippingCompany> shipCompList = shipCompanyService.findAllShipCompany();

		Map<Long, String> shipList = new HashMap<>();
		Map<Long, String> shipCompanies = new HashMap<>();

		for (Ship s : ships) {

			String shipName = s.getName() + "; Cost = " + s.getCost();

			shipList.put((Long) ((long) s.getSid()), shipName);

		}
		for (ShippingCompany sc : shipCompList) {

			String shipComName = sc.getName() + "; Balance = " + sc.getBalance();
			shipCompanies.put((Long) ((long) sc.getScid()), shipComName);
		}

		model.addAttribute("shipList", shipList);
		model.addAttribute("shipCompList", shipCompanies);

		OrderInfo info = new OrderInfo();
		model.addAttribute("info", info);

		return "createOrder";

	}

}

package com.ships.controllers;

import java.math.BigDecimal;
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

	// request handler for showOrders
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showOrder(Model model) {

		List<OrderInfo> orders = orderService.findAllOrderInfo();
		model.addAttribute("orders", orders);

		return "showOrders";

	}

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public String createOrder(@ModelAttribute("info") OrderInfo info) {

		if (info.getShip() == null || info.getShippingCompany() == null) {

			return "forward:errorSelected";

		} else {

			if (info.getShip().getCost().compareTo(info.getShippingCompany().getBalance()) == 1) {

				return "forward:orderError";

			} else {

				Ship ship = info.getShip();

				ShippingCompany sc = info.getShippingCompany();

				BigDecimal newBalance = info.getShippingCompany().getBalance().subtract(info.getShip().getCost());

				sc.setBalance(newBalance);

				shipCompanyService.addShipCompany(sc);

				ship.setShippingCompany(sc);

				shipService.addShip(ship);

				OrderInfo order = new OrderInfo();

				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

				order.setDate(ft.format(new Date()));
				order.setShip(ship);
				order.setShippingCompany(sc);

				orderService.addOrder(order);

				return "redirect:showOrders";
			}

		}

	}

	

	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public String createOrder(Model model) {

		List<Ship> ships = shipService.shipNotWithCompany();
		List<ShippingCompany> shipCompList = shipCompanyService.findAllShipCompany();

		Map<Long, String> shipList = new HashMap<>();
		Map<Long, String> shipCompanies = new HashMap<>();

		for (Ship s : ships) {

			String shipName = s.getName() + "; Cost = " + s.getCost();

			shipList.put(((long) s.getSid()), shipName);

		}
		for (ShippingCompany sc : shipCompList) {

			String shipComName = sc.getName() + "; Balance = " + sc.getBalance();
			shipCompanies.put(((long) sc.getScid()), shipComName);
		}

		model.addAttribute("shipList", shipList);
		model.addAttribute("shipCompList", shipCompanies);

		OrderInfo info = new OrderInfo();
		model.addAttribute("info", info);

		return "createOrder";

	}
	
	@RequestMapping(value = "/orderError", method = RequestMethod.POST)
	public String orderError() {

		return "orderError";

	}

	@RequestMapping(value = "/errorSelected", method = RequestMethod.POST)
	public String orderErrorShip() {

		return "errorSelected";

	}

}

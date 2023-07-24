package com.elastic.drool.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elastic.drool.model.Order;

@RestController
public class AmazonMegaOffer {

	@Autowired
	private KieSession session;

	/**
	 * 
	 * @param order
	 * @return
	 */

	@PostMapping("/createOrder")
	public Order orderNow(@RequestBody Order order) {
		session.insert(order);
		session.fireAllRules();
		return order;
	}

}

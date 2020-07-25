package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Inventory;

import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/getAllInventories")
	public Iterable<Inventory> getAll() {
		return inventoryService.getAll();
	}


}

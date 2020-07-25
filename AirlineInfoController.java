package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.AirlineInfo;
import com.example.demo.service.AirlineInfoService;


@RestController
@RequestMapping("/airlineinfo")
public class AirlineInfoController {
	@Autowired
	AirlineInfoService airlineInfoService;
	
	@GetMapping("/getAllInventories")
	public Iterable<AirlineInfo> getAll() {
		return airlineInfoService.getAll();
	}


	
	

}

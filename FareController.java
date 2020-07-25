package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Fare;

import com.example.demo.service.FareService;


@RestController
@RequestMapping("/fare")
public class FareController {
	@Autowired
	FareService fareService;
	
	@GetMapping("/getAllFares")
	public Iterable<Fare> getAll() {
		return fareService.getAll();
	}

}

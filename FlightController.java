package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Flight;
import com.example.demo.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping("/getAllFlights")
	public Iterable<Flight> getAll() {
		return flightService.getAll();
	}
	@GetMapping("/Search/airline={airlineId}/date={flightDate}")
	public List<Flight> listAll3(@PathVariable("airlineId") String airlineId,@PathVariable("flightDate") String flightDate) {
	 List<Flight> flights = flightService.search(airlineId, LocalDate.parse(flightDate));
	 return flights;
	 }
	
	@GetMapping("/Search/{flightDate}/{origin}/{destination}")

	 public List<Flight> listAll(@PathVariable("flightDate") String flightDate, @PathVariable("origin") String origin,
	  @PathVariable("destination") String destination) {
	 List<Flight> flights = flightService.search1(LocalDate.parse(flightDate), origin,destination);
	 return flights;
}
	@GetMapping("/Search1/{flightDate}/{origin}")

	 public List<Flight> listAll2(@PathVariable("flightDate") String flightDate, @PathVariable("origin") String origin ) {
	 List<Flight> flights = flightService.search2(LocalDate.parse(flightDate), origin);
	 return flights;
}
	@GetMapping("/Search2/{flightNumber}/{origin}/{destination}")
	 public List<Flight> listAll1(@PathVariable("flightNumber") String flightNumber, @PathVariable("origin") String origin,@PathVariable("destination") String destination ) {
	 List<Flight> flights = flightService.search3(flightNumber, origin, destination);
	 return flights;
}


	@PutMapping("/updateTime/{id}/time={flightTime}/{flightDate}")
	public Flight updateFlightTime(@RequestBody Flight flight,@PathVariable("id") Long id,@PathVariable("flightTime") String flightTime,@PathVariable("flightDate") String flightDate)
	{
     return	flightService.save(flight,id,flightTime,flightDate);
	
	}
}


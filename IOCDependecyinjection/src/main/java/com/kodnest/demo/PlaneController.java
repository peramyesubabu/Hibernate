package com.kodnest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaneController {
	// DI through field
//	@Autowired
	Plane ref;

	// DI through constructor
//	@Autowired
//	public PlaneController(@Qualifier("passengerPlane") Plane ref)
//	public PlaneController(@Qualifier("fighterPlane") Plane ref)//fighterPlane is a reference variable of Fighter plane object
	public PlaneController(Plane ref) {//Qualifier is > primary
		this.ref = ref;
	}

	// DI through setter
//	@Autowired
//	public void setref(Plane ref)
//	{
//		this.ref=ref;
//	}
	@GetMapping("/Cargoplane")
	public String cargoplane() {
		return ref.takeoff();
	}
}

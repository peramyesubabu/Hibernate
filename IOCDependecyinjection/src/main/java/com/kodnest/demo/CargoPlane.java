package com.kodnest.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CargoPlane implements Plane {

	public CargoPlane() {
		System.out.println("cargo plane created");
	}
	@Override
	public String takeoff() {
		// TODO Auto-generated method stub
		return "Cargo plane is flying";
	}
}

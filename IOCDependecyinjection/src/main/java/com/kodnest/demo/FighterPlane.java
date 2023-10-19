package com.kodnest.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class FighterPlane implements Plane {

	public FighterPlane() {
		System.out.println("Fighter plane created");
	}
	@Override
	public String takeoff() {
		// TODO Auto-generated method stub
		return "Fighter plane takes of on a huge run way";
	}

}

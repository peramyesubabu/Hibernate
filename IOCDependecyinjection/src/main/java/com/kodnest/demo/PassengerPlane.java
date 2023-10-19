package com.kodnest.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
//@Primary
@Lazy
public class PassengerPlane implements Plane {
public  PassengerPlane() {
	System.out.println("passenger plane created");
}
	@Override
	public String takeoff() {
		// TODO Auto-generated method stub
		return "passenger plane takes of on a small run way";
	}

}

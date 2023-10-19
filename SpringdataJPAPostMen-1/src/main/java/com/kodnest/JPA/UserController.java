package com.kodnest.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	UserDAOImplementation ref;

	@Autowired

	public UserController(UserDAOImplementation ref) {

		this.ref = ref;

	}

	
	@PostMapping("/saveuser")
	public String persistUser(@RequestBody User u)

	{

		ref.save(u);

		return "Success";

	}

}

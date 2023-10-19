package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/nav")
public class NavigationController {
	@Autowired
	UserService uService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/adduser")
	public String addUser(@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("role")String role)
	{
		boolean emailExists=uService.checkEmail(email);
		if(emailExists == false)
		{
			Users user=new Users();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			uService.addUser(user);
			System.out.println("user registered Successfully!");
			return "redirect:/nav/login";
		}
		else
		{
			System.out.println("user already exists");
			return "redirect:/registerFail";
		}
	}
	@PostMapping("/validate")

	public String validate(@RequestParam("email")String email,

	@RequestParam("password")String password,

	HttpSession session) {

	if(uService.checkEmail(email)) {

	boolean val=uService.validate(email, password);

	//if user is valid

	if(val==true) {

	Users user = uService.getUser(email); // Assuming you have a method to get the User object

	session.setAttribute("loggedInUser", user); // Saving the User object in session

	if(uService.getUserRole(email).equals("trainer")) {

	return "trainerHome";

	}

	else {

	return "studentHome";

	}

	}

	else {

	System.out.println("incorrect credentials, try again!");

	return "loginFail";

	}

	}

	else {

	return "loginFail";

	}

	}
}

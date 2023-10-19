package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "student added successfully";
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return repo.existByEmail(email);
	}

	@Override

	public boolean validate(String email, String password) {

		if (repo.existByEmail(email)) {

			Users u = repo.getByEmail(email);

			String dbPassword = u.getPassword();

			if (password.equals(dbPassword)) {

				return true;

			}

			else {

				return false;

			}

		}

		else {

			return false;

		}

	}

	@Override

	public Users getUser(String email) {

		return repo.getByEmail(email);

	}

	@Override

	public String getUserRole(String email) {

		Users u = repo.getByEmail(email);

		return u.getRole();

	}

	@Override

	public String updateUser(Users user) {

		repo.save(user);

		return "student updated successfully!";

	}

}

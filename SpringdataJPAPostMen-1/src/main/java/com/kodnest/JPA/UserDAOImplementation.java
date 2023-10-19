package com.kodnest.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserDAOImplementation implements UserDAO {
	EntityManager ref;

	@Autowired
	public UserDAOImplementation(EntityManager ref) {
		this.ref = ref;
	}

	@Override
	@Transactional
	public void save(User u) {
		ref.persist(u);
	}

}

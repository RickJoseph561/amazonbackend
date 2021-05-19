package com.reactbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactbackend.bean.User;
import com.reactbackend.exception.NonUniquenameException;
import com.reactbackend.respository.UserRespository;





@Service
public class UserService {
	@Autowired
	UserRespository  userres;
	
	
	
	public User getUserByname(String name) {
		// TODO Auto-generated method stub
		return userres.findByName(name);
	}



	public Integer addUser(User person) throws NonUniquenameException {
		// TODO Auto-generated method stub
		return userres.save(person).getId();
	}

}

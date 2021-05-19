package com.reactbackend.respository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.reactbackend.bean.User;

public interface UserRespository extends JpaRepository<User, Integer> {
	
	
	public User findByName(String name);

}

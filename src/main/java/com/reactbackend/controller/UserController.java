package com.reactbackend.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactbackend.bean.User;

import com.reactbackend.exception.NonUniquenameException;
import com.reactbackend.service.UserService;




@RestController
@CrossOrigin(origins="http://localhost:3000",allowCredentials="true")
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	 private UserService userserv;
	@GetMapping
	public ResponseEntity<User> checkLogin(HttpSession session) {
		User loggedPerson = (User) session.getAttribute("user");
		 
	
	if (loggedPerson == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(loggedPerson);
	}
	@PutMapping
	public ResponseEntity<User> logIn(HttpSession session, @RequestBody Map<String, String> loginInfo) {
		User person = userserv.getUserByname(loginInfo.get("name"));
	
		if (person != null) {
			if (person.getPassword().equals(loginInfo.get("password"))) {
				session.setAttribute("user", person);
				return ResponseEntity.ok(person);
			}
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> registerUser(HttpSession session, @RequestBody User person)  {
		try {
			userserv.addUser(person);
		} catch (NonUniquenameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}

	
	
	@DeleteMapping
	public ResponseEntity<Void> logOut(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
}

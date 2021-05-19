package com.reactbackend;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reactbackend.bean.User;
import com.reactbackend.service.UserService;



@SpringBootTest
class SpringbootbackReact2ApplicationTests {
	@Autowired
	  private UserService userserv;
	@Test
	public void projectstart(){
		
		User user =  userserv.getUserByname("rev");
		User user1 =  new User();
		user1.setId(1);
		user1.setName("rev");
		user1.setPassword("pass");
		
		
		Assert.assertEquals(user.getName(),user1.getName());
		
		
	}

}

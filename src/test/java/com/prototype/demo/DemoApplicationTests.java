package com.prototype.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;







	
    // springBoostTest is for testing full application
	@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
	@AutoConfigureTestRestTemplate
	 
	/**
	 * InnerDemoApplicationTests
	 */
   class DemoApplicationTests {
		
	          @Autowired 
	         private TestRestTemplate restTemplate ;

         // rember we used Test before the methode
         // should return users when data found

	@Test
	void shouldReturnNewUser(){
		// create new object called NewUser type User
		// why ID is NUll ? because the server will create it
        User NewUser = new User(null, "Yassin");

	    ResponseEntity<Void> creaResponse = restTemplate.postForEntity("/users", NewUser, void.class);

	}
       
		
	}



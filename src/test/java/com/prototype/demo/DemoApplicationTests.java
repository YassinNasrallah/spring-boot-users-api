package com.prototype.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

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
		// 1 - create new object called NewUser type User
		// why ID is NUll ? because the server will create it
        User NewUser = new User(null, "Yassin");
		// 2 - send data to body
        // postForEntity (url, body, responseType) sends newCashCard as JSON in a POST request
	    ResponseEntity<Void> creatResponse = restTemplate.postForEntity("/users", NewUser, Void.class);
        // 3 - now we need to check if data created 
		assertThat(creatResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		// 4 - Get the Location header and fetch the new card
        //createResponse is the ResponseEntity<Void> you got back from postForEntity.
        //getHeaders() returns all the HTTP headers of that response.
        //getLocation() picks out the Location header and converts it to a URI object
		 URI LocationOfNewUser = creatResponse.getHeaders().getLocation();
         // get the respone as a string because when used json
		 ResponseEntity<String> response = restTemplate.getForEntity(LocationOfNewUser, String.class);

		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
       
		
	}



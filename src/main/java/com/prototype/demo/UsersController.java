package com.prototype.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController // this class handles web requests and returns data
@RequestMapping("/users")  // all URLs here start with /User
class UsersController {
    
    private final UsersRepository usersRepository;

    private UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository ;
    }

    @GetMapping("/{requestedId}")
    private  ResponseEntity<User> findById(@PathVariable long requestedId){
        Optional<User> userOptional = usersRepository.findById(requestedId);
        if(userOptional.isPresent())
            {
            return ResponseEntity.ok(userOptional.get());
            }
         return ResponseEntity.notFound() //start building a 404 response
         .build(); // finish it and return it
    };
    
    //It handles the POST request
    @PostMapping
    private ResponseEntity<Void> createNewData(@RequestBody User newUserRequest, UriComponentsBuilder ucb){
      User savedUser = usersRepository.save(newUserRequest);

      URI locationOfNewdata = ucb
      .path("users/{id}")
      .buildAndExpand(savedUser.id())
      .toUri();

      return ResponseEntity.created(locationOfNewdata).build();
    }

    
    
}

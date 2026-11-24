package com.prototype.demo;

import org.springframework.data.repository.CrudRepository;

interface UsersRepository extends CrudRepository<User, Long>{
    
    
}
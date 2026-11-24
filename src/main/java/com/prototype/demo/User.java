package com.prototype.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Table("users")
 record User(@Id Long id, String name) {
    
}

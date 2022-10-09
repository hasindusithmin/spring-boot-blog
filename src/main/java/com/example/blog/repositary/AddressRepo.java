package com.example.blog.repositary;

import org.springframework.data.repository.CrudRepository;

import com.example.blog.model.Address;

public interface AddressRepo extends CrudRepository<Address,Integer>{
    
}

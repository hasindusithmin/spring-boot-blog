package com.example.blog.repositary;

import org.springframework.data.repository.CrudRepository;

import com.example.blog.model.Client;

public interface ClientRepo extends CrudRepository<Client,Integer>{
    
}

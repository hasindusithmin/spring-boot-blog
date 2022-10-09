package com.example.blog.repositary;

import org.springframework.data.repository.CrudRepository;

import com.example.blog.model.Company;

public interface CompanyRepo extends CrudRepository<Company,Integer>{
    
}

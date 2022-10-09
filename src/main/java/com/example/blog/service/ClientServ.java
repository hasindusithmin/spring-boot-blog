package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.blog.model.Address;
import com.example.blog.model.Client;
import com.example.blog.model.Company;
import com.example.blog.repositary.AddressRepo;
import com.example.blog.repositary.ClientRepo;
import com.example.blog.repositary.CompanyRepo;

@Service
public class ClientServ {
    
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private CompanyRepo companyRepo;
   

    public Client create(Client client) {
        client.setCompany(companyRepo.save(client.getCompany()));
        client.setAddress(addressRepo.save(client.getAddress()));
        return clientRepo.save(client);
    }

    public Iterable<Client> read() {
        return clientRepo.findAll();
    }

    public Client read(int id) {
        try {
            return clientRepo.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}

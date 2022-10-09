package com.example.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}

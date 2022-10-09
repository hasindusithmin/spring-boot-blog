package com.example.blog.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.blog.model.Client;
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
        try {
            client.setCompany(companyRepo.save(client.getCompany()));
            client.setAddress(addressRepo.save(client.getAddress()));
            return clientRepo.save(client);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Iterable<Client> read() {
        return clientRepo.findAll();
    }

    public Client read(int id) {
        try {
            return clientRepo.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Client update(Client client,int id) {
        try {
            clientRepo.findById(id).get();
            client.setCompany(companyRepo.save(client.getCompany()));
            client.setAddress(addressRepo.save(client.getAddress()));
            return clientRepo.save(client);
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public String delete(int id) {
        try {
            clientRepo.findById(id).get();
            clientRepo.deleteById(id);
            return null;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}

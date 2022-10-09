package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.blog.model.Client;
import com.example.blog.model.Company;
import com.example.blog.repositary.ClientRepo;
import com.example.blog.service.ClientServ;

@RestController
@RequestMapping("/blog")
public class ClientCont {

    @Autowired
    private ClientServ clientServ;

    @GetMapping
    public Iterable<Client> read() {
        return clientServ.read();
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientServ.create(client);
    }

}

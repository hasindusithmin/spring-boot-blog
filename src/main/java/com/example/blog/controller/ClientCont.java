package com.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.blog.model.Client;
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

    @GetMapping("/{id}")
    public Client read(@PathVariable("id") int id) {
        return clientServ.read(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientServ.create(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable("id") int id,@RequestBody Client client) {
        return clientServ.update(client,id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return clientServ.delete(id);
    }

}

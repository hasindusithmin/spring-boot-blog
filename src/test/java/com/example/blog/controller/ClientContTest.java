package com.example.blog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.blog.model.Client;
import com.example.blog.service.ClientServ;



@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClientContTest {

   @LocalServerPort
   int randomServerPort;

   @Autowired
   private ClientServ clientServ;


   @Test
   void readAll() throws Exception{
    RestTemplate restTemplate = new RestTemplate();
    final String uri = "http://localhost:"+randomServerPort+"/blog";
    ResponseEntity<Client[]> response = restTemplate.getForEntity(uri ,Client[].class);
    Client[] clientsInBody =  response.getBody();
    List<Client> clientsInDb = new ArrayList<Client>();
    clientServ.read().forEach(clientsInDb::add);
    assertEquals(clientsInBody.length, clientsInDb.size());
    for(int i = 0; i < clientsInBody.length;i++) {
        assertEquals(clientsInBody[i].getId(), clientsInDb.get(i).getId());
        assertEquals(clientsInBody[i].getName(), clientsInDb.get(i).getName());
        assertEquals(clientsInBody[i].getUsername(), clientsInDb.get(i).getUsername());
        assertEquals(clientsInBody[i].getWebsite(), clientsInDb.get(i).getWebsite());
        assertEquals(clientsInBody[i].getPhone(), clientsInDb.get(i).getPhone());
        assertEquals(clientsInBody[i].getAddress().getCity(), clientsInDb.get(i).getAddress().getCity());
        assertEquals(clientsInBody[i].getAddress().getStreet(), clientsInDb.get(i).getAddress().getStreet());
        assertEquals(clientsInBody[i].getAddress().getSuite(), clientsInDb.get(i).getAddress().getSuite());
        assertEquals(clientsInBody[i].getAddress().getZipcode(), clientsInDb.get(i).getAddress().getZipcode());
        assertEquals(clientsInBody[i].getCompany().getName(), clientsInDb.get(i).getCompany().getName());
        assertEquals(clientsInBody[i].getCompany().getBs(), clientsInDb.get(i).getCompany().getBs());
        assertEquals(clientsInBody[i].getCompany().getCatchPhrase(), clientsInDb.get(i).getCompany().getCatchPhrase());

    }

   }
    
}

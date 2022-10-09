package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @OneToOne(mappedBy = "address")
    private Client client;
    @OneToOne
    @JoinColumn(name = "geo_id")
    private Geo geo;
    
    
}

package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String catchPhrase;
    private String bs;
    @OneToOne(mappedBy = "company")
    private Client client;
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCatchPhrase() {
        return catchPhrase;
    }
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
    public String getBs() {
        return bs;
    }
    public void setBs(String bs) {
        this.bs = bs;
    }
    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
    }
    

    
}

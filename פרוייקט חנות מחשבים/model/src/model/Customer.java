/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author usern
 */
public class Customer implements Serializable{
    private long id;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
         return name;
        //return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
    }

 
    
    
}

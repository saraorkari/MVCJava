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
public class SoftwareProduct extends Product implements Serializable{
    private  int NumberOfUsers;

    public SoftwareProduct() {
    }

    public SoftwareProduct(int NumberOfUsers, long id, String name, String description, float pricePerUnit) {
        super(id, name, description, pricePerUnit);
        this.NumberOfUsers = NumberOfUsers;
    }

    public int getNumberOfUsers() {
        return NumberOfUsers;
    }

    public void setNumberOfUsers(int NumberOfUsers) {
        this.NumberOfUsers = NumberOfUsers;
    }

    @Override
    public float getPrice() {
        return NumberOfUsers + pricePerUnit;
    }
    
}

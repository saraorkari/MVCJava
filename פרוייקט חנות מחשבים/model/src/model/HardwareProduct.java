package model;


import java.io.Serializable;
import model.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usern
 */
public class HardwareProduct extends Product implements Serializable{
    
    private int WarrantyPeriod;

    public int getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public void setWarrantyPeriod(int WarrantyPeriod) {
        this.WarrantyPeriod = WarrantyPeriod;
    }

    public HardwareProduct(int WarrantyPeriod, long id, String name, String description, float pricePerUnit) {
        super(id, name, description, pricePerUnit);
        this.WarrantyPeriod = WarrantyPeriod;
    }
    
    @Override
    public float getPrice() {
        return WarrantyPeriod + pricePerUnit;
    }
    
}

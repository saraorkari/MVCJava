/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author usern
 */
public class PurchaseOrder implements Serializable{
    private Customer orderingCustomer;
    private ArrayList <Product>productsList;
    private LocalDate orderDate;

    public PurchaseOrder() {
        this.orderDate = LocalDate.now();
    }

    public PurchaseOrder(Customer orderingCustomer, ArrayList<Product> productsList) {
        this.orderingCustomer = orderingCustomer;
        this.productsList = productsList;
        this.orderDate = LocalDate.now();
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getOrderingCustomer() {
        return orderingCustomer;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderingCustomer(Customer orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "orderingCustomer=" + orderingCustomer + ", productsList=" + productsList + ", orderDate=" + orderDate + '}';
    }
    
    
}

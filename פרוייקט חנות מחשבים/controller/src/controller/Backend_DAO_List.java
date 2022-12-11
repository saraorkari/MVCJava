/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Product;
import model.PurchaseOrder;

/**
 *
 * @author usern
 */
public class Backend_DAO_List implements Backend {

    private Map<Long, Customer> _Customers;
    private Set<Product> _Products;
    private List<PurchaseOrder> _PurchaseOrders;
    private static Backend_DAO_List bdl_singleton;

    public static Backend_DAO_List get_bdl_singleton() {
        if (bdl_singleton == null) {
            bdl_singleton = new Backend_DAO_List();
        }
        return bdl_singleton;
    }

    private Backend_DAO_List() {
        this._Customers = new HashMap<Long, Customer>();
        this._Products = new HashSet<Product>();
        this._PurchaseOrders = new ArrayList<PurchaseOrder>();
    }

    @Override
    public void AddCustomer(Customer c) throws Exception {
        _Customers.put(c.getId(), c);
    }

    @Override
    public void AddProduct(Product c) throws Exception {
        _Products.add(c);
    }

    @Override
    public Map<Long, Customer> getAllCustomers() throws Exception {
        return _Customers;
    }

    @Override
    public Set<Product> getAllProducts() throws Exception {
        return _Products;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {
        _PurchaseOrders.add(po);
    }

    @Override
    public void RemoveProduct(Product c) throws Exception {
        _Products.remove(c);
    }

    @Override
    public ArrayList<Product> getCustomersOrders(Customer c) throws Exception {
        ArrayList<Product> lst = new ArrayList<>();
        for (PurchaseOrder _PurchaseOrder : _PurchaseOrders) {
            if (c.getId() == _PurchaseOrder.getOrderingCustomer().getId()) {
                for (Product product : _PurchaseOrder.getProductsList()) {
                    lst.add(product);
                }
            }
        }
        return lst;
    }
    @Override
    public Float CalcProductsTotalCost(Product[] products) throws Exception {
        float sum = 0;
        for (Product product : products) {
            sum += product.getPricePerUnit();
        }
        return sum;
    }

    public void savaDataToFile() {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data"));
            oos.writeObject(_Customers);
            oos.writeObject(_Products);
            oos.writeObject(_PurchaseOrders);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDataFromFile() {
        try {
            ObjectInputStream ois;
            ois = new ObjectInputStream(new FileInputStream("data"));
            _Customers = (Map<Long, Customer>) ois.readObject();
            _Products = (Set<Product>) ois.readObject();
            _PurchaseOrders = (List<PurchaseOrder>) ois.readObject();
            ois.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Backend_DAO_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

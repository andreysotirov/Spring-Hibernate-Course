package com.andrewsotirov.webapp.dao;

import com.andrewsotirov.webapp.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String searchName);
}

package com.andrewsotirov.webapp.service;

import com.andrewsotirov.webapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void addCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String searchName);
}

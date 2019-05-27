package com.andrewsotirov.webapp.dao;

import com.andrewsotirov.webapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        session.delete(customer);
    }

    @Override
    public List<Customer> searchCustomer(String searchName) {
        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        if ((searchName != null) && (searchName.trim().length() > 0)) {
            query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
        } else {
            query = session.createQuery("from Customer", Customer.class);
        }
        List<Customer> customers = query.getResultList();

        return customers;
    }
}


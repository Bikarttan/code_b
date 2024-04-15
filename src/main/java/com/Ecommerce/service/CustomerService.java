package com.Ecommerce.service;

import com.Ecommerce.entity.Customer;

import java.util.List;

public interface CustomerService {
        Customer createCustomer(Customer customer);
        void DeleteCustomer(Long cId );

        List<Customer> getAll();
}

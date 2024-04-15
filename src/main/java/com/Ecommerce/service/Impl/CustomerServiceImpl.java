package com.Ecommerce.service.Impl;

import com.Ecommerce.entity.Customer;
import com.Ecommerce.repository.CustomerRepo;
import com.Ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService  {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void DeleteCustomer(Long cId ) {
        customerRepo.deleteById(cId);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> all = customerRepo.findAll();
        HashSet<String>hs=new HashSet<>();
        List<Customer> collect = all.stream().filter(a -> hs.add(a.getCname())).collect(Collectors.toList());
        return collect;
    }


}

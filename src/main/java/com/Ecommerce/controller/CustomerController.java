package com.Ecommerce.controller;

import com.Ecommerce.entity.Customer;
import com.Ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<Customer>save(@RequestBody Customer customer){
        Customer serviceCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(serviceCustomer, HttpStatus.CREATED);
    }
@DeleteMapping("/delete/{cId}")
    public void delete(@PathVariable Long cId){

        customerService.DeleteCustomer(cId);
    }
    @GetMapping("/allCustomer")
    public List<Customer> findallCustomer(){
        return customerService.getAll();
    }
}

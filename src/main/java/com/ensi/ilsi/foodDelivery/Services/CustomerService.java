package com.ensi.ilsi.foodDelivery.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensi.ilsi.foodDelivery.Entity.Customer;
import com.ensi.ilsi.foodDelivery.Repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer Customer) {
        return customerRepository.save(Customer);
    }
    
    public Customer delete(int id) {
    	
        Customer customer = customerRepository.findById(id).orElseThrow(() 
        		-> new EntityNotFoundException("Customer Not Found !"));
        customerRepository.deleteById(id);
        return customer;
    }
    
    public List<Customer> findAll() {
    	List<Customer> customers = new ArrayList<>();
    	customerRepository.findAll().forEach(customers::add);    	
        return customers;
    }
    
    public void deleteAll() {
         customerRepository.deleteAll();
         return;
         }
   
    
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
        
    }

    
}
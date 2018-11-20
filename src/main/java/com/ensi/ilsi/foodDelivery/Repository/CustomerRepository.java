package com.ensi.ilsi.foodDelivery.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ensi.ilsi.foodDelivery.Entity.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}

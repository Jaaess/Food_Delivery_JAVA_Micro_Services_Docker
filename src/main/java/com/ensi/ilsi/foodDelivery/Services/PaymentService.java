package com.ensi.ilsi.foodDelivery.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensi.ilsi.foodDelivery.Entity.Payment;
import com.ensi.ilsi.foodDelivery.Repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment create(Payment Payment) {
        return paymentRepository.save(Payment);
    }
    
    public Payment delete(int id) {
    	
        Payment Payment = paymentRepository.findById(id).orElseThrow(() 
        		-> new EntityNotFoundException("Payment Not Found !"));
        paymentRepository.deleteById(id);
        return Payment;
    }
    
    public List<Payment> findAll() {
    	List<Payment> Payments = new ArrayList<>();
    	paymentRepository.findAll().forEach(Payments::add);    	
        return Payments;
    }
    
    public void deleteAll() {
         paymentRepository.deleteAll();
         return;
         }
   
    
    public Optional<Payment> findById(int id) {
        return paymentRepository.findById(id);
        
    }

    
}
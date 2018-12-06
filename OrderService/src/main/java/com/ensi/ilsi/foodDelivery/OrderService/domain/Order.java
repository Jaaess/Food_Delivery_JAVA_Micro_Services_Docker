package com.ensi.ilsi.foodDelivery.OrderService.domain;

import java.util.Date;

import com.ensi.ilsi.foodDelivery.commons.enumeration.OrderStatus;
import com.ensi.ilsi.foodDelivery.commons.domain.AbstractEntity;
import com.ensi.ilsi.foodDelivery.commons.dto.OrderItemDto;
import com.ensi.ilsi.foodDelivery.commons.dto.PaymentDto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

@Entity
@Table(name = "orders")

public class Order extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    

	@Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
    private Date toDeliver = new Date();
   
    	@Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime shipped;

    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderItem> orderItems;

    @NotNull
    @Column(name = "customerAdress", nullable = false)
    private String customerAdress ;
    
    public Order() {
        // JPA
    }

    public Order(BigDecimal totalPrice, OrderStatus status, Payment payment, Set<OrderItem> orderItems, String customerAdress) {
        
        this.totalPrice = totalPrice;
        this.status = status;
        this.payment = payment;
        this.orderItems = orderItems;
        this.customerAdress = customerAdress;
    }


    
}

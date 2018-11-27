package com.ensi.ilsi.foodDelivery.Entity;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.ensi.ilsi.foodDelivery.domain.enumeration.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Order.
 */

@SuppressWarnings("serial")
@Entity
public class Order extends AbstractEntity {
	
	private HashMap<Food,Integer> orderContent;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdOn = new Date();
	private Date toDeliver = new Date();
	 @NotNull
	 @Enumerated(EnumType.STRING)
	 @Column(name = "status", nullable = false)
	 private OrderStatus status;

	public Order() {
		// JPA
			}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Order [orderContent=" + orderContent + ", customer=" + customer + ", createdOn="
				+ createdOn + ", toDeliver=" + toDeliver + "]";
	}
	
	
	
	public HashMap<Food, Integer> getOrderContent() {
		return orderContent;
	}
	
	
	public void setOrderContent(HashMap<Food, Integer> orderContent) {
		this.orderContent = orderContent;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	public Date getToDeliver() {
		return toDeliver;
	}
	
	
	public void setToDeliver(Date toDeliver) {
		this.toDeliver = toDeliver;
	}
	
}

package com.ensi.ilsi.foodDelivery.OrderService.domain;

import com.ensi.ilsi.foodDelivery.commons.domain.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {




    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    private Long foodId;

    @ManyToOne
    private Order order;

    private Long orderId;

    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public OrderItem() {
        // Empty Constructor for JPA
    }

    public OrderItem(Long quantity, Long foodId, Long orderId) {
        this.quantity = quantity;
        this.foodId = foodId;
        this.orderId = orderId;
    }

   

}

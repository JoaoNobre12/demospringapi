package com.casa.demospring.demo.entities.pk;

import com.casa.demospring.demo.entities.Order;
import com.casa.demospring.demo.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class OrderItemPK implements Serializable {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

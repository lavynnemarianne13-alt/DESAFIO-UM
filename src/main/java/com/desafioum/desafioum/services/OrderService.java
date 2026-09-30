package com.desafioum.desafioum.services;

import com.desafioum.desafioum.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double discountValue = (order.getBasic()* order.getDiscount())/100.0;
        return order.getBasic() - discountValue + shippingService.shipment(order) ;
    }
}

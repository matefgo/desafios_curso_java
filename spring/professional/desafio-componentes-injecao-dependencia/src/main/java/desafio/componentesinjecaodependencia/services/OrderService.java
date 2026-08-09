package desafio.componentesinjecaodependencia.services;

import desafio.componentesinjecaodependencia.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double withDiscount = order.getBasic() * (1 - order.getDiscount() / 100);
        return withDiscount + shippingService.shipment(order);
    }

}

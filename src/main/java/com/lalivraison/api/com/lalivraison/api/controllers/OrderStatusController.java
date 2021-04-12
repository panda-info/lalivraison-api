package com.lalivraison.api.com.lalivraison.api.controllers;

import static com.lalivraison.api.com.lalivraison.api.controllers.RestaurantController.imageToBase64;
import static com.lalivraison.api.models.order.Status.LIVREE;
import static java.util.Arrays.asList;

import com.lalivraison.api.models.order.Item;
import com.lalivraison.api.models.order.OrderStatus;
import com.lalivraison.api.models.order.Service;
import com.lalivraison.api.models.order.ServiceType;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suivi-commande")
public class OrderStatusController {

  @GetMapping("/{orderId}")
  public OrderStatus getOrderStatus(@PathVariable String orderId) throws IOException {
    return new OrderStatus(
        asList(LocalDateTime.now().withHour(15).withMinute(0),
            LocalDateTime.now().withHour(15).withMinute(10),
            LocalDateTime.now().withHour(15).withMinute(20),
            LocalDateTime.now().withHour(15).withMinute(30)),
        LIVREE.getDescription(), LIVREE.getState(),
        "Al mohades, résidence Malik appt 9 quartier palmiers, Casablanca",
        asList(
            new Item(imageToBase64("p3.png"), "GAMBAS TEMPURA", 65, 1),
            new Item(imageToBase64("SALMON-AVOCADO-TARTARE.png"), "SALMON AVOCADO TARTARE",
                55, 2)
        ),
        new Service(ServiceType.DELIVERY, 20f));
  }

}

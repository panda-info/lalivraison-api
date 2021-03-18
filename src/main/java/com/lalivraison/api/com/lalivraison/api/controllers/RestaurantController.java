package com.lalivraison.api.com.lalivraison.api.controllers;

import static java.util.Arrays.asList;

import com.lalivraison.api.models.restaurant.Category;
import com.lalivraison.api.models.restaurant.Item;
import com.lalivraison.api.models.restaurant.RestaurantDetails;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

  @GetMapping
  RestaurantDetails getRestaurantDetails(@RequestParam String restaurantId,
      @RequestParam String districtId) {
    new RestaurantDetails("1", "image", "subimage", "NIKKEI.MA",
        "Cuisine Nippone", 140, 20, "05 22 99 48 77",
        "11", "22", "NIKKEI met un point d\\'honneur à développer une "
        + "large gamme de sushis, de plateaux...", asList(
        new Category("1", "Entrées",
            asList(
                new Item("1", "../../../assets/images/p1.png", "SALADE DE CHOUX",
                    25, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI"),
                new Item("2", "../../../assets/images/p2.png", "WAKAME SAUMON",
                    60, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI"),
                new Item("3", "../../../assets/images/p3.png", "GAMBAS TEMPURA",
                    65, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI"),
                new Item("4", "../../../assets/images/p3.png", "GAMBAS TEMPURA",
                    65, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI")

        )),
        new Category("2", "Tartare", asList(
            new Item("1", "../../../assets/images/SALMON-AVOCADO-TARTARE.png", "SALMON AVOCADO TARTARE",
                55, "Saumon, avocat, sésame, boulette de riz vinaigré, sauce Nikkei servie"
                + " à part", "NIKKEI.MA"),
            new Item("1", "../../../assets/images/TUNA-SALMON-TARTARE-(NEW).jpg", "TUNA SALMON TARTARE (NEW)",
                65, "Poisson blanc, mangue, avocat, menthe ciselée, boulette de riz vinaigré,"
                + " sauce Ponzu servie à part", "NIKKEI.MA")
        ))
    ));
    return null;
  }
}

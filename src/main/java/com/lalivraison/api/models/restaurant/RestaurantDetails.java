package com.lalivraison.api.models.restaurant;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantDetails {
  private String id;
  private String image;
  private String subImage;
  private String name;
  private String category;
  private int orderFreeMinPrice;
  private int deliveryFee;
  private String phoneNumber;
  private String openTime;
  private String closeTime;
  private String description;
  private List<Category> headings;

}

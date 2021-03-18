package com.lalivraison.api.models.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {
  private String id;
  private String image;
  private String name;
  private int price;
  private String description;
  private String restaurant;
}

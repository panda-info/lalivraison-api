package com.lalivraison.api.models.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {

  private String image;
  private String name;
  private float unitPrice;
  private int count;
}

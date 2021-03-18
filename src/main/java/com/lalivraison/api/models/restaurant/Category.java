package com.lalivraison.api.models.restaurant;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Category {
  private String id;
  private String name;
  private List<Item> items;
}

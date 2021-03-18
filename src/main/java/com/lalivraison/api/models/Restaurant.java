package com.lalivraison.api.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Restaurant {
  private String id;
  private String name;
  private String image;
  private boolean takeAway;
  private boolean delivery;
  private String city;
  private List<String> categories;

}

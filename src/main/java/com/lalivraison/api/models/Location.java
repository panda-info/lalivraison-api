package com.lalivraison.api.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
  private String id;
  private String name;
  private List<District> districts;
}

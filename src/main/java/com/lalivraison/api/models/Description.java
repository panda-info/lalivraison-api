package com.lalivraison.api.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Description {
  private String name;
  private List<String> categories;
}

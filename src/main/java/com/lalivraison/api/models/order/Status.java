package com.lalivraison.api.models.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
  VALIDEE("validée", 1), PREPAREE("préparée", 2),
  EXPEDIEE("expédiée", 3), LIVREE("livrée", 4),
  RECUPEREE("récupérée", 4);

  private String description;
  private int state;
}

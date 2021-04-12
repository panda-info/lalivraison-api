package com.lalivraison.api.models.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Service {
  private ServiceType type;
  private float fees;
}

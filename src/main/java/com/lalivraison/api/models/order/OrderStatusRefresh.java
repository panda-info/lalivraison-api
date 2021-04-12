package com.lalivraison.api.models.order;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderStatusRefresh {

  private List<LocalDateTime> times;
  private String status;
  private int state;

}

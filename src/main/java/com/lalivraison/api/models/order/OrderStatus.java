package com.lalivraison.api.models.order;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class OrderStatus {

  private List<LocalDateTime> times;
  private String status;
  private int state;
  private String address;
  private List<Item> items;
  private float total;
  private Service service;

  public OrderStatus(List<LocalDateTime> times, String status, int state, String address,
      List<Item> items, Service service) {
    this.times = times;
    this.status = status;
    this.state = state;
    this.address = address;
    this.items = items;
    this.service = service;
    this.total = (float) items.stream().mapToDouble(item -> item.getUnitPrice() * item.getCount()).sum();
  }
}

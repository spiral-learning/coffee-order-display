package com.welltestedlearning.coffeeorderdisplay;

import java.util.List;

public class Order {
  private Long id; // our ID for the Repository
  private Long kioskId; // order ID from external meal kiosk
  private List<String> orderItems;
  private String status = "NEW";
  private String kioskName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getKioskId() {
    return kioskId;
  }

  public void setKioskId(Long orderNumber) {
    this.kioskId = orderNumber;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<String> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<String> orderItems) {
    this.orderItems = orderItems;
  }

  public void moveToNextState() {
    switch (status) {
      case "NEW":
        status = "WAITING";
        break;
      case "WAITING":
        status = "BREWING";
        break;
      case "BREWING":
        status = "COMPLETED";
        break;
      case "COMPLETED":
        status = "ABANDONED";
        break;
      case "ABANDONED":
      default:
        status = "NEW";
    }
  }

  public void setKioskName(String kioskName) {
    this.kioskName = kioskName;
  }

  public String getKioskName() {
    return kioskName;
  }

  public boolean isNotDone() {
    return status.equals("NEW") || status.equals("WAITING") || status.equals("BREWING");
  }
}

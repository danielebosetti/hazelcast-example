package domain;

import java.io.Serializable;

public class Car implements Serializable {
  private static final long serialVersionUID = 2L;
  
  private long id;
  private double price;
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  @Override
  public String toString() {
    return "Car[" + id +","+price+"]";
  }
  
}

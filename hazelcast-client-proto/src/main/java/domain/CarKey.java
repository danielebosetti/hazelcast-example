package domain;

import java.io.Serializable;

public class CarKey implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private long id;
  private String part2;

  public CarKey() {}

  public CarKey(long id, String part2) {
    this.id = id;
    this.part2 = part2;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPart2() {
    return part2;
  }

  public void setPart2(String part2) {
    this.part2 = part2;
  }
}

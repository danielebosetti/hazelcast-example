package client;

public class ExecClientRead {
  
  /**
   * deserializes a different version of car class
   */
  public static void main(String[] args) throws Exception {
    
    try {
      RunClientRead o = new RunClientRead();
      o.go();
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }

}

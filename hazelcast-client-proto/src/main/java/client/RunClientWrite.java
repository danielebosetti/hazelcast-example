package client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import domain.Car;
import factory.ClientFactory;

public class RunClientWrite {

  public static void main(String[] args) throws Exception {
    RunClientWrite o = new RunClientWrite();
    o.go();
  }

  private void go() throws Exception {
    
    ClientFactory cf = new ClientFactory();
    HazelcastInstance hzClient = cf.getClient();

    IMap<Object, Object> map = hzClient.getMap("cars");
    Car car = new Car();
    car.setId(1565);
    map.put(1L, car);
    
    Object item = map.get(1L);
    System.out.println("item="+item);
    hzClient.shutdown();
  }

}

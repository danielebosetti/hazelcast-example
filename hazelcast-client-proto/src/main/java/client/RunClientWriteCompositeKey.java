package client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import domain.Car;
import domain.CarKey;
import factory.ClientFactory;

public class RunClientWriteCompositeKey {

  public static void main(String[] args) throws Exception {
    RunClientWriteCompositeKey o = new RunClientWriteCompositeKey();
    o.go();
  }

  private void go() throws Exception {
    
    ClientFactory cf = new ClientFactory();
    HazelcastInstance hzClient = cf.getClient();

    IMap<Object, Object> map = hzClient.getMap("cars");
    Car car = new Car();
    car.setId(12313);
    
    Object key = new CarKey(123L, "x-y-z");
    map.put(key , car);
    
    Object item = map.get( key );
    System.out.println("item="+item);
    hzClient.shutdown();
  }
}

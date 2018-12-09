package client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import factory.ClientFactory;

public class RunClientRead {

  public static void main(String[] args) throws Exception {
    RunClientRead o = new RunClientRead();
    o.go();
  }

  public void go() throws Exception {
    
    ClientFactory cf = new ClientFactory();
    HazelcastInstance hzClient = cf.getClient();

    try {
      IMap<Object, Object> map = hzClient.getMap("cars");
      Object item = map.get(1L);
      System.out.println("item=" + item);
    } finally {
      hzClient.shutdown();
    }
  }
}

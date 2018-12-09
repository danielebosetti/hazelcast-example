package client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import factory.ClientFactory;

public class RunClientWriteBrokenBytes {

  public static void main(String[] args) throws Exception {
    RunClientWriteBrokenBytes o = new RunClientWriteBrokenBytes();
    o.go();
  }

  private void go() throws Exception {
    
    ClientFactory cf = new ClientFactory();
    HazelcastInstance hzClient = cf.getClient();

    IMap<Object, Object> map = hzClient.getMap("cars");

    byte[] bytes = new byte[100];
    map.put("user-1", bytes  );
    
    hzClient.shutdown();
  }
}

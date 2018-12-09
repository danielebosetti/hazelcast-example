package client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import factory.ClientFactory;
import proto.Example.User;

public class RunClientWriteProto {

  public static void main(String[] args) throws Exception {
    RunClientWriteProto o = new RunClientWriteProto();
    o.go();
  }

  private void go() throws Exception {
    
    ClientFactory cf = new ClientFactory();
    HazelcastInstance hzClient = cf.getClient();

    IMap<Object, Object> map = hzClient.getMap("cars");

    Object user = User.newBuilder().setId(123).setName("bob").build();
    map.put("user-1", user );
    
    Object item = map.get( "user-1" );
    System.out.println("item="+item);
    hzClient.shutdown();
  }
}

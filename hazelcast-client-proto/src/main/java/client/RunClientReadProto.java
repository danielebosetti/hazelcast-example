package client;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import factory.ClientFactory;
import proto.Example.User;

public class RunClientReadProto {

  public static void main(String[] args) throws Exception {
    RunClientReadProto o = new RunClientReadProto();
    o.go();
  }

  private void go() throws Exception {
    
    ClientFactory cf = new ClientFactory();
    HazelcastInstance hzClient = cf.getClient();

    IMap<String, User> map = hzClient.getMap("cars");

    User item = map.get( "user-1" );
    System.out.println("item="+item);
    hzClient.shutdown();
  }
}

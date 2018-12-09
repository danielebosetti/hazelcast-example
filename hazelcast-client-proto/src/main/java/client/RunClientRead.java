package client;

import java.util.Arrays;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class RunClientRead {

  public static void main(String[] args) throws Exception {
    RunClientRead o = new RunClientRead();
    o.go();
  }

  public void go() throws Exception {
    GroupConfig groupConfig = new GroupConfig("dev-1", "");
    ClientConfig config = new ClientConfig();
    config.setProperty("hazelcast.logging.type", "slf4j");    
    config.setGroupConfig(groupConfig);
    ClientNetworkConfig networkConfig = new ClientNetworkConfig();
    networkConfig.setAddresses(Arrays.asList("localhost:5701"));
    config.setNetworkConfig(networkConfig );
    HazelcastInstance hzClient = HazelcastClient.newHazelcastClient(config);


    IMap<Object, Object> map = hzClient.getMap("cars");

    Object item = map.get(1L);
    System.out.println("item="+item);
    hzClient.shutdown();
  }
}

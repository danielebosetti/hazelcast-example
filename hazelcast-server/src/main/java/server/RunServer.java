package server;

import java.util.concurrent.CountDownLatch;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class RunServer {

  public static void main(String[] args) throws Exception {
    Config config = new Config("instance-1");
    config.setProperty("hazelcast.logging.type", "slf4j");
    
    GroupConfig gc = new GroupConfig("dev-1", "");
    
    config.setGroupConfig(gc);
    CountDownLatch stopping = new CountDownLatch(1);
    HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance(config);
    stopping.await();
    hzInstance.shutdown();
  }
  
}

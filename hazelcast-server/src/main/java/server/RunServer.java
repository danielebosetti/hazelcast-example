package server;

import java.util.concurrent.CountDownLatch;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class RunServer {

  public static void main(String[] args) throws Exception {
    Config config = new Config("local");
    config.setProperty("hazelcast.logging.type", "slf4j");
    
    CountDownLatch stopping = new CountDownLatch(1);
    HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance(config);
    stopping.await();
    hzInstance.shutdown();
  }
  
}

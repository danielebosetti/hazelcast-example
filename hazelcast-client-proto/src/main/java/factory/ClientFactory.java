package factory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;

import domain.Car;
import proto.Example.User;
import serialization.CustomCarSerializer;
import serialization.UserSerializer;

public class ClientFactory {

  /**
   * returns a (started) hz client
   */
  public HazelcastInstance getClient() {
    
    ClientConfig config = getConfigNoSerialization();
    addSerializationConfigTo(config);

    HazelcastInstance hzClient = HazelcastClient.newHazelcastClient(config);
    return hzClient;
  }

  /**
   * edits the given config, adds serializers
   */
  private void addSerializationConfigTo(ClientConfig config) {
    SerializerConfig ser_car = new SerializerConfig().
        setImplementation(new CustomCarSerializer()).
        setTypeClass(Car.class);
    
    SerializerConfig ser_user = new SerializerConfig().
        setImplementation(new UserSerializer()).
        setTypeClass(User.class);
    
    
    List<SerializerConfig> ser_list = new LinkedList<>();
    ser_list.add(ser_car);
    ser_list.add(ser_user);
    
    SerializationConfig ser_config = new SerializationConfig();
    ser_config.setSerializerConfigs(ser_list);
    
    config.setSerializationConfig(ser_config);
  }

  /**
   * @return a client without serialization configs
   */
  public HazelcastInstance getBrokenClient() {
    ClientConfig config = getConfigNoSerialization();
    HazelcastInstance hzClient = HazelcastClient.newHazelcastClient(config);
    return hzClient;
  }

  private ClientConfig getConfigNoSerialization() {
    GroupConfig groupConfig = new GroupConfig("dev-1", "");
    ClientConfig config = new ClientConfig();
    config.setProperty("hazelcast.logging.type", "slf4j");    
    config.setGroupConfig(groupConfig);
    ClientNetworkConfig networkConfig = new ClientNetworkConfig();
    networkConfig.setAddresses(Arrays.asList("localhost:5701"));
    config.setNetworkConfig(networkConfig );
    return config;
  }
  
}

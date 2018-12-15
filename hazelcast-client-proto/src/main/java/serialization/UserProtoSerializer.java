package serialization;

import java.io.IOException;

import com.hazelcast.nio.serialization.ByteArraySerializer;

import proto.Example.User;

public class UserProtoSerializer implements ByteArraySerializer<User> {

  public static final int HAZELCAST_TYPEID_USER = 99;

  @Override
  public int getTypeId() {
    return HAZELCAST_TYPEID_USER;
  }

  @Override
  public void destroy() {
  }

  @Override
  public User read(byte[] buffer) throws IOException {
    return User.parseFrom(buffer);
  }

  @Override
  public byte[] write(User item) throws IOException {
    return item.toByteArray();
  }
  
}

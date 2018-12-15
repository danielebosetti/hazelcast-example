package protobuf;

import java.util.UUID;

import org.junit.Test;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;

import proto.Example.SearchRequest;
import proto.Example.Tick;
import proto.Example.User;

public class TestProtobuf {

  @Test
  public void testMessage() {
    SearchRequest sr = SearchRequest.newBuilder().setPageNumber(213).build();
    System.out.println("sr=" + sr);

    User user = User.newBuilder().setId(1000).setName("max")
        .setUpdatedTime(System.currentTimeMillis()).build();
    System.out.println("user=" + user);
  }

  @Test
  public void testAny() {

    User user = User.newBuilder().setId(12093).setName("max").build();
    Any any = Any.pack(user);
    System.out.println(any);
    System.out.println("any size=" + any.getSerializedSize());

    if (any.is(User.class)) {
      User user2;
      try {
        user2 = any.unpack(User.class);
        System.out.println(user2);
      } catch (InvalidProtocolBufferException e) {
        e.printStackTrace(System.out);
      }
    }
  }

  @Test
  public void testWriteBytes() throws Exception {
    User user = User.newBuilder().setName("mike").setId(1231L).build();
    byte[] bytes = user.toByteArray();
    System.out.println("user="+user);
    System.out.println("bytes length="+bytes.length);
    User parsed = User.parseFrom(bytes);
    System.out.println("parsed="+parsed);
    System.out.println("equals="+(user==parsed));
  }
  
  @Test
  public void testTick() {
    Tick tick = Tick.newBuilder()
        .setUuid(UUID.randomUUID().toString())
        .setTime(System.currentTimeMillis()).build();
    System.out.println(tick);
    System.out.println("serialized size="+tick.getSerializedSize());
    System.out.println("bytes length="+tick.toByteArray().length);
  }
}

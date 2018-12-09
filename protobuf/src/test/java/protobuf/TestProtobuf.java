package protobuf;

import org.junit.Test;

import proto.Example.SearchRequest;
import proto.Example.User;

public class TestProtobuf {

  @Test
  public void testMessage() {
    SearchRequest sr = SearchRequest.newBuilder().setPageNumber(213).build();
    System.out.println("sr="+sr);
    
    User user = User.newBuilder().setId(1000).setName("max")
        .setUpdatedTime(System.currentTimeMillis()).build();
    System.out.println("user="+user);
  }
}

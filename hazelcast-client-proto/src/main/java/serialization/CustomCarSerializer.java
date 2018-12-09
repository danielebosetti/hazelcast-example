package serialization;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import domain.Car;

public class CustomCarSerializer implements StreamSerializer<Car> {

  @Override
  public int getTypeId() {
      return 10;
  }

  @Override
  public void write(ObjectDataOutput out, Car object) throws IOException {
    
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      XMLEncoder encoder = new XMLEncoder(bos);
      encoder.writeObject(object);
      encoder.close();
      
      System.out.println("encoding..");
      ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
      XMLEncoder encoderCout = new XMLEncoder(bos2);
      encoderCout.writeObject(object);
      encoderCout.close();
      
      System.out.write(bos2.toByteArray());
      
      out.write(bos.toByteArray());
  }

  @Override
  public Car read(ObjectDataInput in) throws IOException {
      final InputStream inputStream = (InputStream) in;
      XMLDecoder decoder = new XMLDecoder(inputStream);
      Car res = (Car) decoder.readObject();
      decoder.close();
      return res;
  }

  @Override
  public void destroy() {
  }
}
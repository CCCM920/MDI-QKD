package com.hydra.device.tdc.adapters;

import com.hydra.device.tdc.TDCDataAdapter;
import com.hydra.device.tdc.serialize.Deserializer;

/**
 *
 * @author Hwaipy
 */
public class DeserializingTDCDataAdapter implements TDCDataAdapter {

  private final Deserializer deserializer;

  public DeserializingTDCDataAdapter() {
    deserializer = new Deserializer();
  }

  @Override
  public long[] offer(Object data) {
    return translate(data);
  }

  @Override
  public long[] flush(Object data) {
    return translate(data);
  }

  private long[] translate(Object data) {
    if (data == null) {
      return null;
    }
    if (!(data instanceof byte[])) {
      throw new IllegalArgumentException("The input data of DeserializingTDCDataAdapter should be byte array.");
    }
    return deserializer.deserialize((byte[]) data);
  }
}

package com.samples.multithreading.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class People {

  /**
   * Name
   */
  private String name;

  @Override
  public String toString() {
    return String.format("{ name: %s }",  name);
  }
}

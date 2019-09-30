package com.samples.multithreading.common;

public interface Gate {

  void add(Object o) throws InterruptedException;

  Object get() throws InterruptedException;
}

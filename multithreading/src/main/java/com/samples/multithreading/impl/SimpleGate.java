package com.samples.multithreading.impl;

import com.samples.multithreading.common.Gate;
import com.samples.multithreading.pojo.People;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleGate implements Gate {

  private static final Random RANDOM = new Random();

  private List<People> queue = new ArrayList<>();

  @Override
  public synchronized void add(Object visitor) throws InterruptedException {
    if(queue.size() < 10) {
      queue.add((People) visitor);
      notify();
    } else {
      wait();
    }
  }

  @Override
  public synchronized People get() throws InterruptedException {
    if(queue.isEmpty()) {
      wait();
    }
    int toRelease = RANDOM.nextInt(queue.size());
    People exiter = queue.remove(toRelease);
    notify();
    return exiter;
  }
}

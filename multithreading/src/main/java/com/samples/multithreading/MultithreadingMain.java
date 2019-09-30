package com.samples.multithreading;

import com.samples.multithreading.impl.SimpleAibolit;
import com.samples.multithreading.impl.SimpleGate;
import com.samples.multithreading.impl.SimplePeopleFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingMain {

  private static int AIBOLIT_COUNTER = 1;
  private static String AIBOLIT = "Врач_";

  public static void main(String[] args) {
    SimpleGate gate = new SimpleGate();

    Runnable factoryTask = () -> {
      SimplePeopleFactory factory = new SimplePeopleFactory(gate);
      while (true) {
        factory.create();
      }
    };

    Runnable aibolitTask = () -> {
      SimpleAibolit aibolit = new SimpleAibolit(AIBOLIT + (AIBOLIT_COUNTER++), gate);
      while (true) {
        aibolit.enter();
      }
    };

    int coresCount = Runtime.getRuntime().availableProcessors();
    ExecutorService service = Executors.newFixedThreadPool(coresCount);
    service.submit(factoryTask);
    service.submit(factoryTask);
    service.submit(aibolitTask);
    service.submit(aibolitTask);

  }
}

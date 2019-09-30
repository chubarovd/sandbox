package com.samples.multithreading.impl;

import com.samples.multithreading.common.Aibolit;
import com.samples.multithreading.common.Gate;
import com.samples.multithreading.pojo.People;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SimpleAibolit implements Aibolit {

  private static final String LOG_ENTER = "Patient {} entered to {}.";
  private static final String LOG_OUT = "Patient {} outed from {}.";

  private String name;
  private Gate gate;

  @Override
  public void enter() {
    try {
      People patient = (People) gate.get();
      log.debug(LOG_ENTER, patient, this);
      Thread.sleep(1000);
      log.debug(LOG_OUT, patient, this);
    } catch (InterruptedException ignored) { }
  }

  @Override
  public String toString() {
    return String.format("{ name: %s }", name);
  }
}

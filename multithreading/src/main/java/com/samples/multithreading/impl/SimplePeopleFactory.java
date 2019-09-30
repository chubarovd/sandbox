package com.samples.multithreading.impl;

import com.samples.multithreading.common.Gate;
import com.samples.multithreading.common.PeopleFactory;
import com.samples.multithreading.pojo.People;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SimplePeopleFactory implements PeopleFactory {

  private static final String LOG_CREATE = "New people {} come.";
  private static final String PEOPLE = "Челобек_";
  private static int PEOPLE_COUNTER = 0;

  private Gate gate;

  @Override
  public People create() {
    try {
      People visitor = new People(PEOPLE + (PEOPLE_COUNTER++));
      log.debug(LOG_CREATE, visitor);
      gate.add(visitor);
      return visitor;
    } catch (InterruptedException ignored) { }
    return null;
  }
}

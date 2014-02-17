package com.javacreed.examples.collections.list;

import java.util.List;

public class TimeListGetAction implements TimeListAction {

  private final String pattern = "Element %d";

  @Override
  public String getName() {
    return "get()";
  }

  @Override
  public long timeAction(final List<String> list, final int limit) {
    for (int i = 0; i < limit; i++) {
      list.add(String.format(pattern, i));
    }

    final long start = System.nanoTime();
    for (int i = 0, size = list.size(); i < limit; i++) {
      list.get(i % size);
    }
    return System.nanoTime() - start;
  }

}
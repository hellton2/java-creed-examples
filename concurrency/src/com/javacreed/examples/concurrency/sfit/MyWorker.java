package com.javacreed.examples.concurrency.sfit;

import java.util.concurrent.TimeUnit;

public class MyWorker implements Runnable {

  private final int sleepTime;

  public MyWorker(final int sleepTime) {
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
    final long startTime = System.nanoTime();
    try {
      Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTime));
      Util.printLog("Finished");
    } catch (final InterruptedException e) {
      final long interruptedAfter = System.nanoTime() - startTime;
      Util.printLog("Interrupted after %,d nano seconds", interruptedAfter);
    }
  }

}
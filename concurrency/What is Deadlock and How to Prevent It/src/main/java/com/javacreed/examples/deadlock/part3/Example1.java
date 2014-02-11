package com.javacreed.examples.deadlock.part3;

public class Example1 {

  public static void main(final String[] args) throws Exception {
    final Person personX = new Person("John", "Smith");
    final Person personY = new Person("John", "Smith");

    final Thread threadA = new Thread(new Runnable() {
      @Override
      public void run() {
        personX.copyFrom(personY);
      }
    }, "Thread-A");
    threadA.start();

    final Thread threadB = new Thread(new Runnable() {
      @Override
      public void run() {
        personY.copyFrom(personX);
      }
    }, "Thread-B");
    threadB.start();

    /* Wait for the threads to stop */
    threadA.join();
    threadB.join();
  }
}
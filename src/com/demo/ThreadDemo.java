package com.demo;


public class ThreadDemo {
    private int i = 10;
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo.new inc()).start();
        new Thread(threadDemo.new inc()).start();
        new Thread(threadDemo.new dec()).start();
        new Thread(threadDemo.new dec()).start();
    }

    public void inc(int i){
        this.i = ++i;
        System.out.println(i);
    }

    public void dec(int i){
        this.i = --i;
        System.out.println(i);
    }
    private class inc implements Runnable{

        @Override
        public void run() {
            inc(i);
        }
    }

    private class dec implements Runnable{

        @Override
        public void run() {
            dec(i);
        }
    }
}

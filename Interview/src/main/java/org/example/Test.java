package org.example;

import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;

public class Test implements  Runnable {

    static int number = 1;
    boolean sleep = false;

    @Override
    synchronized public void run() {
        number = number + 1;
        System.out.println(number + Thread.currentThread().getName());
        if(number % 2 == 0)
            System.out.println("even "+ (number*number));
    }
}
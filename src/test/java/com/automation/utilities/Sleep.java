package com.automation.utilities;

public abstract class Sleep {

    public static void s (int numOfSec) throws InterruptedException {

        Thread.sleep(numOfSec * 1000);
    }
}

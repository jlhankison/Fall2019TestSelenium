package com.automation.utilities;

public abstract class BrowserUtils {

    public static void wait(int numOfSec) {

        try{

            Thread.sleep(numOfSec * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

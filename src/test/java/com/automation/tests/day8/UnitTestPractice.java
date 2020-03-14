package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {

        //unit test
        //to check if our method works properly
        //if assertion fails, that means our method doesn't work correctly
        // that means we have to fix the method
        String expected = "cba";
        String strToReverse = "abc";
        String actual = reverseString(strToReverse);
        verifyEquals(expected, actual);


    }
    //annotation
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elpp";
        String actual = reverseString("apple");
        // To verify if expected result is equal to actual
        Assert.assertEquals(actual, expected);

    }

    public static boolean verifyEquals (String expected, String actual){


        if (expected.equals(actual)){
            System.out.println("TEST PASSED!!");
            return true;
        }else{
            System.out.println("TEST FAILED!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
            return false;
        }
    }

    public static String reverseString(String str){

        String reversed = "";

        for ( int i = str.length() - 1; i >= 0; i-- ) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}

package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {


   // will run before the @BeforeClass
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    @AfterTest
    public void aftertTest(){
        System.out.println("AFTER TEST");
    }


//    Runs only once in the class before @BeforeMethod AND before any tests
//    regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass(){
        System.out.println("    BEFORE CLASS ");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("    AFTER CLASS");
    }

    //runs before every test automatically
    //works as a precondition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("        BEFORE METHOD");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("        AFTER METHOD");
    }

    @Test
    public void test1(){

        System.out.println("            Test 1");
        String expected = "apple";
        String actual = "apple";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2(){

        System.out.println("            Test 2");
        int num1 = 5;
        int num2 = 10;

        Assert.assertTrue(num1<num2);

    }
}

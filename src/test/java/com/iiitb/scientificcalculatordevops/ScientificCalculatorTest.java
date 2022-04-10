package com.iiitb.scientificcalculatordevops;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ScientificCalculatorTest {
    private static final double DELTA = 1e-15;
    ScientificCalculator calculator = new ScientificCalculator();

    @Test
    public void powerTruePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("2"));
        payload1.put("input2",(Object) new String("5"));


        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String("10"));
        payload2.put("input2",(Object) new String("2"));

        assertEquals("Squaring a number for True Positive", 32, calculator.power(payload1), DELTA);
        assertEquals("Squaring a number for True Positive", 100, calculator.power(payload2), DELTA);

    }


    @Test
    public void powerFalsePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("2"));
        payload1.put("input2",(Object) new String("5"));


        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String("10"));
        payload2.put("input2",(Object) new String("2"));

        assertNotEquals("Squaring a number for False Positive", 100, calculator.power(payload1), DELTA);
        assertNotEquals("Squaring a number for False Positive", 32, calculator.power(payload2), DELTA);

    }

    @Test
    public void squareRootTruePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("36"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "12.25"));

        assertEquals("Squaring a number for True Positive", 6, calculator.sqrt(payload1), DELTA);
        assertEquals("Squaring a number for True Positive", 3.5, calculator.sqrt(payload2), DELTA);

    }

    @Test
    public void squareRootFalsePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("36"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "12.25"));

        assertNotEquals("Squaring a number for False Positive", 10, calculator.sqrt(payload1), DELTA);
        assertNotEquals("Squaring a number for False Positive", 2.5, calculator.sqrt(payload2), DELTA);
    }

    @Test
    public  void logTruePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("100"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "10000"));

        assertEquals("Squaring a number for True Positive", 2, calculator.log(payload1), DELTA);
        assertEquals("Squaring a number for True Positive", 4, calculator.log(payload2), DELTA);

    }


    @Test
    public  void logFalsePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("100"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "10000"));

        assertNotEquals("Squaring a number for False Positive", 4, calculator.log(payload1), DELTA);
        assertNotEquals("Squaring a number for False Positive", 2, calculator.log(payload2), DELTA);

    }


    @Test
    public  void FactTruePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("4"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "6"));

        assertEquals("Squaring a number for False Positive", 24, calculator.fact(payload1), DELTA);
        assertEquals("Squaring a number for False Positive", 720, calculator.fact(payload2), DELTA);

    }

    @Test
    public  void FactFalsePositive(){
        Map<String,Object> payload1 = new HashMap();
        payload1.put("input1",(Object) new String("4"));

        Map<String,Object> payload2 = new HashMap();
        payload2.put("input1",(Object) new String( "6"));

        assertNotEquals("Squaring a number for False Positive", 720, calculator.fact(payload1), DELTA);
        assertNotEquals("Squaring a number for False Positive", 24, calculator.fact(payload2), DELTA);

    }


}

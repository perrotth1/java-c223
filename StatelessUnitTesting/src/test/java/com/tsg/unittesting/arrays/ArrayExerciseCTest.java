package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.arrays.ArrayExerciseC.stringThemTogether;

/**
 *
 * @author Henry
 */
public class ArrayExerciseCTest {
    
    /**
     * TEST PLAN
     * stringThemTogether({}) -> ""
     * stringThemTogether({1}) -> "1"
     * stringThemTogether({1,2,3}) -> "123"
     * stringThemTogether({100,-6,45}) -> "100-645"
     */
    public ArrayExerciseCTest() {
    }

    @Test
    public void stringThemTogetherTestEmpty() {
        String result = stringThemTogether( new int[] {} );
        String expected = "";
        assertEquals(expected, result, "{} should output empty string ");
    }
    @Test
    public void stringThemTogetherTest1() {
        String result = stringThemTogether( new int[] {1} );
        String expected = "1";
        assertEquals(expected, result, "{1} should output string: 1");
    }
    @Test
    public void stringThemTogetherTest123() {
        String result = stringThemTogether( new int[] {1,2,3} );
        String expected = "123";
        assertEquals(expected, result, "{1,2,3} should output string: 123");
    }
    @Test
    public void stringThemTogetherTestNeg() {
        String result = stringThemTogether( new int[] {100,-6,45} );
        String expected = "100-645";
        assertEquals(expected, result, "{100,-6,45} should output string: 100-645");
    }
}

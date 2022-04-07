package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.arrays.ArrayExerciseA.maxOfArray;

/**
 *
 * @author Henry
 */
public class ArrayExerciseATest {
    
    /* Test plan
        maxOfArray({1}) -> 1
        maxOfArray({-5, -10, -100}) -> -5
        maxOfArray({12345, 34567, 111111}) -> 111111
        maxOfArray({1, 2, 5, 1, 23, 44, 22, 5, 10, 8, 11, 40, 90, 30, 100, 44, -1, -100, 0}) -> 100
    */

    @Test
    public void maxOfArrayTestSingle() {
        //arrange
        int[] input = {1};
        
        //act
        int result = maxOfArray(input);
        
        //assert
        int expected = 1;
        assertEquals(expected, result, "Max of {1} should be 1!");
    }
    @Test
    public void maxOfArrayTestNegatives() {
        //arrange
        int[] input = {-5, -10, -100};
        
        //act
        int result = maxOfArray(input);
        
        //assert
        int expected = -5;
        assertEquals(expected, result, "Max of {-5, -10, -100} should be -5!");
    }
    @Test
    public void maxOfArrayTestBigNumbers() {
        //arrange
        int[] input = {12345, 34567, 111111};
        
        //act
        int result = maxOfArray(input);
        
        //assert
        int expected = 111111;
        assertEquals(expected, result, "Max of {12345, 34567, 111111} should be 111111!");
    }
    @Test
    public void maxOfArrayTestLargeArray() {
        //arrange
        int[] input = {1, 2, 5, 1, 23, 44, 22, 5, 10, 8, 11, 40, 90, 30, 100, 44, -1, -100, 0};
        
        //act
        int result = maxOfArray(input);
        
        //assert
        int expected = 100;
        assertEquals(expected, result, "Max of {1, 2, 5, 1, 23, 44, 22, 5, 10, "
                                     + "8, 11, 40, 90, 30, 100, 44, -1, -100, 0} should be 100!");
    }
}

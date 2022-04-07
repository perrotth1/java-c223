package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.arrays.ArrayExerciseB.multiplyAll;

/**
 *
 * @author Henry
 */
public class ArrayExerciseBTest {
    
    /**
     * TEST PLAN
     * multiplyAll( 1, {} ) -> {}
     * multiplyAll( 4, {1, 2, 3, 4} ) -> {4, 8, 12, 16}
     * multiplyAll( 0, {10, 20} ) -> {0, 0}
     * multiplyAll( -1000, {-5, -10, 5, 10} ) -> {5000, 10000, -5000, -10000} 
     */
    
    public ArrayExerciseBTest() {
    }

    @Test
    public void multiplyAllTestEmpty(){
        int[] result = multiplyAll( 1, new int[] {} );
        int[] expected = {};
        assertArrayEquals(expected, result, "Multiplied array should be {}");
    }
    @Test
    public void multiplyAllTestBy4(){
        int[] result = multiplyAll( 4, new int[] {1, 2, 3, 4} );
        int[] expected = {4, 8, 12, 16};
        assertArrayEquals(expected, result, "Multiplied array should be {4, 8, 12, 16}");
    }
    @Test
    public void multiplyAllTestBy0(){
        int[] result = multiplyAll( 0, new int[] {10, 20} );
        int[] expected = {0, 0};
        assertArrayEquals(expected, result, "Multiplied array should be {0, 0}");
    }
    @Test
    public void multiplyAllTestByNeg(){
        int[] result = multiplyAll( -1000, new int[] {-5, -10, 5, 10} );
        int[] expected = {5000, 10000, -5000, -10000};
        assertArrayEquals(expected, result, "Multiplied array should be {5000, 10000, -5000, -10000}");
    }
}

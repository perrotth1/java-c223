package com.tsg.unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.logic.LogicExerciseB.placeOf;

/**
 *
 * @author Henry
 */
public class LogicExerciseBTest {
    
    /**
     * TEST PLAN
     * placeOf(1) -> "1st"
     * placeOf(2) -> "2nd"
     * placeOf(3) -> "3rd"
     * placeOf(7) -> "7th"
     * placeOf(11) -> "11th"
     * placeOf(21) -> "21st"
     * placeOf(217) -> "217th"
     * placeOf(100) -> "100th"
     * placeOf(2000) -> "2000th"
     */
    public LogicExerciseBTest() {
    }

    @Test
    public void placeOfTest1() {
        String result = placeOf(1);
        String expected = "1st";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest2() {
        String result = placeOf(2);
        String expected = "2nd";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest3() {
        String result = placeOf(3);
        String expected = "3rd";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest7() {
        String result = placeOf(7);
        String expected = "7th";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest11() {
        String result = placeOf(11);
        String expected = "11th";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest21() {
        String result = placeOf(21);
        String expected = "21st";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest217() {
        String result = placeOf(217);
        String expected = "217th";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest100() {
        String result = placeOf(100);
        String expected = "100th";
        assertEquals(expected, result);
    }
    @Test
    public void placeOfTest2000() {
        String result = placeOf(2000);
        String expected = "2000th";
        assertEquals(expected, result);
    }
}

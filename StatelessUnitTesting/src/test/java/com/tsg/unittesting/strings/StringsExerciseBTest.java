package com.tsg.unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.strings.StringsExerciseB.tripleIt;

/**
 *
 * @author Henry
 */
public class StringsExerciseBTest {
    /**
     * TEST PLAN
     * tripleIt("") -> ""
     * tripltIt(null) -> ""
     * tripleIt("test") -> "testTESTtest"
     * tripleIt("CAPS") -> "capsCAPScaps"
     * tripleIt("It's Mixed... ") -> "it's mixed... IT'S MIXED... it's mixed... "
     */
    public StringsExerciseBTest() {
    }

    @Test
    public void tripleItTestEmpty() {
        String result = tripleIt("");
        String expected = "";
        assertEquals(expected, result);
    }
    @Test
    public void tripleItTestNull() {
        String result = tripleIt(null);
        String expected = "";
        assertEquals(expected, result);
    }
    @Test
    public void tripleItTestLower() {
        String result = tripleIt("test");
        String expected = "testTESTtest";
        assertEquals(expected, result);
    }
    @Test
    public void tripleItTestUpper() {
        String result = tripleIt("CAPS");
        String expected = "capsCAPScaps";
        assertEquals(expected, result);
    }
    @Test
    public void tripleItTestMixed() {
        String result = tripleIt("It's Mixed... ");
        String expected = "it's mixed... IT'S MIXED... it's mixed... ";
        assertEquals(expected, result);
    }
}

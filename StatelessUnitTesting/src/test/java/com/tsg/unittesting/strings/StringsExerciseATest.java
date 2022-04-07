package com.tsg.unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.strings.StringsExerciseA.yell;

/**
 *
 * @author Henry
 */
public class StringsExerciseATest {
    /**
     * TEST PLAN
     * yell("") -> ""
     * yell(null) -> ""
     * yell(aaaa) -> AAAA
     * yell(oOoOh.) -> OOOOH.
     */
    public StringsExerciseATest() {
    }

    @Test
    public void yellTestEmpty() {
        String result = yell("");
        String expected = "";
        assertEquals(expected, result);
    }
    @Test
    public void yellTestNull() {
        String result = yell(null);
        String expected = "";
        assertEquals(expected, result);
    }
    @Test
    public void yellTestLower() {
        String result = yell("aaaa");
        String expected = "AAAA";
        assertEquals(expected, result);
    }
    @Test
    public void yellTestMixed() {
        String result = yell("oOoOh.");
        String expected = "OOOOH.";
        assertEquals(expected, result);
    }
}

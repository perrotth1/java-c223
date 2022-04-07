package com.tsg.unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.tsg.unittesting.logic.LogicExerciseA.friendlyGreeting;

/**
 *
 * @author Henry
 */
public class LogicExerciseATest {
    /**
     * TEST PLAN
     * friendlyGreeting(null, false) -> "..."
     * friendlyGreeting(null, true) -> "..."
     * friendlyGreeting("", false) -> "..."
     * friendlyGreeting("Joe", false) -> "hi"
     * friendlyGreeting("Sue", true) -> "Hello, Sue!"
     */
    public LogicExerciseATest() {
    }

    @Test
    public void friendlyGreetingTestNullStanger(){
        String result = friendlyGreeting(null, false);
        String expected = "...";
        assertEquals(expected, result, "Expected ...");
    }
    @Test
    public void friendlyGreetingTestNullFriend(){
        String result = friendlyGreeting(null, true);
        String expected = "...";
        assertEquals(expected, result, "Expected ...");
    }
    @Test
    public void friendlyGreetingTestEmpty(){
        String result = friendlyGreeting("", false);
        String expected = "...";
        assertEquals(expected, result, "Expected ...");
    }
    @Test
    public void friendlyGreetingTestStanger(){
        String result = friendlyGreeting("Joe", false);
        String expected = "hi";
        assertEquals(expected, result, "Expected hi");
    }
    @Test
    public void friendlyGreetingTestFriend(){
        String result = friendlyGreeting("Sue", true);
        String expected = "Hello, Sue!";
        assertEquals(expected, result, "Expected Hello, Sue!");
    }
}

package core.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MateStackTest {
    private MateStack<String> stack;

    @Test
    public void size_emptyStack_Ok() {
        stack = new MateStack<>();
        assertEquals(0, stack.size());
    }

    @Test
    public void size_oneElement_Ok() {
        stack = new MateStack<>();
        stack.push("Hello");
        assertEquals(1, stack.size());
    }

    @Test
    public void size_threeElements_Ok() {
        stack = new MateStack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Mate");
        assertEquals(3, stack.size());
    }

    @Test
    public void peek_oneElement_Ok() {
        stack = new MateStack<>();
        stack.push("Hello");
        assertEquals(1, stack.size());
        String actual = stack.peek();
        String expected = "Hello";
        assertEquals(expected, actual);
        assertEquals(1, stack.size());
    }

    @Test
    public void peek_severalTimes_Ok() {
        stack = new MateStack<>();
        stack.push("Hello");
        stack.push("World");
        assertEquals(2, stack.size());
        String actual = stack.peek();
        String expected = "World";
        assertEquals(expected, actual);

        String actualSecondTry = stack.peek();
        String expectedSecondTry = "World";
        assertEquals(expectedSecondTry, actualSecondTry);

        String actualThirdTry = stack.peek();
        String expectedThirdTry = "World";
        assertEquals(expectedThirdTry, actualThirdTry);

        assertEquals(2, stack.size());
    }

    @Test
    public void peek_emptyStack() {
        stack = new MateStack<>();
        assertEquals(0, stack.size());
        try {
            stack.peek();
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "Stack is empty");
            return;
        }
        fail("Peek is not available for empty stack");
    }

    @Test
    public void pop_Ok() {
        stack = new MateStack<>();
        stack.push("Hello");
        assertEquals(1, stack.size());
        String actual = stack.pop();
        String expected = "Hello";
        assertEquals(expected, actual);
        assertEquals(0, stack.size());
    }

    @Test
    public void pop_threeElements_Ok() {
        stack = new MateStack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Mate");
        assertEquals(3, stack.size());

        String actual = stack.pop();
        String expected = "Mate";
        assertEquals(expected, actual);
        assertEquals(2, stack.size());

        String actualSecond = stack.pop();
        String expectedSecond = "World";
        assertEquals(expectedSecond, actualSecond);
        assertEquals(1, stack.size());

        String actualThird = stack.pop();
        String expectedThird = "Hello";
        assertEquals(expectedThird, actualThird);
        assertEquals(0, stack.size());
    }


    @Test
    public void pop_emptyStack() {
        stack = new MateStack<>();
        assertEquals(0, stack.size());
        try {
            stack.pop();
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "Stack is empty");
            return;
        }
        fail("Peek is not available for empty stack");
    }
}

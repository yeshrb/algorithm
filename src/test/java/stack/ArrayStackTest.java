package stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    private ArrayStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new ArrayStack();
    }

    @Test
    public void create_a_new_stack_should_be_empty() {
        ArrayStack<Integer> stack_1 = new ArrayStack();
        assertNotNull(stack_1);
        assertTrue(stack_1.isEmpty());
    }

    @Test
    public void should_not_empty_after_push_a_element() {
        stack.push(1000);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void should_get_size_1_after_push_a_element() {
        stack.push(1);
        assertEquals(1, stack.getSize());
    }

    @Test
    public void should_get_size_3_after_push_3_element() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.getSize());
    }

    @Test
    public void should_get_the_pushed_element_on_peek() {
        stack.push(1);
        assertEquals(1, (int) stack.peek());
        stack.push(2);
        assertEquals(2, (int) stack.peek());
        stack.push(3);
        assertEquals(3, (int) stack.peek());
    }

    @Test
    public void should_get_size_minus_1_after_pop_an_element() {
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        assertEquals(20, stack.getSize());
        stack.pop();
        assertEquals(19,stack.getSize());
        stack.pop();
        assertEquals(18,stack.getSize());
    }

}
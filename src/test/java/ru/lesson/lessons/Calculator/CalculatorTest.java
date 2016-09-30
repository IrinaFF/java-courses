package ru.lesson.lessons.Calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @autor irinaff
 * @since 29.09.2016
 **/

public class CalculatorTest {
    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(1, 1);
        assertEquals(2, calculator.getResult());
    }
    @Test(expected = UserException.class)
    public void divException() throws UserException {
        Calculator calculator = new Calculator();
        calculator.div();
    }

    @Test()
    public void testDiv() throws UserException {
        Calculator calculator = new Calculator();
        calculator.div(1, 1);
        assertEquals(1, calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divRuntimeException() throws UserException {
        Calculator calculator = new Calculator();
        calculator.div(1,0);
    }
}
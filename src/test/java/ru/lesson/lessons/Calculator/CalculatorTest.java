package ru.lesson.lessons.lesson_4;

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

    @Test()
    public void testDiv() throws UserException {
        Calculator calculator = new Calculator();
        calculator.div(1, 1);
        assertEquals(1, calculator.getResult());
    }

    @Test(expected = UserException.class)
    public void divException() throws UserException {
        Calculator calculator = new Calculator();
        calculator.div();
    }

    @Test(expected = IllegalArgumentException.class)
    public void divRuntimeException() throws UserException {
        Calculator calculator = new Calculator();
        calculator.div(1,0);
    }

    @Test()
    public void testInv() throws UserException {
        Calculator calculator = new Calculator();
        calculator.inv(2, 3);
        assertEquals(8, calculator.getResult());
    }

    @Test()
    public void testDiff() throws UserException {
        Calculator calculator = new Calculator();
        calculator.diff(10, 3);
        assertEquals(7, calculator.getResult());
    }
}
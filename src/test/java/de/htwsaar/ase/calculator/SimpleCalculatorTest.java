package de.htwsaar.ase.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {

  private final SimpleCalculator calculator = new SimpleCalculator();

  @Test
  @DisplayName("Adding 2 and 3 should equal 5")
  void add_givenTwoAndThree_shouldReturnFive() {
    int result = calculator.add(2, 3);

    assertEquals(5, result);
  }

  @Test
  @DisplayName("Subtracting 3 from 5 should equal 2")
  void subtract_givenFiveAndThree_shouldReturnTwo() {
    int result = calculator.subtract(5, 3);

    assertEquals(2, result);
  }

  @Test
  @DisplayName("Multiplying 4 and 3 should equal 12")
  void multiply_givenFourAndThree_shouldReturnTwelve() {
    int result = calculator.multiply(4, 3);

    assertEquals(12, result);
  }

  @Test
  @DisplayName("Dividing 6 by 3 should equal 2")
  void divide_givenSixAndThree_shouldReturnTwo() {
    int result = calculator.divide(6, 3);

    assertEquals(2, result);
  }

  @Test
  @DisplayName("Dividing by zero should throw an exception")
  void divide_givenZeroDivisor_shouldThrowIllegalArgumentException() {
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));

    assertEquals("Division by zero is not allowed.", exception.getMessage());
  }
}


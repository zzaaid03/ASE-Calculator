package de.htwsaar.ase.calculator;

/** Performs the calculator's supported integer arithmetic operations. */
public final class SimpleCalculator {

  public int add(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }

  public int subtract(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }

  public int multiply(int firstNumber, int secondNumber) {
    return firstNumber * secondNumber;
  }

  /**
   * Divides one integer by another.
   *
   * @throws IllegalArgumentException when the divisor is zero
   */
  public int divide(int dividend, int divisor) {
    if (divisor == 0) {
      throw new IllegalArgumentException("Division by zero is not allowed.");
    }

    return dividend / divisor;
  }
}

package de.htwsaar.ase.calculator;

/** Immutable representation of one completed calculation. */
public record Calculation(
    int firstNumber, Operation operation, int secondNumber, int result) {

  @Override
  public String toString() {
    return firstNumber + " " + operation.symbol() + " " + secondNumber + " = " + result;
  }
}


package de.htwsaar.ase.calculator;

import java.util.List;

/** Coordinates arithmetic operations and calculation history. */
public final class CalculatorService {

  private final SimpleCalculator calculator;
  private final CalculationHistory history;

  public CalculatorService() {
    this(new SimpleCalculator(), new CalculationHistory());
  }

  CalculatorService(SimpleCalculator calculator, CalculationHistory history) {
    this.calculator = calculator;
    this.history = history;
  }

  /** Performs an arithmetic operation and stores the completed calculation in history. */
  public Calculation calculate(int firstNumber, Operation operation, int secondNumber) {
    int result = calculateResult(firstNumber, operation, secondNumber);
    Calculation calculation = new Calculation(firstNumber, operation, secondNumber, result);
    history.add(calculation);
    return calculation;
  }

  public List<Calculation> history() {
    return history.entries();
  }

  public void clearHistory() {
    history.clear();
  }

  private int calculateResult(int firstNumber, Operation operation, int secondNumber) {
    if (operation == Operation.ADD) {
      return calculator.add(firstNumber, secondNumber);
    }
    if (operation == Operation.SUBTRACT) {
      return calculator.subtract(firstNumber, secondNumber);
    }
    if (operation == Operation.MULTIPLY) {
      return calculator.multiply(firstNumber, secondNumber);
    }
    if (operation == Operation.DIVIDE) {
      return calculator.divide(firstNumber, secondNumber);
    }

    throw new IllegalArgumentException("Unsupported operation: " + operation);
  }
}

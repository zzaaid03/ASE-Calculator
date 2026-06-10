package de.htwsaar.ase.calculator;

/** Arithmetic operations supported by the calculator. */
public enum Operation {
  ADD("+"),
  SUBTRACT("-"),
  MULTIPLY("*"),
  DIVIDE("/");

  private final String symbol;

  Operation(String symbol) {
    this.symbol = symbol;
  }

  public String symbol() {
    return symbol;
  }

  /**
   * Finds the operation represented by a mathematical symbol.
   *
   * @throws IllegalArgumentException when the symbol is unsupported
   */
  public static Operation fromSymbol(String symbol) {
    for (Operation operation : values()) {
      if (operation.symbol.equals(symbol)) {
        return operation;
      }
    }

    throw new IllegalArgumentException("Unsupported operator: " + symbol);
  }
}

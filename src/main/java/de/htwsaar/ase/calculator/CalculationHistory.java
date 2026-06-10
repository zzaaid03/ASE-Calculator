package de.htwsaar.ase.calculator;

import java.util.ArrayList;
import java.util.List;

/** Stores calculations completed during the current application session. */
public final class CalculationHistory {

  private final List<Calculation> calculations = new ArrayList<>();

  public void add(Calculation calculation) {
    calculations.add(calculation);
  }

  public List<Calculation> entries() {
    return List.copyOf(calculations);
  }

  public void clear() {
    calculations.clear();
  }
}

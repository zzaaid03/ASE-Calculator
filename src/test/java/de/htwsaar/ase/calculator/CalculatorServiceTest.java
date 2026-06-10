package de.htwsaar.ase.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

  @Test
  @DisplayName("Completed calculations should appear in history")
  void calculate_givenExpression_shouldStoreCalculationInHistory() {
    CalculatorService service = new CalculatorService();

    Calculation result = service.calculate(8, Operation.MULTIPLY, 7);

    assertThat(result.toString()).isEqualTo("8 * 7 = 56");
    assertThat(service.history()).containsExactly(result);
  }

  @Test
  @DisplayName("Clear should remove all calculation history")
  void clearHistory_givenExistingCalculation_shouldRemoveAllEntries() {
    CalculatorService service = new CalculatorService();
    service.calculate(10, Operation.SUBTRACT, 4);

    service.clearHistory();

    assertThat(service.history()).isEmpty();
  }
}


package de.htwsaar.ase.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdIo;
import org.junitpioneer.jupiter.StdOut;

class CalculatorAppTest {

  @Test
  @DisplayName("Console application should calculate and display history")
  @StdIo({"2 + 3", "history", "exit"})
  void main_givenCalculationAndHistoryCommand_shouldPrintResults(StdOut output) {
    CalculatorApp.main(new String[0]);

    assertThat(output.capturedString())
        .contains("2 + 3 = 5")
        .contains("Calculation history:")
        .contains("Goodbye!");
  }

  @Test
  @DisplayName("Console application should explain invalid numbers")
  @StdIo({"not + 3", "exit"})
  void main_givenInvalidNumber_shouldPrintHelpfulMessage(StdOut output) {
    CalculatorApp.main(new String[0]);

    assertThat(output.capturedString())
        .contains("Invalid number. Enter whole numbers such as: 12 + 3");
  }
}

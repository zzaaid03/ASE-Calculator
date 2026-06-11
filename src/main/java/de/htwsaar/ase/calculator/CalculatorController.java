package de.htwsaar.ase.calculator;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** REST controller exposing calculator operations over HTTP. */
@RestController
@RequestMapping("/api")
public class CalculatorController {

  private final CalculatorService calculatorService = new CalculatorService();

  /** Performs a calculation and returns the result. */
  @PostMapping("/calculate")
  public CalculationResponse calculate(@RequestBody CalculationRequest request) {
    try {
      Operation operation = Operation.fromSymbol(request.operator());
      Calculation calculation =
          calculatorService.calculate(request.firstNumber(), operation, request.secondNumber());
      return new CalculationResponse(calculation.toString(), null);
    } catch (IllegalArgumentException exception) {
      return new CalculationResponse(null, exception.getMessage());
    }
  }

  /** Returns all calculations from the current session history. */
  @GetMapping("/history")
  public List<String> history() {
    return calculatorService.history().stream().map(Calculation::toString).toList();
  }

  /** Clears the calculation history. */
  @DeleteMapping("/history")
  public void clearHistory() {
    calculatorService.clearHistory();
  }

  record CalculationRequest(int firstNumber, String operator, int secondNumber) {}

  record CalculationResponse(String result, String error) {}
}

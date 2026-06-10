package de.htwsaar.ase.calculator;

import com.google.common.base.Splitter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Interactive console interface for the calculator. */
public final class CalculatorApp {

  private static final Splitter TOKEN_SPLITTER = Splitter.on(Pattern.compile("\\s+"));

  private final CalculatorService calculatorService;
  private final Scanner scanner;
  private final PrintStream output;

  CalculatorApp(CalculatorService calculatorService, Scanner scanner, PrintStream output) {
    this.calculatorService = calculatorService;
    this.scanner = scanner;
    this.output = output;
  }

  /** Starts the interactive calculator. */
  public static void main(String[] arguments) {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    CalculatorApp application = new CalculatorApp(new CalculatorService(), scanner, System.out);
    application.run();
  }

  void run() {
    printWelcome();

    while (scanner.hasNextLine()) {
      output.print("> ");
      String input = scanner.nextLine().trim();

      if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
        output.println("Goodbye!");
        return;
      }

      handleInput(input);
    }

    output.println("Goodbye!");
  }

  private void handleInput(String input) {
    String command = input.toLowerCase(Locale.ROOT);

    switch (command) {
      case "" -> {
        return;
      }
      case "help" -> printHelp();
      case "history" -> printHistory();
      case "clear" -> clearHistory();
      default -> calculate(input);
    }
  }

  private void calculate(String input) {
    List<String> tokens = TOKEN_SPLITTER.splitToList(input);
    if (tokens.size() != 3) {
      output.println("Invalid input. Enter an expression such as: 12 + 3");
      return;
    }

    try {
      int firstNumber = Integer.parseInt(tokens.get(0));
      Operation operation = Operation.fromSymbol(tokens.get(1));
      int secondNumber = Integer.parseInt(tokens.get(2));
      Calculation calculation =
          calculatorService.calculate(firstNumber, operation, secondNumber);
      output.println(calculation);
    } catch (NumberFormatException exception) {
      output.println("Invalid number. Enter whole numbers such as: 12 + 3");
    } catch (IllegalArgumentException exception) {
      output.println("Error: " + exception.getMessage());
    }
  }

  private void printHistory() {
    List<Calculation> history = calculatorService.history();
    if (history.isEmpty()) {
      output.println("History is empty.");
      return;
    }

    output.println("Calculation history:");
    history.forEach(calculation -> output.println("- " + calculation));
  }

  private void clearHistory() {
    calculatorService.clearHistory();
    output.println("History cleared.");
  }

  private void printWelcome() {
    output.println("ASE Calculator");
    output.println("Enter an integer expression or type 'help' for commands.");
  }

  private void printHelp() {
    output.println("Supported operators: +, -, *, /");
    output.println("Commands: history, clear, help, exit");
    output.println("Example: 12 * 4");
  }
}

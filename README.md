# ASE Calculator

A collaborative Java web calculator created by Zaid Jarrar, Wasim Saadeh, and Ali
Alqaddy for the Automated Software Development course.

## Features

- Integer addition, subtraction, multiplication, and division
- Friendly validation for invalid input and division by zero
- Calculation history for the current session
- Clear history button
- Web interface served via Spring Boot
- Automated tests and strict quality checks
- Continuous Integration with GitHub Actions

## Requirements

- Java 25 or newer
- No global Maven installation is required because the Maven Wrapper is included

## Build

On Windows:

```powershell
mvn package -DskipTests
```

On Linux or macOS:

```bash
./mvnw package -DskipTests
```

## Run

On Windows:

```powershell
C:\path\to\java25\bin\java.exe -jar target/calculator-1.0.0-SNAPSHOT.jar
```

On Linux or macOS:

```bash
java -jar target/calculator-1.0.0-SNAPSHOT.jar
```

Then open your browser at:

```
http://localhost:8080
```

## Usage

1. Enter the first number in the left input field
2. Select an operator (+, -, ×, /)
3. Enter the second number in the right input field
4. Click **Calculate** or press **Enter**
5. Your calculation history appears below the calculator
6. Click **Clear History** to reset the history

## Quality Assurance

- JUnit tests use descriptive names, `@DisplayName`, and Arrange-Act-Assert structure.
- AssertJ provides fluent assertions for service-level tests.
- Error Prone checks production and test code; warnings fail the build.
- Checkstyle enforces Google Java Style; warnings fail the build.
- GitHub Actions runs `mvn verify` and uploads the executable JAR after successful builds.

## Team Workflow

See [PLAN.md](PLAN.md) and [CONTRIBUTING.md](CONTRIBUTING.md) for responsibilities and
the agreed Git workflow.

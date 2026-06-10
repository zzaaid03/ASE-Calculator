# ASE Calculator

A collaborative Java console calculator created by Zaid Jarrar, Wasim Saadeh, and Ali
Alqaddy for the Automated Software Development course.

## Features

- Integer addition, subtraction, multiplication, and division
- Friendly validation for malformed input and division by zero
- Calculation history for the current session
- Interactive help and history clearing commands
- Guava-based input parsing
- Executable JAR packaging
- Automated tests and strict quality checks
- Continuous Integration with GitHub Actions

## Requirements

- Java 25 or newer
- No global Maven installation is required because the Maven Wrapper is included

## Build And Test

On Windows:

```powershell
.\mvnw.cmd verify
```

On Linux or macOS:

```bash
bash ./mvnw verify
```

The `verify` command compiles the application, runs Error Prone, checks Google Java Style,
runs all JUnit tests, and packages the executable JAR.

## Run

```powershell
java -jar target/calculator-1.0.0-SNAPSHOT.jar
```

Enter expressions with spaces between both numbers and the operator:

```text
12 + 3
8 * 7
20 / 5
```

Available commands are `history`, `clear`, `help`, and `exit`.

## Quality Assurance

- JUnit 6 tests use descriptive names, `@DisplayName`, and Arrange-Act-Assert structure.
- AssertJ provides fluent assertions for service-level tests.
- JUnit Pioneer captures and verifies the interactive console output.
- Error Prone checks production and test code; warnings fail the build.
- Checkstyle enforces Google Java Style; warnings fail the build.
- GitHub Actions runs `mvn verify` and uploads the executable JAR after successful builds.

## Team Workflow

See [PLAN.md](PLAN.md) and [CONTRIBUTING.md](CONTRIBUTING.md) for responsibilities and
the agreed Git workflow.

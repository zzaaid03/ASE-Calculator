# Calculator Project Plan

## Team

- Zaid Jarrar
- Wasim Saadeh
- Ali Alqaddy

## Branches

- `main`: stable integration branch
- `zaid`: calculator core and automated tests
- `wassim`: console interface, usability, and documentation
- `ali`: calculation history, CI workflow, and final quality review

## Responsibilities

### Zaid

- Review and improve `SimpleCalculator` and `CalculatorService`
- Extend unit tests for arithmetic edge cases
- Verify Error Prone and Checkstyle behavior

### Wasim

- Review and improve `CalculatorApp`
- Test all user commands and error messages
- Improve README usage instructions

### Ali

- Review and improve `CalculationHistory`
- Verify GitHub Actions and downloadable JAR artifact
- Perform final end-to-end acceptance testing

## Definition Of Done

A task is complete when:

1. The implementation works as expected.
2. Relevant automated tests pass.
3. `mvn verify` succeeds locally.
4. Changes are committed to a member branch.
5. A teammate reviews the pull request before it is merged into `main`.
6. GitHub Actions succeeds and provides the executable JAR.

## Suggested Final Workflow

1. Each member pulls the latest `main` into their branch.
2. Each member makes and tests at least one meaningful improvement.
3. Each member opens a pull request into `main`.
4. Another member reviews each pull request.
5. The team downloads and runs the final JAR from GitHub Actions.

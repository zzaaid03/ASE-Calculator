# Team Reflection Notes

These notes provide starting points for the team discussion. Each member should add their
own observations after completing their review and pull request.

## Programming Tools And Maven

Manual compilation made classpaths, output directories, dependencies, and JAR manifests easy
to misconfigure. Maven makes these steps repeatable through one project configuration and a
standard lifecycle. The `maven.compiler.release` property ensures every environment targets
the same Java platform.

## Error Prone And Checkstyle

Error Prone finds suspicious Java constructs during compilation, while Checkstyle enforces a
consistent coding convention. Failing the build on warnings is strict, but it prevents known
problems and style violations from accumulating or reaching teammates.

## Git And Collaboration

GitHub acts as the team's single source of truth. Small commits, frequent integration, and
pull-request reviews make changes easier to understand and reduce merge conflicts. The
`.gitignore` file keeps generated build output out of version control.

## Unit Testing

The Red-Green approach demonstrates that a test can expose incorrect behavior before the
implementation is corrected. Arrange-Act-Assert and `@DisplayName` make each scenario easier
to understand. Normal cases and exceptional cases are both necessary for robust software.
AssertJ improves readability through fluent assertions, and JUnit Pioneer makes console
interaction testable.

## Continuous Integration

GitHub Actions performs the same Maven verification after every push and pull request. This
gives the team fast feedback and prevents changes that fail compilation, static analysis,
style checks, or tests from being merged. Uploading the executable JAR also creates a
repeatable artifact for manual testing and delivery.


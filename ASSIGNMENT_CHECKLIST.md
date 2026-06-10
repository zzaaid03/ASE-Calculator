# ASE Assignment Checklist

## Completed In The Project

### Project Task 1: Programming Tools

- Java 25 is used as the project release.
- The application compiles and runs through Maven.
- Error Prone performs static code analysis.
- Maven creates an executable JAR.

### Project Task 2: Maven

- Standard `src/main/java` and `src/test/java` directories are used.
- The POM defines a meaningful name, version, package coordinates, and Java release.
- Guava is declared and used for input parsing.
- Maven Enforcer requires suitable Maven and Java versions.
- Versions Maven Plugin and Maven Dependency Plugin versions are declared.
- `mvn dependency:analyze` reports no dependency problems.

### Project Task 3: Error Prone

- Error Prone is integrated through Maven Compiler Plugin.
- Required JVM module settings are stored in `.mvn/jvm.config`.
- Compiler warnings fail the build.

### Project Task 4: Git And GitHub

- The repository contains a Maven `.gitignore`.
- Team branches exist for Zaid, Wasim, and Ali.
- Branch responsibilities and the pull-request workflow are documented.

### Project Task 5: Checkstyle

- Maven Checkstyle Plugin uses `google_checks.xml`.
- Production and test source code are checked.
- Checkstyle warnings fail the build.

### Project Task 6: JUnit

- Tests use JUnit 6.0.3.
- Test methods use descriptive names and `@DisplayName`.
- Normal arithmetic and division-by-zero behavior are tested.
- AssertJ fluent assertions are used.
- JUnit Pioneer verifies console input and output.

### Project Task 7: GitHub Actions

- `.github/workflows/maven-ci.yml` builds and tests every push and pull request.
- GitHub Actions uses Temurin 25 and Maven dependency caching.
- CI runs the Maven `verify` lifecycle.
- The executable calculator JAR is uploaded as a downloadable artifact.

## Required Team Actions Before Submission

These actions must be performed by the actual team members and cannot be replaced by code:

1. Zaid, Wasim, and Ali each make at least one meaningful commit on their own branch.
2. Each member pushes their branch and opens a pull request into `main`.
3. A different member reviews each pull request before it is merged.
4. The team confirms that GitHub Actions succeeds after the changes are pushed.
5. The team downloads the JAR artifact from GitHub Actions and runs it.
6. The team performs and discusses the required merge-conflict exercise.
7. Each member adds personal observations to `docs/REFLECTIONS.md`.

# Contributing

## Branch Workflow

Each team member works on their named branch:

- `zaid`
- `wassim`
- `ali`

Before starting work:

```bash
git switch <your-branch>
git pull --rebase origin main
```

Before pushing:

```bash
./mvnw verify
git status
git pull --rebase origin <your-branch>
git push origin <your-branch>
```

Open a pull request into `main` after the build succeeds. At least one teammate must review
the pull request before merging.

## Commit Messages

Create small, focused commits with imperative messages, for example:

```text
Add multiplication edge-case tests
Improve invalid input message
Document executable JAR usage
```

Do not commit generated build files from `target/`.


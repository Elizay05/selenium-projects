# Selenium Projects Portfolio

This repository contains **two independent automation projects** built with the Serenity BDD ecosystem.

Both projects use a **BDD + Screenplay** style and are designed as learning/portfolio examples for UI and API testing with Java.

---

## Repository Structure

- `serenitybddtraining/`  
  A training-oriented Serenity project that mixes API, domain-model, and basic persistence examples.
- `ui-api-serenity-automation/`  
  A more complete automation portfolio project that includes UI and API test suites against [automationexercise.com](https://automationexercise.com).

---

## 1) `serenitybddtraining`

### What this project is

`serenitybddtraining` is a hands-on practice project focused on Serenity fundamentals:

- Cucumber feature files in Spanish.
- Screenplay tasks/questions/interactions.
- Simple domain examples (e.g., account and money models).
- API-oriented step definitions and tasks.
- Extra persistence/database experimentation classes (Hibernate/JPA).

### Main technologies

- Java 17
- Maven
- Serenity BDD (`serenity-core`, `serenity-screenplay`, `serenity-screenplay-rest`, `serenity-cucumber`)
- JUnit 4 + JUnit 5 (with vintage engine)
- Hibernate + MySQL connector

### Important folders

- `src/test/resources/features/` → feature files (e.g., login, registration, withdrawal, questions).
- `src/main/java/stepdefinitions/` → Cucumber step definitions.
- `src/main/java/tasks/`, `interactions/`, `questions/` → Screenplay implementation.
- `src/main/java/models/` → simple domain models.
- `src/main/java/database/` → persistence and DB connection support classes.

### How to run

From the project folder:

```bash
cd serenitybddtraining
mvn clean verify
```

Serenity reports are aggregated during the Maven lifecycle (`verify` phase via `serenity-maven-plugin`).

---

## 2) `ui-api-serenity-automation`

### What this project is

`ui-api-serenity-automation` is a portfolio-grade project that separates **UI** and **API** tests into dedicated Cucumber suites:

- **UI suite**: validates real user flows (registration, login/logout, products, cart, checkout, subscription, etc.).
- **API suite**: validates API endpoints (users, brands, products, login verification, negative scenarios).

The project uses Serenity Screenplay patterns for maintainable tasks, interactions, and assertions.

### Main technologies

- Java 17
- Maven
- Serenity BDD 4.x
- Cucumber + JUnit 4 runner style
- Screenplay WebDriver + Screenplay REST

### Configuration highlights

- `serenity.conf` defines:
  - Browser: Chrome
  - Multiple Chrome runtime switches (incognito, no-sandbox, etc.)
  - REST base URL: `https://automationexercise.com/api`

### Important folders

- `src/test/resources/features/ui/` → UI scenarios.
- `src/test/resources/features/api/` → API scenarios.
- `src/test/java/com.portfolio.automation/runners/` → `UiTestSuite` and `ApiTestSuite`.
- `src/test/java/com.portfolio.automation/stepdefinitions/` → step definitions for both domains.
- `src/test/java/com.portfolio.automation/tasks/` and `questions/` → Screenplay building blocks.

### How to run

From the project folder:

```bash
cd ui-api-serenity-automation

# Run only API suite
mvn clean test -Dtest=ApiTestSuite

# Run only UI suite
mvn clean test -Dtest=UiTestSuite

# Generate Serenity aggregate report (after tests)
mvn serenity:aggregate
```

---

## Prerequisites (for both projects)

- JDK 17
- Maven 3.8+
- Chrome browser (for UI tests)
- Internet access (for tests that hit external environments)

---

## Notes

- These are **separate Maven projects** inside one repository (there is no root multi-module `pom.xml`).
- Run commands from each project directory.
- Some training scenarios appear intentionally minimal/incomplete because the repository is also intended for learning and practice.

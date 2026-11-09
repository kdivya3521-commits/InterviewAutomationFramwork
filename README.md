
# Enterprise Hybrid Test Automation Framework

This framework avoids brittle script design by establishing strict separation of concerns across four decoupled layers:


## Authors

- [@divyasai](https://github.com/kdivya3521-commits)


## Documentation

[Documentation](https://linktodocumentation)

📦 Deep-Dive Into Framework Layers

1. Data Provider & Configuration Utilities

Test scripts remain completely blind to underlying data sources. Data is parsed and mapped directly into strongly-typed Java POJOs before streaming into TestNG.

Excel Reader (ExcelReaderUtility): Powered by Apache POI to extract structured test criteria from .xlsx workbooks.

CSV & JSON Parsers (CSVReaderUtility, Gson): Handles lightweight flat files and complex nested structures, mapping payloads directly to model classes like User.java.

Dynamic Test Data (Java Faker): Injects randomized, on-the-fly attributes (names, emails, credentials) to eliminate static data collision during multi-user runs.

Type-Safe Enums & Logging: Hardcoding is prohibited using Java Enums (Browsers, ENV). A centralized wrapper around Log4j2 unifies test-step tracking across all threads.

2. Core Automation Engine & Page Object Model (POM)

Thread-Safe WebDriver Management: Parallel execution requires isolated driver contexts. The BrowserUtility core engine wraps a ThreadLocal<WebDriver> instance, completely eliminating race conditions and session hijacking during multi-threaded runs.

Encapsulated Synchronization: Explicit waits are abstracted directly into core wrapper methods, preventing flakiness without scattering raw WebDriverWait boilerplate across page classes.

Page Chaining Pattern: Navigation logic mirrors human behavior. Page action methods explicitly return the target page object instance (e.g., public DashboardPage login() { ... return new DashboardPage(driver); }), producing clean, fluent test scripts.

3. Test Management & Execution Infrastructure

Lifecycle Governance: All test classes inherit from TestBase, which handles @BeforeMethod and @AfterMethod orchestration, clean initialization, and teardown routines.

Dynamic Grid & Local Toggling: Integration with Maven Surefire and TestNG parameters allows runtime flag injection (-Dbrowser=chrome, -DisLambdaTest=true, -DisHeadless=true). This enables zero-code configuration switching between local execution and cloud execution on LambdaTest using RemoteWebDriver.

Parallel Execution Strategy: Configured via testng.xml using parallel="methods" for maximum throughput and reduced feedback loops.

4. Listeners, Error Handling & CI/CD Pipeline

Lifecycle Hook (ITestListener): Hooks into the complete test run lifecycle. On test failure, it autonomously extracts the active ThreadLocal driver session, captures a failure screenshot via BrowserUtility, and embeds it into Extent Reports.

Flaky Test Mitigation: A custom RetryAnalyzer intercepts failed executions, automatically re-running transient failures up to a configured threshold defined in properties.

Code Quality & CI/CD: Integrated static code analysis via SonarQube (embedded directly within the Eclipse workspace) paired with automated workflow execution via GitHub Actions.

🛠️ Technology Stack

Core Language: Java (JDK 11+)

Automation Engine: Selenium WebDriver

Test Runner: TestNG

Build Tool: Apache Maven & Maven Surefire Plugin

Data Providers: Apache POI, OpenCSV, Gson, Java Faker

Logging & Reporting: Log4j2, Extent Reports

Grid Infrastructure: LambdaTest (RemoteWebDriver)

DevOps & Quality: SonarQube, GitHub Actions



🚀 Getting Started & Execution

Prerequisites

Java JDK 11 or higher installed and configured in JAVA_HOME.

Apache Maven installed.

Running Tests Locally

Clone the repository and run the default suite via Maven:

git clone https://github.com/your-username/hybrid-automation-framework.git
cd hybrid-automation-framework
mvn clean test


Running with Custom Parameters (Headless / Cloud)

To trigger specific environment configurations or run against cloud grids like LambdaTest via command-line flags:

mvn test -DsuiteXmlFile=src/test/resources/runners/testng.xml -Dbrowser=CHROME -DisHeadless=true

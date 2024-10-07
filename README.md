# PetFinder Automation Task

## Overview

The **PetFinder Automation Task** is an automated testing framework built using **Selenium**, **Java**, **Cucumber**, **
TestNG**, and **Extent Reporting**. This project is designed to facilitate the testing of the PetFinder application
through a well-structured and maintainable automation framework.

## Project Structure

### Java Level

- **Common Package**:
    - Contains the `PageBase` class, which defines all action and assertion functions that can be extended by other page
      classes.

- **Pages Package**:
    - Houses specific page classes corresponding to various sections of the PetFinder application.

### Test Data Package

- **Data Package**:
    - Includes JSON files or other data sources containing test data for each page.
    - Each page's test data is organized into separate JSON files, such as:
        - `home_data.json` - Test data for the Home page.
        - `login_data.json` - Test data for the Login page.
        - `signup_data.json` - Test data for the Sign Up page.

- **Utils Package**:
    - **JsonReader**: A utility class for reading test data from JSON files.
    - **Wait**: A utility class that provides explicit wait functions for WebElement interactions.

- **Extent Reporting**:
    - Configuration for Extent Reporting is located under the extent report folder. After test execution, the results
      are stored in the `test-output` directory at the project root.

### Test Level

- **Connector Package**:
    - Contains the `Hooks` class, which initializes and closes the WebDriver before and after each test.

- **Step Package**:
    - Includes step definitions for each feature file.

- **Runner Package**:
    - Contains the Cucumber test runner class that glues the steps to hooks and feature files and specifies which test
      tags to execute.

## Resources

### Features Directory

Located under `src/test/resources`, this directory contains feature files for testing the following functionalities:

- **Home**
- **Login**
- **Sign Up**

Each feature is appropriately tagged for execution.

### Configuration Files

- **pom.xml**:
    - Contains all the necessary dependencies for the project.

- **TestNG.xml**:
    - The entry point for running the tests. Right-click and select "Run" to execute tests across multiple browsers
      sequentially.

## Fluent Pattern

A fluent pattern is employed in the step definitions to enhance readability and maintainability.

## How to Run

1. **Set Up Your Environment**:
    - Ensure you have Java and Maven installed on your machine.
    - Clone the repository to your local environment.

2. **Open the Project**:
    - Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. **Install Plugins**:
    - Make sure the Cucumber and Gherkin plugins are installed in your IDE for proper feature file support.

4. **Run Tests**:
    - Right-click on `TestNG.xml` and select "Run" to execute the tests.

5. **View Reports**:
    - After execution, the test results can be found in the `test-output` directory.

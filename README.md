SauceDemo UI Automation Framework

This project is a UI test automation framework built with Java, Selenium WebDriver, TestNG, and Maven using the SauceDemo e-commerce application.

The project demonstrates end-to-end UI automation using the Page Object Model (POM) design pattern and reusable test architecture.

Technologies Used
Java
Selenium WebDriver
TestNG
Maven
Project Structure
src/test/java
├── Base
│   └── BaseTest.java
│
├── Pages
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   ├── CheckoutOverviewPage.java
│   └── CheckoutCompletePage.java
│
└── Tests
    └── LoginTest.java
Framework Design

The framework follows the Page Object Model (POM) pattern.

Base Layer

Contains common test setup and teardown operations.

Page Layer

Each page is represented by a dedicated Page Object class containing locators and page-specific actions.

Examples:

LoginPage
ProductsPage
CartPage
CheckoutPage
CheckoutOverviewPage
CheckoutCompletePage
Test Layer

Contains business-oriented test scenarios separated from page implementation details.

Implemented Test Scenarios
Valid Login

Verifies that a valid user can successfully log into the application and reach the Products page.

Invalid Login

Verifies that an error message is displayed when invalid credentials are used.

Add Product To Cart

Verifies that a product can be added to the shopping cart and the cart badge count is updated correctly.

Complete Order

Performs a complete end-to-end checkout flow:

Login
Add product to cart
Open cart
Proceed to checkout
Enter customer information
Complete purchase
Verify order confirmation message
Test Coverage
Login functionality
Authentication validation
Cart functionality
Checkout process
End-to-end purchase flow
How to Run Tests

Clone the repository:

git clone <repository-url>

Navigate to the project folder:

cd saucedemo-ui-automation

Run all tests:

mvn test
Notes
The project uses the Page Object Model (POM) design pattern.
Test scenarios are designed to be maintainable and reusable.
The framework demonstrates common UI automation practices used in modern test automation projects.

Author

Yiğit Taşdelen

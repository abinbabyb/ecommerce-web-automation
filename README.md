Automation Scripts with Setup and Execution Instructions
sidcofoods-automation project

**Project Structure:**

sidcofoods-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── sidcofoods/
│   │               ├── BaseTest.java
│   │               ├── pages/
│   │                    ├── LoginPage.java
│   │                    ├── RegistrationPage.java
│   │                    ├── HomePage.java
│   │                    ├── LogoutPage.java
│   │                    ├── SearchPage.java
│   │                    ├── CartPage.java   
│   │                    └── CheckoutPage.java 
│   │               
│   └── test/
│       └── java/
│           └── com/
│               └── sidcofoods/
│                   ├── RegistrationTest.java
│                   ├── LoginTest.java
│                   ├── LogoutTest.java
│                   ├── SearchTest.java
│                   ├── CartTest.java  
│                   └── CheckoutTest.java 
├── testng.xml
└── pom.xml


The sidcofoods-automation project is organized into the following modules:
Pages:
These are the Page Object classes that represent different pages of the application:
LoginPage.java
RegistrationPage.java
HomePage.java
LogoutPage.java
SearchPage.java
CartPage.java
CheckoutPage.java


**Tests:**
These are the test classes that contain the test cases for each functionality:
RegistrationTest.java
LoginTest.java
LogoutTest.java
SearchTest.java
CartTest.java
CheckoutTest.java


**How to Run the Tests**
Follow these steps to execute the automation scripts:
Open the project:
Open the sidcofoodsautomation project in Eclipse.
Navigate to testng.xml:
Locate the testng.xml file in the project directory.
Run the tests:
Right-click on the testng.xml file.
Select Run As -> TestNG Suite.
View Results:
The tests will execute, and the results will be displayed in the TestNG report.



# 🧪 DemoBlaze Test Automation Framework

---

## 🚀 Overview
This is a Selenium-based test automation framework for the [DemoBlaze](https://www.demoblaze.com/) application.

It is built using modern automation best practices with tools such as:
- **Selenium WebDriver** for browser automation
- **TestNG** for test management
- **Maven** for dependency & build management
- **Allure** for rich, interactive test reporting
- **Log4j2** for logging test events
- **Custom Listeners** for test lifecycle handling
- **Jenkins** for CI/CD pipeline integration

---

## 📁 Project Structure
```

├───main
│   ├───java
│   │   ├───models
│   │   │       AboutModel.java
│   │   │       ContactModel.java
│   │   │       LoginModel.java
│   │   │       Navbar.java
│   │   │       PlaceOrderModel.java
│   │   │       SignUpModel.java
│   │   │
│   │   ├───pages
│   │   │       CartPage.java
│   │   │       HomePage.java
│   │   │       ProductPage.java
│   │   │
│   │   └───utilities
│   │           DataUtil.java
│   │           LogUtility.java
│   │           Utility.java
│   │
│   └───resources
│           Allure.properties
│           Log4j2.properties
│
└───test
    ├───java
    │   │   CheckoutWithEmptyCart.java
    │   │   ContactUsTest.java
    │   │   emptyDataTest.java
    │   │   Home_test.java
    │   │   LoginChoosePurchase.java
    │   │   Login_test.java
    │   │   PlaceOrderTest.java
    │   │   PurchaseWithoutLogin.java
    │   │   SignUpTest.java
    │   │
    │   └───Listeners
    │           InvokedMethodListenersClass.java
    │           ITestListenerClass.java
    │
    └───resources
            TestData.json
```
---
## 🛠 Prerequisites

Make sure the following are installed:
- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/install.html)
- [Git](https://git-scm.com/downloads)
- Chrome browser (latest version)
- Internet access for downloading dependencies

---

## 📥 How to Set Up

1. **Clone the repository**
```bash
git clone https://github.com/mmohamedADEL/Demo_blaze_Test_automation.git
cd Demo_blaze_Test_automation
```
2. **Install dependencies**  
Run Maven to download all dependencies and build the project:  
```bash
mvn clean install
```
3. **Run tests**
   
Execute tests using Maven:
```bash
mvn clean install
```
4. **Generate allure report**
```bash
mvn allure:serve
```
---
## ✨ Key Features

- 🕷️ **Selenium WebDriver** for flexible and reliable browser automation  
- 📦 **Maven** for dependency and build management  
- 🤖 **Jenkins CI/CD** for continuous integration & testing  
- 📊 **Allure** for visually rich test reports  
- 📝 **Log4j** for detailed and configurable logging  
- 📂 **JSON test data** for easy maintenance and scalability  
- 🎧 **TestNG Listeners** for advanced test lifecycle control  

---

## 👨‍💻 Author

**Mohamed Adel**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Mohamed%20Adel-blue?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/mohamed-adel-elbaz-79239a272/)

---

## 📌 Notes

- This framework is focused on testing the **DemoBlaze** shopping app.  
- All test data is isolated in `TestData.json` under `test/resources`.  
- TestNG Listeners help with logs and retry mechanisms.  
- All tests can be easily integrated into Jenkins for scheduled runs.



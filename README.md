# Rokomari Web Automation

Automated testing project for the Rokomari website using 
**Selenium WebDriver**, 
**TestNG**, and **Maven**.

## 🛠 Technologies Used

- **Selenium WebDriver** – for browser automation  
- **TestNG** – for test configuration and execution  
- **Maven** – for project management and dependencies  
- **Java** – programming language  

## 📁 Project Structure

```
rokomari-web-automation/
├── .idea/ # IDE configuration files
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── pages/ # Page Object Model classes
│ │ │ ├── AuthorPage.java
│ │ │ ├── BasePage.java
│ │ │ ├── CartPage.java
│ │ │ ├── HomePage.java
│ │ │ ├── ProductPage.java
│ │ │ └── ShippingPage.java
│ │ └── utils/
│ │ └── DriverSetup.java
│ └── test/
│ └── java/
│ └── tests/
│ └── RokomariTest.java
├── .gitignore
└── pom.xml
```

## 🚀 Test Scenario

The automation covers the following scenario:

1. Sign up using Google  
2. Select **লেখক** from the menu  
3. Select **হুমায়ুন আহমেদ**  
4. Filter categories like **সমকালীন উপন্যাস**, **রচনা সংকলন**, **সমগ্র**  
5. Scroll down and go to the **Next Page** (if available)  
6. Add any book to the cart  
7. Click the **Cart Icon**  
8. Go to the **Shipping Page**  
9. Provide shipping information
10Log out  

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/prothoma-bd/rokomari-web-automation.git
   cd rokomari-web-automation
2. Install dependencies:
mvn install

3. Run the tests:
mvn test

✅ Test Coverage
-Login and Google Sign-Up

-Navigation through menus and filters

-Adding products to the cart

-Shipping information input

-Logout functionality

📊 Reports
After test execution, reports are generated in the target directory.

👩‍💻 Author
Sabina Sultana
📧 Email: sabina.prothoma@gmail.com

🔗 LinkedIn: https://www.linkedin.com/in/sabina-sultana-prothoma

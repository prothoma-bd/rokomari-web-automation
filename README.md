# Rokomari Web Automation

This repository contains automation scripts for testing the **Rokomari** website using Selenium WebDriver with Java and TestNG.

---

## Table of Contents

- [Overview](#overview)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

The project automates common user flows on the Rokomari website, including:


- **Searching for products**  
- **Adding products to cart**  
- **Navigating product pages**  
- **Verifying page elements and content**  

It helps ensure the website functions as expected and reduces manual testing effort.

---

## Technologies


- **Java 22**  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven**  
- **Git**  
- **IntelliJ IDEA**  

---

## Project Structure

rokomari-web-automation/
│
├─ src/
│ ├─ main/java/ # Utility classes (if any)
│ └─ test/java/ # Test scripts
│
├─ pom.xml # Maven project file
└─ README.md



---

## Setup Instructions

1. Clone the repository

```bash
git clone https://github.com/prothoma-bd/rokomari-web-automation.git

cd rokomari-web-automation

2. Open at IntelliJ IDEA or any preferred IDE.

3. Install dependencies:

bash
mvn clean install
 Running Tests 
From IntelliJ IDEA: Right-click the test class → Run
 From Command Line: 

bash
mvn test
Test results will be generated in the test-output folder.

##  Contributing 
1. Fork the repository.

2. Create a new branch: git checkout -b feature-name

3. Commit your changes: git commit -m "Add feature"

4. Push to branch: git push origin feature-name

5.Open a Pull Request.


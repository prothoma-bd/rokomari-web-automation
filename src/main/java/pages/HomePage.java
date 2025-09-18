package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HomePage extends BasePage {

    private By popupMessage = By.xpath("//div[@id='js--entry-popup']//div[@class='popup-modal__body']");
    private By popupCloseBtn = By.xpath("//button[@class='popup-modal__close-btn close-btn-outside js--popup-modal__close-btn']");
    private By signInMenu = By.cssSelector(".dropdown.user-menu");
    private By googleButton = By.cssSelector(".btn.btn-social-google");

    // Google Login Locators
    private By emailField = By.id("identifierId");
    private By emailNextBtn = By.id("identifierNext");
    private By passwordField = By.name("Passwd");   // correct locator
    private By passwordNextBtn = By.id("passwordNext");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closePopupIfVisible() {
        try {
            if (driver.findElement(popupMessage).isDisplayed()) {
                click(popupCloseBtn);
            }
        } catch (Exception e) {
            System.out.println("Popup not displayed, skipping...");
        }
    }

    public void clickSignIn() {
        click(signInMenu);
    }

    public void clickGoogleSignIn() {
        String parentWindow = driver.getWindowHandle();
        click(googleButton);

        // Switch to new Google Sign-In window
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void loginWithGoogle(String email, String password) {
        type(emailField, email);
        click(emailNextBtn);

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        type(passwordField, password);
        click(passwordNextBtn);

        // After login, return to main window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("rokomari.com")) {
                break;
            }
        }
    }

    public void clickLekhokMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        WebElement boiMenu = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[text()='বই']")));

        actions.moveToElement(boiMenu).perform();

        WebElement lekhokMenu = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@id='js--authors']")));

        lekhokMenu.click();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriverWait properly
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By continueToCheckoutBtn = By.id("js-continue-to-shipping");

    // Open Cart Page
    public void openCartPage(String cartUrl) {
        driver.get(cartUrl);
        System.out.println("🛒 Cart opened successfully");
    }

    // Proceed to Checkout
    public void proceedToCheckout() {
        try {
            // Wait until button is visible
            WebElement checkoutBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(continueToCheckoutBtn));

            // Scroll into view to avoid overlay issues
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", checkoutBtn);

            // Click using JS to bypass interception issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);

            System.out.println("✅ Proceeded to checkout successfully");

        } catch (Exception e) {
            System.out.println("❌ Failed to proceed to checkout");
            e.printStackTrace();
            throw new RuntimeException("Failed to proceed to checkout", e);
        }
    }
}
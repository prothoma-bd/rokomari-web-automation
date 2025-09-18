package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingPage extends BasePage {

    private By fullName = By.id("name");
    private By phone = By.id("phone");
    private By address = By.id("address");
    private By confirmOrderBtn = By.xpath("//a[@id='js-continue-to-shipping']");
    private By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void fillShippingInfo(String name, String phoneNumber, String addr) {
        type(fullName, name);
        type(phone, phoneNumber);
        type(address, addr);
    }

    public void confirmOrder() {
        click(confirmOrderBtn);
    }

    public void logout() {

            try {
                // If logout is inside a menu, first click to open it
                WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='userMenu']")));
                menu.click();

                // Wait for logout link and scroll into view
                WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutLink);
                logoutLink.click();

                System.out.println("✅ Logout successful");
            } catch (Exception e) {
                System.out.println("❌ Logout failed: " + e.getMessage());
            }
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    // Category filters
    private By somokalinUpanyas = By.xpath("//div[@data-search-key='সমকালীন উপন্যাস Contemporary Novel ']");
    private By rochonaSongkolon = By.xpath("//div[@data-search-key='রচনা সংকলন ও সমগ্র Literature Collection']");

    // Pagination
    private By nextPageBtn = By.cssSelector(".ion-chevron-right");

    // Book add to cart
    private By addToCartBtn = By.cssSelector("button.js--add-to-cart");

    // Cart icon
    private By cartIcon = By.id("js-cart-menu");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Apply filters for categories
     */
    public void filterCategories() {
        click(somokalinUpanyas);
        click(rochonaSongkolon);
    }

    /**
     * Go to next page if available
     */
    public void goToNextPageIfAvailable() {
        try {
            click(nextPageBtn);
            System.out.println("Navigated to next page");
        } catch (Exception e) {
            System.out.println("⚠️ No next page found, staying on current page");
        }
    }

    /**
     * Add first book to cart
     */

        public void addFirstBookToCart() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

                // Find the first book item (card)
                WebElement firstBookCard = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("(//div[contains(@class,'books-wrapper__item')])[1]")));

                // Scroll to book card
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstBookCard);
                Thread.sleep(800);

                // Hover to make Add to Cart button visible
                Actions actions = new Actions(driver);
                actions.moveToElement(firstBookCard).perform();

                // Now wait for Add to Cart button inside that card
                WebElement addToCartBtn = wait.until(ExpectedConditions
                        .elementToBeClickable(firstBookCard.findElement(By.xpath(".//button[contains(@class,'js--add-to-cart')]"))));

                addToCartBtn.click();
                System.out.println("✅ First book added to cart");

            } catch (Exception e) {
                throw new RuntimeException("❌ Failed to add book to cart", e);
            }
        }
    public void openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement cart = wait.until(ExpectedConditions
                .elementToBeClickable(cartIcon));

        cart.click();
        System.out.println("🛒 Cart opened successfully");
    }


}
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.DriverSetup;

public class RokomariTest {

    private WebDriver driver;
    private HomePage homePage;
    private AuthorPage authorPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private ShippingPage shippingPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.getDriver();
        driver.get("https://www.rokomari.com/");

        // Initialize Page Objects
        homePage = new HomePage(driver);
        authorPage = new AuthorPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        shippingPage = new ShippingPage(driver);
    }

    @Test
    public void rokomariFlowTest() {
        // 1. Close popup
        homePage.closePopupIfVisible();

        // 2. Sign in with Google
        homePage.clickSignIn();
        homePage.clickGoogleSignIn();
        homePage.loginWithGoogle("automationtest57@gmail.com", "test@12345");

        // 3. Go to লেখক (Authors) menu
        homePage.clickLekhokMenu();

        // 4. Select Humayun Ahmed
        authorPage.selectHumayunAhmed();

        // 5. Apply category filters
        productPage.filterCategories();

        // 6. Go to next page (if available)
        productPage.goToNextPageIfAvailable();

        // 7. Add first book to cart
        productPage.addFirstBookToCart();

        // 8. Open Cart and Checkout
        productPage.openCart();
        cartPage.proceedToCheckout();

        // 9. Fill Shipping Info
        shippingPage.fillShippingInfo("Sabina Sultana", "01743159817", "Dhaka");

        // 10. Logout
        shippingPage.logout();
        System.out.println("Test completed sucessfully.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
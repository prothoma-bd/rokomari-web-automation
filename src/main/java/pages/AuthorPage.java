package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorPage extends BasePage {

    private By humayunAhmed = By.xpath("//section[contains(@class,'all-authors-section')]//div[4]//a[1]");

    public AuthorPage(WebDriver driver) {
        super(driver);
    }

    public void selectHumayunAhmed() {
        click(humayunAhmed);
    }
}
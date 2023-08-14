package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='card-up'])[6]")
    private WebElement BookStoreApplicationCard;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickBookStoreApplicationCard(){
        BookStoreApplicationCard = driver.findElement(By.xpath("(//div[@class='card-up'])[6]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BookStoreApplicationCard);
        clickElement(BookStoreApplicationCard);
    }

}

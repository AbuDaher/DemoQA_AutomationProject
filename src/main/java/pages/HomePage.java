//HomePage

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='card-up'])[6]")
    protected WebElement bookStoreApplicationCard;

    @FindBy(xpath = "//*[@id='app']/header/a/img")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='main-header']")
    private WebElement subtitle;

    @FindBy(css = "#searchBox")
    WebElement type_to_search;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickBookStoreApplicationCard(){
        bookStoreApplicationCard = driver.findElement(By.xpath("(//div[@class='card-up'])[6]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookStoreApplicationCard);
        clickElement(bookStoreApplicationCard);
    }

     public boolean isPageTitlePresent(){
        return pageTitle.isDisplayed();
     }

     public boolean isSubtitlePresent(){
        return subtitle.isDisplayed() && subtitle.getText().equalsIgnoreCase("Book Store");
     }

     public boolean isSearchBarPresent(){
        return type_to_search.isDisplayed();
     }
}
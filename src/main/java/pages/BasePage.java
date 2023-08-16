package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element){
        element.click();
    }

    protected void inputText(WebElement element, String text){
        element.sendKeys(text);
    }
    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollintoView(true);", element);
    }
}
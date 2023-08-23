package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileBooks extends BasePage{
    @FindBy (css = "#delete-record-undefined")
    WebElement deleteItem;

    @FindBy(css = "#closeSmallModal-ok")
    WebElement confirmDeleteItem;

    @FindBy(xpath = "//button[contains(text(),'Log out')]")
    WebElement logOutButton;
    public ProfileBooks(WebDriver driver) {
        super(driver);
    }
    public void DeteleItem(){
        clickElement(deleteItem);}

    public void confirmDeteleItem(){
        clickElement(confirmDeleteItem);
    }
    public void logOut(){
        clickElement(logOutButton);
    }
}
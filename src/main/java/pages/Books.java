package pages;

import constants.Constants;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Books extends BasePage{

   @FindBy(css = "#login")
    WebElement logInButton;
    @FindBy(css = "#userName")
    WebElement userNameInput;
    @FindBy(css = "#password")
    WebElement passwordInput;
    @FindBy(css = "#login")
    WebElement loginWithCredentials;

    @FindBy(css = "#userName-value")
    WebElement userNameValueCheck;

    //        String expectedMessage = "Andreea";
//        String actualMessage = driver.findElement(By.cssSelector("#userName-value")).getText();
//        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.SIGN_IN_USER_DYSPLAYED);
    public Books(WebDriver driver) {
        super(driver);
    }

    public void logInCredentials(){
        clickElement(logInButton);
        inputText(userNameInput, Constants.USERNAME);
        inputText(passwordInput, Constants.PASSWORD);
        clickElement(loginWithCredentials);
    }

    public String logInConfirmation(){
        return userNameValueCheck.getText();
    }
}

package pages;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(css=".rt-tr-group")
    List<WebElement> booksList;
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
    public void printAllBooks(){
        for(WebElement element:booksList){
            if(!element.getText().isBlank()){
                System.out.println(element.getText());
                System.out.println("----------");
            }
        }
    }
    public void getAllBooksTitles() {
        ArrayList<String> bookTexts = new ArrayList<String>();
        for (WebElement element : booksList) {
            if (!element.getText().isBlank()) {
                bookTexts.add(element.getText());
            }
        }
        for (String bookText : bookTexts) {
            String[] lines = bookText.split("\n");
            if (lines.length > 0) {
                System.out.println(lines[0]);
            }
        }
    }
    public void getAllBooksAuthors() {
        ArrayList<String> bookTexts = new ArrayList<String>();
        for (WebElement element : booksList) {
            if (!element.getText().isBlank()) {
                bookTexts.add(element.getText());
            }
        }
        for (String bookText : bookTexts) {
            String[] lines = bookText.split("\n");
            if (lines.length > 0) {
                System.out.println(lines[1]);
            }
        }
    }

}

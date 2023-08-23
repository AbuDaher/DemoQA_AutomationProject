package pages;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

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

    @FindBy(xpath = "//a[contains(text(),'Git Pocket Guide')]")
    WebElement firstBookChoice;

    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    WebElement addfirstBookChoice;

    @FindBy(xpath = "//button[contains(text(),'Back To Book Store')]")
    WebElement backToBookStoreButton;

    @FindBy(xpath = "(//li[@id='item-3'])[5]")
    WebElement profileTab;

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
    public void getAllBooksPublisher() {
        ArrayList<String> bookTexts = new ArrayList<String>();
        for (WebElement element : booksList) {
            if (!element.getText().isBlank()) {
                bookTexts.add(element.getText());
            }
        }
        for (String bookText : bookTexts) {
            String[] lines = bookText.split("\n");
            if (lines.length > 0) {
                System.out.println(lines[2]);
            }
        }
    }
    public void allBookInformation(){
        for (int i = 0; i <= 2; i++) {
            System.out.println("--------------");
            ArrayList<String> bookTexts = new ArrayList<String>();
            for (WebElement element : booksList) {
                if (!element.getText().isBlank()) {
                    bookTexts.add(element.getText());
                }
            }
            for (String bookText : bookTexts) {
                String[] lines = bookText.split("\n");
                if (lines.length > 0 && i < lines.length) {
                    System.out.println(lines[i]);
                }
            }
        }
    }

    public void createBooksCollection(){
        clickElement(firstBookChoice);
        clickElement(addfirstBookChoice);
    }
    public void setBackToBookStore(){
        clickElement(backToBookStoreButton);
    }
    public void goToProfileBooks(){
       profileTab = driver.findElement(By.xpath("(//li[@id='item-3'])[5]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profileTab);
        clickElement(profileTab);
    }

    public boolean verifyBookIsPresent( String bookTitle){
        for(WebElement element: booksList){
            if(element.getText().equalsIgnoreCase((bookTitle))){
                return true;
            }
        }
        return  false;
    }
    public void printAuthorAndPublisherIfBookIsPresent(String bookTitle) {
        boolean bookFound = false;
        for (WebElement element : booksList) {
            if (verifyBookIsPresent(bookTitle) && element.getText().contains(bookTitle)) {
                String[] arr = element.getText().split("\n");
                System.out.println("Author: " + arr[1] + " Publisher: " + arr[2] );
                bookFound = true;
                break;
            }
        }
        if(!bookFound)
            System.out.println("Error, book not found !");
    }

    public void printBookTitleByIndex(int bookNumber){

            if(bookNumber>0 && !booksList.get(bookNumber).getText().isBlank()){
                System.out.println(booksList.get(bookNumber-1).getText());
            }
        }

    public void getAuthorByIndex(int bookNumber){

// !booksList.get(bookNumber).getText().isBlank()

        if(bookNumber>0 && bookNumber < booksList.size()) {
            if (!booksList.get(bookNumber-1).getText().isBlank()) {
                String[] arr = booksList.get(bookNumber - 1).getText().split("\n");
                System.out.println(arr[1]);
            }else {
                System.out.println("Book not found on this row.");
            }
        }
        else{
            System.out.println("Error, invalid book number. ");
        }
    }

}
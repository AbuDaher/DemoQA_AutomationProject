// Books

package pages;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import java.util.*;

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
    @FindBy(xpath = "//a[contains(text(),'Git Pocket Guide')]")
    WebElement firstBookChoice;
    @FindBy(xpath = "//button[contains(text(),'Add To Your Collection')]")
    WebElement addfirstBookChoice;
    @FindBy(xpath = "//button[contains(text(),'Back To Book Store')]")
    WebElement backToBookStoreButton;
    @FindBy(xpath = "(//li[@id='item-3'])[5]")
    WebElement profileTab;
    @FindBy(xpath = "(//span[@class='mr-2'])[1]")
    WebElement bookSelectionPageFirstBook;
    @FindBy(xpath = "//span[@class='mr-2']")
    List<WebElement> bookElements;
    @FindBy(xpath = "(//label[@id='userName-value'])[2]")
    WebElement bookSelectionPageTwo;
    @FindBy(css = "#addNewRecordButton")
    WebElement returnButton;

    protected ArrayList<String> bookTitlesList = new ArrayList<>();
    protected ArrayList<String> bookAuthorsList = new ArrayList<>();
    HashMap<String, String> bookTitleAuthorMap = new HashMap<>();

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

    public void allBookInformation() {
        for (int i = 0; i <= 2; i++) {
            ArrayList<String> bookTexts = new ArrayList<String>();
            for (WebElement element : booksList) {
                if (!element.getText().isBlank()) {
                    bookTexts.add(element.getText());
                }
            }
            for (String bookText : bookTexts) {
                String[] lines = bookText.split("\n");
                if (lines.length > 0 && i < lines.length - 2) {
                    // Add the title to the bookTitlesList
                    bookTitlesList.add(lines[i]);

                } else if (lines.length > 0 && i < lines.length - 1) {
                    // Add the author to the bookAuthorsList
                    bookAuthorsList.add(lines[i]);
                }
            }
        }
        System.out.println(bookTitlesList);
        System.out.println(bookAuthorsList);
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

    public void hashMapTitleKeyAuthorValue() {
        for (int i = 0; i < bookTitlesList.size() && i < bookAuthorsList.size(); i++) {
            String title = bookTitlesList.get(i);
            String author = bookAuthorsList.get(i);
            bookTitleAuthorMap.put(title, author);
        }
        for (Map.Entry<String, String> entry : bookTitleAuthorMap.entrySet()) {
            System.out.println("Title: " + entry.getKey() + ", Author: " + entry.getValue());
        }
    }

    public void extractValueByKey(String key) {
        if (bookTitleAuthorMap.containsKey(key)) {
            String value = bookTitleAuthorMap.get(key);
            System.out.println("Value for key '" + key + "': " + value);
        } else {
            System.out.println("Key '" + key + "' not found in the HashMap.");
        }
    }

    public void extractKeyByValue(String value) {
        for (Map.Entry<String, String> entry : bookTitleAuthorMap.entrySet()) {
            if (entry.getValue().equals(value)) {
                String key = entry.getKey();
                System.out.println("Key for value '" + value + "': " + key);
            }
        }
        System.out.println("Value '" + value + "' not found in the HashMap.");
    }

    public void selectBookForUrl() {
        clickElement(bookSelectionPageFirstBook);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        String[] urlParts = currentUrl.split("\\?");
        if (urlParts.length > 1) {
            String baseURL = urlParts[0];
            System.out.println("Base URL: " + baseURL);
            String[] params = Arrays.copyOfRange(urlParts, 1, urlParts.length);
            for(String query: params){
                System.out.println("The value of the book: " + query);
            }
            if (params.length > 0) {
                String lastQueryParam = params[params.length - 1];
                String[] keyValue = lastQueryParam.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    System.out.println("Last Parameter: Key=" + key + ", Value=" + value);
                } else {
                    System.out.println("Last Parameter: Invalid format");
                }
            } else {
                System.out.println("No parameters found.");
            }
            for (int i = 0; i < params.length - 1; i++) {
                System.out.println("Parameter " + (i + 1) + ": " + params[i]);
            }
        }
    }

    public void compareBooks() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        for (int i = 0; i < bookElements.size(); i++) {
            WebElement currentBook = bookElements.get(i);
            String bookTitlePageOne = currentBook.getText();

            jsExecutor.executeScript("arguments[0].scrollIntoView();", currentBook);

            clickElement(currentBook);

            String bookTitlePageTwo = bookSelectionPageTwo.getText();
            clickElement(returnButton);

            if (bookTitlePageOne.equals(bookTitlePageTwo)) {
                System.out.println("Matching titles for book: " + bookTitlePageOne + " versus " + bookTitlePageTwo);
            } else {
                System.out.println("No matching titles for book: " + bookTitlePageOne + " versus " + bookTitlePageTwo);
            }
            Utils.waitInSeconds(1);
        }
    }
}


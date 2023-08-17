import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Books;
import pages.HomePage;
import pages.ProfileBooks;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    protected Books books;

    protected ProfileBooks profileBooks;

    @BeforeMethod
    public void setup(){
        this.driver = new ChromeDriver();
        this.driver.get(Constants.URL);
        this.driver.manage().window().maximize();
        this.homePage = new HomePage(driver);
        this.books = new Books(driver);
        this.profileBooks = new ProfileBooks(driver);
    }

    @Test
    public void goToWebsite(){

    }
}
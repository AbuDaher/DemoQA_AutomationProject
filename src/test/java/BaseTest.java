import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Books;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected Books books;
    @BeforeMethod
    public void setup(){
        this.driver = new ChromeDriver();
        this.driver.get(Constants.URL);
        this.driver.manage().window().maximize();
        this.homePage = new HomePage(driver);
        this.books = new Books(driver);
    }

    @Test

    public void goToWebSite(){

    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {
    @Test
    public void goToWebsite(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    @Test
    public void logInTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("(//div[@class='card-up'])[6]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("(//div[@class='card-up'])[6]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#login")).click();
        driver.findElement(By.cssSelector("#userName")).sendKeys("Andreea");
        driver.findElement(By.cssSelector("#password")).sendKeys("Andreea123!");
        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(1000);
        String expectedMessage = "Andreea";
        String actualMessage = driver.findElement(By.cssSelector("#userName-value")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error: User name is not present");

        driver.close();
    }
}

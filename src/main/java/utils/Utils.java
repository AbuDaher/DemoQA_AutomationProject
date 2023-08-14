package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    public static void waitInSeconds(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static void scrollToElement(By element1, WebDriver driver){
        WebElement element = driver.findElement(element1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

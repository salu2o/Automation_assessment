package home;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mywait {
	
//    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) 
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
//        //wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
    
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
    }
    
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    

}

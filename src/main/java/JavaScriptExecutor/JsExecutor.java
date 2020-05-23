package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class JsExecutor {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.capgemini.com");

        JavascriptExecutor js = ((JavascriptExecutor)driver);
       // js.executeScript("window.scrollBy(0,1000)");
        TouchActions touchActions = new TouchActions(driver);
        WebElement element = driver.findElement(By.xpath("//h2[text()='COVID-19']"));
        WebElement endElement = driver.findElement(By.xpath("//a[contains(text(),'CEO')]"));
        touchActions.longPress(element).moveToElement(endElement).release().perform();
    }
}

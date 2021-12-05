package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    /**
     * Region Variables
     */
    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {
        // D:\Workspace\intellij-workspace\yelpAutomate\yelpAutomate\resources
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver_win.exe");
        //  D:\Workspace\intellij-workspace\yelpAutomate\yelpAutomate\resources\chromedriver_win.exe
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
    }

    /**
     * Region Constructor
     */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    /**
     * Region Methods
     */

    public static void navigateTo (String url){
        driver.get(url);
    }

    public static void closeBrowser (){
        driver.quit();
    }

    /**
     * Get a webelement along applying <mark>wait</mark> to ensure element is available
     * @param locator xpath locator
     * @return WebElement will be <b>null</b> if <b>locator doesn't match to an actual element from dom</b>
     */
    protected WebElement Find (String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath (locator) ));
    }

    protected void moveNClick (String locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = Find(locator);
        // WebElement ele = driver.findElement(By.xpath(locator));
        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
    }

    protected void jsMoveNclick (String locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement ele = Find(locator);
        js.executeScript("arguments[0].scrollIntoView();", ele);
        js.executeScript("arguments[0].click();", ele);
    }

    protected void eraseNwrite (String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    protected void write (String locator, String textToWrite){
        Find(locator).sendKeys(textToWrite);
    }

    public List<WebElement> getAllElements (String locator){
        return driver.findElements(By.xpath(locator));
    }



}

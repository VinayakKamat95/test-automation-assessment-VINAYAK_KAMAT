package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PageObject {

    private final WebDriverWait wait;
    protected final WebDriver webDriver;
    protected  final  JavascriptExecutor javascriptExecutor;
    protected final Actions actions;
    protected PageObject(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigService.getInstance().getTimeout()));
        javascriptExecutor = (JavascriptExecutor) webDriver;
        actions = new Actions(webDriver);
    }

    protected void enter(String text, By locator) {
        waitAndGetElement(locator).sendKeys(text);
        final String message = MessageFormat.format("Entered {0} into {1}", locator);
        log(message);
    }

    protected void click(By locator) {
        waitAndGetElement(locator).click();
        final String message = MessageFormat.format("Clicked {0}", locator);
        log(message);
    }

    protected String getText(By locator) {
        final String text = waitAndGetElement(locator).getText();
        final String message = MessageFormat.format("Retrieved {0} by locating {1}", text, locator);
        log(message);
        return text;
    }

    private void log(String message) {
        Reporter.log(message, 1, true);
    }

    private WebElement waitAndGetElement(final By locator) {
        return wait.ignoring(StaleElementReferenceException.class). until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void advanceSelect(By locator, String text) {
        WebElement x=waitAndGetElement(locator);
        forceClick(x);
        x.sendKeys(text,Keys.ENTER,Keys.TAB);
    }

    protected void advanceSelectWithList(By locator, String text, By listLocator) {
        List<WebElement> names = new ArrayList<WebElement>();
        Boolean flag = false;
        WebElement x=waitAndGetElement(locator);
        x.click();
        x.sendKeys(text);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        names = webDriver.findElements(listLocator);
        for (WebElement y : names){
            System.out.println(y.getAttribute("label"));
            if(y.getAttribute("label").equalsIgnoreCase(text)){
                //y.click();
                forceClick(y);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
                break;
            }
        }
       if (!flag){
           Assert.fail("Unable to select Element ");
       }
    }

    protected void forceClick(WebElement Element) {
        javascriptExecutor.executeScript("arguments[0].click();", Element);
    }

    protected void scrollToView() {
        // identify element
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id='rcDialogTitle0']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static String getRandomNumber() {
        // It will generate 3 digit random Number.
        // from 0 to 999
        Random rnd = new Random();
        int number = rnd.nextInt(999);
        // this will convert any number sequence into 3 character.
        return String.format("%03d", number);
    }
}

package utils;

import org.openqa.selenium.WebDriver;
import common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait extends PageBase {
    public Wait(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait explicitWait(int Time) {
        return new WebDriverWait(driver, Duration.ofSeconds(Time));
    }

    public Wait waitVisibilityOfElements(By element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(element)));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitInVisibilityOfElements(By element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(element)));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitVisibilityOfElement(By element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitInVisibilityOfElement(By element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitFrameToBeAvailableAndSwitchToIt(By frameLocator, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitStalenessOfElement(By locator, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitToBeClickableElement(By element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitToBeClickableElementAndClick(By element, int time) {
        WebDriverWait wait = explicitWait(time);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitPresenceOfElement(By element, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitPageLoadComplete(int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitElementChangeToText(By element, String text, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.textToBe(element, text));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitUntilInvisibilitySpecificClass(By element, String className, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.attributeContains(element, "class", className)
            ));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }

    public Wait waitUntilVisibilitySpecificClass(By element, String className, int Time) {
        WebDriverWait wait = explicitWait(Time);
        try {
            wait.until(ExpectedConditions.attributeContains(element, "class", className));
        } catch (NoSuchElementException | TimeoutException exception) {
            System.out.println(exception.getMessage());
        }
        return this;
    }
}
package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTexField(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

    public void fillTextField(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void selectDropdownByIndex(By dropdown, int index) {
        WebElement dropDownElement = driver.findElement(dropdown);
        Select select = new Select(dropDownElement);
        select.selectByIndex(index);
    }

    public void selectDropdownByText(By dropdown, String visibleText) {
        WebElement dropDownElement = driver.findElement(dropdown);
        Select select = new Select(dropDownElement);
        select.selectByVisibleText(visibleText);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void assertElementEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isEnabled());
    }

    public void assertElementDisabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isEnabled());
    }

    public void assertElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed());
    }

    public void assertElementNotVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            Assert.assertFalse(element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    public void assertElementText(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertElementContainsText(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    public void switchToIframe(By locator) {
        try {
            WebElement iframeElement = driver.findElement(locator);
            driver.switchTo().frame(iframeElement);
        } catch (NoSuchFrameException e) {
            Assert.fail("Iframe not found");
        }
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void assertPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void assertTrueCondition(boolean condition) {
        Assert.assertTrue(condition);
    }

    public void assertFalseCondition(boolean condition) {
        Assert.assertFalse(condition);
    }

    public void assertCurrentUrl(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void assertCurrentUrlContains(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl),
                "Expected URL to contain: " + expectedUrl + " but was: " + actualUrl);
    }
}
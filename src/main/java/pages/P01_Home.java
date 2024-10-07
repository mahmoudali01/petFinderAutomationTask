package pages;

import common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

import static utils.JsonReader.jsonRead;

public class P01_Home extends PageBase {
    private final By profileIcon = By.xpath("//button[contains(@class,'p-4 ptw-h-[48px]')]");
    private final By signInButton = By.cssSelector("button[aria-label='sign in']");
    private final By signInDialog = By.cssSelector("div[id='radix-:r0:']");
    private final By dialogBrandLogo = By.cssSelector("img[alt='brand logo']");
    private final By signInDialogHeaderMessage = By.cssSelector("h1.ptw-text-title-sm.ptw-font-extrabold");
    private final By signInDialogHeaderImage = By.cssSelector("img[alt='header image']");
    private final By signInDialogDisclaimerMessage = By.className("ptw-ml-3");
    private final By signInDialogDisclaimerImage = By.cssSelector("img[src='/next-images/icon-purina-badge.svg']");
    private final By signInDialogContinueWithMessage = By.cssSelector("div.ptw-mx-4.ptw-flex-shrink");
    private final By signInDialogContinueWithGoogleButton = By.cssSelector("div.ptw-grid.ptw-gap-2 button:nth-of-type(1)");
    private final By signInDialogContinueWithAppleButton = By.cssSelector("div.ptw-grid.ptw-gap-2 button:nth-of-type(2)");
    private final By signInDialogContinueWithFaceBookButton = By.cssSelector("div.ptw-grid.ptw-gap-2 button:nth-of-type(3)");
    private final By dialogCreateAccountPageRedirectionButton = By.xpath("(//button[contains(@class,'ptw-w-full ptw-cursor-pointer')])[1]");
    private final By dialogLoginPageRedirectionButton = By.xpath("(//button[contains(@class,'ptw-w-full ptw-cursor-pointer')])[2]");
    private final By closeSignInDialogButton = By.xpath("//button[contains(@class, 'ptw-absolute') and @aria-label='Close']");
    private String homePageFileName = "Home.json";
    Wait wait = new Wait(driver);

    public P01_Home(WebDriver driver) {
        super(driver);
    }

    public P01_Home navigateToHomePage() {
        navigateToURL(jsonRead("url", homePageFileName));
        return this;
    }

    public P01_Home clickSignInButton() {
        wait.waitVisibilityOfElement(signInButton, 30);
        clickElement(signInButton);
        wait.waitVisibilityOfElement(signInDialogHeaderImage, 30);
        return this;
    }

    public P01_Home clickSignInDialogCreateAccountButton() {
        clickElement(dialogCreateAccountPageRedirectionButton);
        return this;
    }

    public P01_Home clickSignInDialogLoginButton() {
        clickElement(dialogLoginPageRedirectionButton);
        return this;
    }

    public P01_Home clickSignInDialogCloseButton() {
        clickElement(closeSignInDialogButton);
        wait.waitInVisibilityOfElement(signInDialog, 30);
        return this;
    }

    public P01_Home assertHomePageUrl() {
        assertCurrentUrl(jsonRead("url", homePageFileName));
        return this;
    }

    public P01_Home assertHomePageTitle() {
        assertPageTitle(jsonRead("pageTitle", homePageFileName));
        return this;
    }

    public P01_Home assertHomePageSignInButtonText() {
        assertElementText(signInButton, jsonRead("signInButtonText", homePageFileName));
        return this;
    }

    public P01_Home assertSignInDialogHeaderMessageText() {
        assertElementText(signInDialogHeaderMessage, jsonRead("signInDialogHeaderMessage", homePageFileName));
        return this;
    }

    public P01_Home assertSignInDialogDisclaimerMessageText() {
        assertElementText(signInDialogDisclaimerMessage, jsonRead("signInDialogDisclaimerMessage", homePageFileName));
        return this;
    }

    public P01_Home assertSignInDialogContinueWithMessageText() {
        assertElementText(signInDialogContinueWithMessage, jsonRead("signInDialogContinueWithMessage", homePageFileName));
        return this;
    }

    public P01_Home assertDialogLoginPageRedirectionButtonText() {
        assertElementText(dialogLoginPageRedirectionButton, jsonRead("dialogLoginPageRedirectionButtonText", homePageFileName));
        return this;
    }

    public P01_Home assertDialogCreateAccountPageRedirectionButtonText() {
        assertElementText(dialogCreateAccountPageRedirectionButton, jsonRead("dialogCreateAccountPageRedirectionButtonText", homePageFileName));
        return this;
    }

    public P01_Home assertVisibilityOfSignInDialog() {
        assertElementVisible(signInDialog);
        return this;
    }

    public P01_Home assertInVisibilityOfSignInDialog() {
        assertElementNotVisible(signInDialog);
        return this;
    }

    public P01_Home assertVisibilityOfSignInDialogBrandLogo() {
        assertElementVisible(dialogBrandLogo);
        return this;
    }

    public P01_Home assertVisibilityOfSignInDialogHeaderImage() {
        assertElementVisible(signInDialogHeaderImage);
        return this;
    }

    public P01_Home assertVisibilityOfSignInDialogDisclaimerImage() {
        assertElementVisible(signInDialogDisclaimerImage);
        return this;
    }

    public P01_Home assertVisibilityOfContinueWithGoogleButton() {
        assertElementVisible(signInDialogContinueWithGoogleButton);
        return this;
    }

    public P01_Home assertVisibilityOfContinueWithFacebookButton() {
        assertElementVisible(signInDialogContinueWithFaceBookButton);
        return this;
    }

    public P01_Home assertVisibilityOfContinueWithAppleButton() {
        assertElementVisible(signInDialogContinueWithAppleButton);
        return this;
    }

    public P01_Home assertVisibilityOfProfileIcon() {
        wait.waitVisibilityOfElement(profileIcon, 30);
        assertElementVisible(profileIcon);
        return this;
    }
}
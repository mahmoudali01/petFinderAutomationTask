package pages;

import common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

import static utils.JsonReader.jsonRead;
import static utils.MethodsGenerator.generateRandomFirstName;
import static utils.MethodsGenerator.generateRandomPassword;

public class P02_Login extends PageBase {
    private final By signInFormBanner = By.xpath("(//img[@class='logo-customizable'])[2]");
    private final By signInWithSocialAccountsLabel = By.cssSelector(".panel.panel-right-border.col-md-6.col-lg-6 span.idpDescription-customizable");
    private final By continueWithAppleButton = By.xpath("(//button[@name='appleSignUpButton'])[2]");
    private final By continueWithGoogleButton = By.xpath("(//button[@name='googleSignUpButton'])[2]");
    private final By continueWithFacebookButton = By.xpath("(//button[@name='facebookSignUpButton'])[2]");
    private final By postToAccountDisclaimerMessage = By.xpath("(//span[@class='legalText-customizable'])[2]");
    private final By signInWithEmailOrPhoneNumberMessage = By.xpath("(//span[@class='textDescription-customizable '])[2]");
    private final By emailField = By.xpath("(//input[@id='signInFormUsername'])[2]");
    private final By passwordField = By.xpath("(//input[@id='signInFormPassword'])[2]");
    private final By forgetPasswordLink = By.xpath("(//a[@class='redirect-customizable'])[2]");
    private final By signInButton = By.xpath("(//input[@name='signInSubmitButton'])[2]");
    private final By needAnAccountLabel = By.xpath("(//p[@class='redirect-customizable']//span)[2]");
    private final By signUpButton = By.xpath("(//p[@class='redirect-customizable']//a)[2]");
    private final By userDoesNotExistMessage = By.xpath("(//p[@id='loginErrorMessage'])[2]");
    private final By forgetPasswordMessageHeader = By.tagName("h1");
    private final By forgetPasswordDialog = By.xpath("(//div[@class='modal-body']//div)[2]");
    private String loginFileName = "Login.json";
    Wait wait = new Wait(driver);

    public P02_Login(WebDriver driver) {
        super(driver);
    }

    public P02_Login fillInvalidEmailField() {
        wait.waitVisibilityOfElement(emailField, 30);
        fillTextField(emailField, generateRandomFirstName());
        return this;
    }

    public P02_Login fillRandomPasswordField() {
        fillTextField(passwordField, generateRandomPassword(6));
        return this;
    }

    public P02_Login fillValidEmailField() {
        fillTextField(emailField, jsonRead("validEmail", loginFileName));
        return this;
    }

    public P02_Login fillValidPasswordField() {
        fillTextField(passwordField, jsonRead("validPassword", loginFileName));
        return this;
    }

    public P02_Login clickOnSignInButton() {
        clickElement(signInButton);
        return this;
    }

    public P02_Login clickOnSignUpButton() {
        clickElement(signUpButton);
        return this;
    }

    public P02_Login clickOnForgetPasswordLink() {
        clickElement(forgetPasswordLink);
        return this;
    }

    public P02_Login assertSignInPageUrl() {
        wait.waitVisibilityOfElement(signInFormBanner, 30);
        assertCurrentUrlContains(jsonRead("url", loginFileName));
        return this;
    }

    public P02_Login assertSignInPageTitle() {
        assertPageTitle(jsonRead("pageTitle", loginFileName));
        return this;
    }

    public P02_Login assertNeedAnAccountLabelText() {
        assertElementContainsText(needAnAccountLabel, jsonRead("needAccountLabelText", loginFileName));
        return this;
    }

    public P02_Login assertSignInWithSocialAccountsLabelText() {
        assertElementText(signInWithSocialAccountsLabel, jsonRead("signInWithSocialAccountsMessageText", loginFileName));
        return this;
    }

    public P02_Login assertSignInWithEmailOrPhoneNumberMessageText() {
        assertElementText(signInWithEmailOrPhoneNumberMessage, jsonRead("signInWithEmailOrPhoneNumberMessageText", loginFileName));
        return this;
    }

    public P02_Login assertPostToAccountDisclaimerMessageText() {
        assertElementText(postToAccountDisclaimerMessage, jsonRead("wontPostDisclaimerMessage", loginFileName));
        return this;
    }

    public P02_Login assertUserDoesNotExistMessageText() {
        assertElementText(userDoesNotExistMessage, jsonRead("userDoesNotExistError", loginFileName));
        return this;
    }

    public P02_Login assertContinueWithGoogleButtonText() {
        assertElementText(continueWithGoogleButton, jsonRead("continueWithGoogleButtonText", loginFileName));
        return this;
    }

    public P02_Login assertContinueWithAppleButtonText() {
        assertElementText(continueWithAppleButton, jsonRead("continueWithAppleButtonText", loginFileName));
        return this;
    }

    public P02_Login assertContinueWithFacebookButtonText() {
        assertElementText(continueWithFacebookButton, jsonRead("continueWithFacebookButtonText", loginFileName));
        return this;
    }

    public P02_Login assertSignInButtonText() {
        wait.waitVisibilityOfElement(signInButton, 30);
        assertElementText(signInButton, jsonRead("signInButtonText", loginFileName));
        return this;
    }

    public P02_Login assertSignUpLinkText() {
        assertElementText(signUpButton, jsonRead("signUpButtonText", loginFileName));
        return this;
    }

    public P02_Login assertForgetPasswordMessageHeaderText() {
        assertElementText(forgetPasswordMessageHeader, jsonRead("forgetPasswordHeaderMessage", loginFileName));
        return this;
    }

    public P02_Login assertVisibilityOfSignInFormBanner() {
        assertElementVisible(signInFormBanner);
        return this;
    }

    public P02_Login assertVisibilityOfEmailField() {
        assertElementVisible(emailField);
        return this;
    }

    public P02_Login assertVisibilityOfPasswordField() {
        assertElementVisible(passwordField);
        return this;
    }

    public P02_Login assertVisibilityOfForgetPasswordDisalog() {
        assertElementVisible(forgetPasswordDialog);
        return this;
    }
}
package pages;

import common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

import static utils.JsonReader.jsonRead;
import static utils.MethodsGenerator.*;

public class P03_SignUp extends PageBase {
    private final By headerBoldMessage = By.tagName("h1");
    private final By registrationFormHeaderMessage = By.className("pds-text-surface-textSubdued");
    private final By emailAddressLabel = By.tagName("label");
    private final By emailField = By.id("emailAddress");
    private final By errorMessage = By.className("error-text");
    private final By continueButton = By.cssSelector("form button[type='submit']");
    private final By continueWithGoogleButton = By.xpath("(//button[contains(@class,'pds-gap-2 pds-rounded')])[2]");
    private final By continueWithAppleButton = By.xpath("(//button[contains(@class,'pds-gap-2 pds-rounded')])[3]");
    private final By continueWithFacebookButton = By.xpath("(//button[contains(@class,'pds-gap-2 pds-rounded')])[4]");
    private final By alreadyHaveAnAccount = By.xpath("//div[@class='pds-flex pds-justify-center']//p[1]");
    private final By loginLink = By.xpath("//button[contains(@class,'pds-relative pds-ml-3')]");
    private final By signUpImage = By.xpath("//img[@alt='img']");
    private final By backToHomeButton = By.xpath("//span[contains(@class,'pds-hidden pds-font-medium')]");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By zipPostalCodeField = By.id("postalCode");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By termsAndConditionsCheckBox = By.id("terms");

    private By requiredValidationMessage(String requiredValidation) {
        return By.xpath(String.format("//span[text()='%s']", requiredValidation));
    }

    private String registerFileName = "SignUp.json";
    Wait wait = new Wait(driver);

    public P03_SignUp(WebDriver driver) {
        super(driver);
    }

    public P03_SignUp fillEmailTextField(String email) {
        fillTextField(emailField, email);
        return this;
    }

    public P03_SignUp fillEmailTextFieldWithValidEmail() {
        fillTextField(emailField, generateRandomEmail());
        return this;
    }

    public P03_SignUp fillFirstNameField() {
        fillTextField(firstNameField, generateRandomFirstName());
        return this;
    }

    public P03_SignUp fillLastNameField() {
        fillTextField(lastNameField, generateRandomLastName());
        return this;
    }

    public P03_SignUp fillPostalCodeField() {
        fillTextField(zipPostalCodeField, generateRandomPostalCode());
        return this;
    }

    public P03_SignUp fillInvalidPostalCodeField() {
        fillTextField(zipPostalCodeField, generateRandomLastName());
        return this;
    }

    public P03_SignUp fillPasswordAndConfirmPasswordsFields() {
        String password = generateRandomPassword(6);
        fillTextField(passwordField, password);
        fillTextField(confirmPasswordField, password);
        return this;
    }

    public P03_SignUp clearFirstNameField() {
        clearTexField(firstNameField);
        return this;
    }

    public P03_SignUp clearLastNameField() {
        clearTexField(lastNameField);
        return this;
    }

    public P03_SignUp clearPostalCodeField() {
        clearTexField(zipPostalCodeField);
        return this;
    }

    public P03_SignUp clickOnContinueButton() {
        clickElement(continueButton);
        return this;
    }

    public P03_SignUp clickOnLoginLink() {
        wait.waitVisibilityOfElement(loginLink, 30);
        clickElement(loginLink);
        return this;
    }

    public P03_SignUp clickOnTermAndConditionsCheckbox() {
        clickElement(termsAndConditionsCheckBox);
        return this;
    }

    public P03_SignUp assertSignUpPageUrl() {
        wait.waitVisibilityOfElement(signUpImage, 30);
        assertCurrentUrlContains(jsonRead("url", registerFileName));
        return this;
    }

    public P03_SignUp assertSignUpPageTitle() {
        assertPageTitle(jsonRead("pageTitle", registerFileName));
        return this;
    }

    public P03_SignUp assertGetStartedLabelText() {
        assertElementText(headerBoldMessage, jsonRead("getStartedBoldMessageText", registerFileName));
        return this;
    }

    public P03_SignUp assertVerifyEmailMessageText() {
        assertElementText(headerBoldMessage, jsonRead("verifyEmailHeaderMessage", registerFileName));
        return this;
    }

    public P03_SignUp assertRegistrationFormHeaderMessageText() {
        assertElementText(registrationFormHeaderMessage, jsonRead("headerMessageText", registerFileName));
        return this;
    }

    public P03_SignUp assertBackToHomeButtonText() {
        assertElementText(backToHomeButton, jsonRead("backToHomeButtonText", registerFileName));
        return this;
    }

    public P03_SignUp assertEmailAddressLabelText() {
        assertElementText(emailAddressLabel, jsonRead("emailFieldLabelText", registerFileName));
        return this;
    }

    public P03_SignUp assertAlreadyHaveAccountText() {
        assertElementContainsText(alreadyHaveAnAccount, jsonRead("alreadyHaveAccountMessageText", registerFileName));
        return this;
    }

    public P03_SignUp assertLoginLinkText() {
        assertElementText(loginLink, jsonRead("loginLinkText", registerFileName));
        return this;
    }

    public P03_SignUp assertContinueWithGoogleButtonText() {
        assertElementText(continueWithGoogleButton, jsonRead("continueWithGoogleButtonText", registerFileName));
        return this;
    }

    public P03_SignUp assertContinueWithAppleButtonText() {
        assertElementText(continueWithAppleButton, jsonRead("continueWithAppleButtonText", registerFileName));
        return this;
    }

    public P03_SignUp assertContinueWithFacebookButtonText() {
        assertElementText(continueWithFacebookButton, jsonRead("continueWithFacebookButtonText", registerFileName));
        return this;
    }

    public P03_SignUp assertContinueButtonText() {
        assertElementText(continueButton, jsonRead("continueButtonText", registerFileName));
        return this;
    }

    public P03_SignUp assertEmailValidation(String validation) {
        assertElementText(errorMessage, validation);
        return this;
    }

    public P03_SignUp assertInvalidPostalCode() {
        assertElementText(errorMessage, jsonRead("invalidPostalCodeValidation", registerFileName));
        return this;
    }

    public P03_SignUp assertContinueButtonIsEnabled() {
        assertElementEnabled(continueButton);
        return this;
    }

    public P03_SignUp assertContinueButtonIsDisabled() {
        assertElementDisabled(continueButton);
        return this;
    }

    public P03_SignUp assertVisibilityOfEmailField() {
        assertElementVisible(emailField);
        return this;
    }

    public P03_SignUp assertVisibilityOfSignUpImage() {
        assertElementVisible(signUpImage);
        return this;
    }

    public P03_SignUp assertVisibilityOfFirstNameRequired() {
        assertElementVisible(requiredValidationMessage(jsonRead("firstNameRequiredMessage", registerFileName)));
        return this;
    }

    public P03_SignUp assertVisibilityOfLastNameRequired() {
        assertElementVisible(requiredValidationMessage(jsonRead("lastNameRequiredMessage", registerFileName)));
        return this;
    }

    public P03_SignUp assertVisibilityOfPostalCodeRequired() {
        assertElementVisible(requiredValidationMessage(jsonRead("postalCodeRequiredMessage", registerFileName)));
        return this;
    }
}
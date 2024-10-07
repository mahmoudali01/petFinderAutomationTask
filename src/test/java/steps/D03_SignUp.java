package steps;

import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.P03_SignUp;

public class D03_SignUp {
    P03_SignUp signUpPage = new P03_SignUp(Hooks.driver);

    @Then("the user get redirect to sign up page with correct design and text")
    public void userRedirectedToSignUpPage() {
        signUpPage.assertSignUpPageUrl()
                .assertSignUpPageTitle()
                .assertGetStartedLabelText()
                .assertRegistrationFormHeaderMessageText()
                .assertVisibilityOfEmailField()
                .assertContinueButtonText()
                .assertContinueButtonIsDisabled()
                .assertEmailAddressLabelText()
                .assertAlreadyHaveAccountText()
                .assertLoginLinkText()
                .assertContinueWithGoogleButtonText()
                .assertContinueWithAppleButtonText()
                .assertContinueWithFacebookButtonText()
                .assertVisibilityOfSignUpImage();
    }

    @And("the user clicks Continue button")
    public void clickContinueButton() {
        signUpPage.assertContinueButtonIsEnabled().clickOnContinueButton();
    }

    @And("the user fills the Email field with {string}")
    public void fillSignupEmailField(String email) {
        signUpPage.fillEmailTextField(email);
    }

    @And("the user fills the Email field with valid email")
    public void fillSignupEmailField() {
        signUpPage.fillEmailTextFieldWithValidEmail();
    }

    @Then("Validation message {string} is Displayed")
    public void signupEmailValidationMessageIsDisplayed(String validation) {
        signUpPage.assertEmailValidation(validation);
    }

    @And("the user fills tell us about your self form with valid data")
    public void fillTellUsAboutYourSelfFormWithValidData() {
        signUpPage.fillFirstNameField()
                .fillLastNameField()
                .fillPostalCodeField()
                .selectRandomNumberOfDogs()
                .selectRandomNumberOfCats();
    }

    @And("the user fills first name last name and invalid postal code")
    public void fillFirstNameLastNameAndInvalidPostalCode() {
        signUpPage.fillFirstNameField()
                .fillLastNameField()
                .fillInvalidPostalCodeField();
    }

    @And("the user clears first name last name and postal code")
    public void clearFirstNameLastNameAndPostalCode() {
        signUpPage.clearFirstNameField()
                .clearLastNameField()
                .clearPostalCodeField();
    }

    @Then("required fields validation message are displayed")
    public void requiredValidationMessagesAreDisplayed() {
        signUpPage.assertVisibilityOfFirstNameRequired()
                .assertVisibilityOfLastNameRequired()
                .assertVisibilityOfPostalCodeRequired();
    }

    @Then("invalid postal code validation is displayed")
    public void invalidPostalCodeValidationIsDisplayed() {
        signUpPage.assertInvalidPostalCode();
    }

    @And("the user enters password confirm password and check terms and conditions")
    public void fillPasswordConfirmPasswordAndCheckTermsAndConditions() {
        signUpPage.fillPasswordAndConfirmPasswordsFields()
                .clickOnTermAndConditionsCheckbox();
    }

    @Then("verify email message should be displayed")
    public void verifyEmailMessageIsDisplayed() {
        signUpPage.assertVerifyEmailMessageText();
    }

    @And("the user clicks sign in link")
    public void clickSignInLink() {
        signUpPage.clickOnLoginLink();
    }
}
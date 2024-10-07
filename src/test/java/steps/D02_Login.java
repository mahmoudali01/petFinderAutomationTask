package steps;

import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.P02_Login;

public class D02_Login {
    P02_Login loginPage = new P02_Login(Hooks.driver);

    @Then("the user get redirect to login page with correct design and text")
    public void userRedirectedToLoginPageWithCorrectDesignAndText() {
        loginPage.assertSignInPageUrl()
                .assertSignInPageTitle()
                .assertVisibilityOfSignInFormBanner()
                .assertSignInWithSocialAccountsLabelText()
                .assertContinueWithAppleButtonText()
                .assertContinueWithFacebookButtonText()
                .assertContinueWithGoogleButtonText()
                .assertPostToAccountDisclaimerMessageText()
                .assertSignInWithEmailOrPhoneNumberMessageText()
                .assertVisibilityOfEmailField()
                .assertVisibilityOfPasswordField()
                .assertNeedAnAccountLabelText()
                .assertSignUpLinkText();
    }

    @And("the user fills invalid email and password fields")
    public void fillEmailAndPassword() {
        loginPage.fillInvalidEmailField()
                .fillRandomPasswordField();
    }

    @And("the user clicks sign in button")
    public void clickSignInButton() {
        loginPage.clickOnSignInButton();
    }

    @And("the user clicks sign up link")
    public void clickSignUpButton() {
        loginPage.clickOnSignUpButton();
    }

    @Then("user does not exist validation is displayed")
    public void userDoesNotExistValidation() {
        loginPage.assertUserDoesNotExistMessageText();
    }

    @When("the user clicks forget password link")
    public void clickForgetPasswordLink() {
        loginPage.clickOnForgetPasswordLink();
    }

    @Then("the user get redirect to reset password page")
    public void redirectedToForgetPasswordPage() {
        loginPage.assertVisibilityOfForgetPasswordDisalog()
                .assertForgetPasswordMessageHeaderText();
    }

    @When("the user fills valid credentials")
    public void fillValidCredentials() {
        loginPage.fillValidEmailField()
                .fillValidPasswordField();
    }
}
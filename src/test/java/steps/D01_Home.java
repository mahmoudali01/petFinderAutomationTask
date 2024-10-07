package steps;

import connector.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.P01_Home;

public class D01_Home {
    P01_Home homePage = new P01_Home(Hooks.driver);

    @Given("the user is on the home page")
    public void userIsInHomePage() {
        homePage.navigateToHomePage()
                .assertHomePageUrl()
                .assertHomePageTitle();
    }

    @And("the user clicks the Sign In button")
    public void clickHomePageSignInButton() {
        homePage.assertHomePageSignInButtonText().clickSignInButton();
    }

    @And("the user click the sign in dialog close button")
    public void clickSignInDialogCloseButton() {
        homePage.clickSignInDialogCloseButton();
    }

    @Then("the Sign In dialog should be displayed with the correct design and text")
    public void signInDialogCorrectDesignAndText() {
        homePage.assertVisibilityOfSignInDialog()
                .assertVisibilityOfSignInDialogBrandLogo()
                .assertSignInDialogHeaderMessageText()
                .assertVisibilityOfSignInDialogHeaderImage()
                .assertSignInDialogDisclaimerMessageText()
                .assertVisibilityOfSignInDialogDisclaimerImage()
                .assertDialogCreateAccountPageRedirectionButtonText()
                .assertDialogLoginPageRedirectionButtonText()
                .assertSignInDialogContinueWithMessageText()
                .assertVisibilityOfContinueWithGoogleButton()
                .assertVisibilityOfContinueWithFacebookButton()
                .assertVisibilityOfContinueWithAppleButton();
    }

    @Then("the dialog should not be displayed")
    public void signInDialogShouldNotBeDisplayed() {
        homePage.assertInVisibilityOfSignInDialog();
    }

    @And("the user clicks the login button")
    public void clickLogInButton() {
        homePage.clickSignInDialogLoginButton();
    }

    @And("the user clicks the create account button")
    public void clickCreateAccountButton() {
        homePage.clickSignInDialogCreateAccountButton();
    }

    @Then("the user gets redirected to his profile")
    public void userRedirectedToPersonalProfile() {
        homePage.assertVisibilityOfProfileIcon();
    }
}
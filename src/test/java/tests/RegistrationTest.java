package tests;

import config.TestBase;
import org.junit.Test;
import pages.Home;

public class RegistrationTest extends TestBase {

    @Test
    public void userShouldSuccessfullyRegister() {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithValidData()
                .userShouldBeSuccessfullyRegistered();
    }

    @Test
    public void registrationWithInvalidDataShouldFail() {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithInvalidData()
                .userShouldSeeRegistrationFormAlert();
    }
}

package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Home;

public class RegistrationTest extends TestConfig {

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

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;

import static utility.Screenshot.captureScreenshot;

public class SignIn extends Base {

    public SignIn() {
        super();
    }

    private DataFaker faker = new DataFaker();

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    private void fillInCreateAccountForm(boolean validForm) {
        emailInput.sendKeys(faker.getFakeEmail());
    }

    @Step
    public SignUp submitCreateAccountFormWithValidEmail() {
        fillInCreateAccountForm(true);
        captureScreenshot();
        createAccountButton.click();
        return new SignUp();
    }

    @Step
    public SignIn submitCreateAccountFormWithoutEmail() {
        createAccountButton.click();
        return this;
    }
}

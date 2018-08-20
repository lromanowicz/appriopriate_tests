package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class Home extends Base {

    public Home() {
        super();
    }

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement signInButton;

    @Step
    public SignIn openSignInPage() {
        signInButton.click();
        captureScreenshot();
        return new SignIn();
    }
}

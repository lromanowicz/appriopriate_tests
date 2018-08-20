package pages;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;

import java.util.ArrayList;
import java.util.List;

import static utility.Screenshot.captureScreenshot;

public class SignUp extends BasePage {

    public SignUp() {
        super();
    }

    private DataFaker faker = new DataFaker();

    @FindBy(id = "id_gender1")
    private WebElement maleTitleRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement birthdayDaySelect;

    @FindBy(id = "months")
    private WebElement birthdatMonthSelect;

    @FindBy(id = "years")
    private WebElement birthdayYearSelect;

    @FindBy(id = "address1")
    private WebElement addressLineInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumberInput;

    @FindBy(id = "submitAccount")
    private WebElement submitFormBtn;

    @FindAll(@FindBy(css = "#center_column > .alert li"))
    private List<WebElement> alertMessageContent;

    private void fillInRegistrationForm(boolean validForm) {
        maleTitleRadioBtn.click();
        if (validForm) {
            customerFirstnameInput.sendKeys(faker.getFakeFirstname());
        }
        customerLastnameInput.sendKeys(faker.getFakeLastname());
        passwordInput.sendKeys(faker.getFakePassword());
        new Select(birthdayDaySelect).selectByValue("4");
        new Select(birthdatMonthSelect).selectByValue("10");
        new Select(birthdayYearSelect).selectByValue("1990");
        addressLineInput.sendKeys(faker.getFakeStreet());
        cityInput.sendKeys(faker.getFakeCity());
        new Select(stateSelect).selectByValue("4");
        zipCodeInput.sendKeys("11234");
        phoneNumberInput.sendKeys(faker.getFakeMobilePhone());
    }

    @Step
    public Profile submitFormWithValidData() {
        fillInRegistrationForm(true);
        captureScreenshot();
        submitFormBtn.click();
        return new Profile();
    }

    @Step
    public SignUp submitFormWithInvalidData() {
        fillInRegistrationForm(false);
        captureScreenshot();
        submitFormBtn.click();
        return this;
    }

    @Step
    public void userShouldSeeRegistrationFormAlert() {
        String EXPECTED_MESSAGE = "firstname is required.";
        Assert.assertThat(getAlertMessageContent(), IsCollectionContaining.hasItem(EXPECTED_MESSAGE));
    }

    private List<String> getAlertMessageContent() {
        List<String> alertMessages = new ArrayList<String>();

        for(WebElement message : alertMessageContent) {
            alertMessages.add(message.getText());
        }
        return alertMessages;
    }

}

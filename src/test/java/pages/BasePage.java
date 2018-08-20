package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.WebDriverSingleton.getInstance;
import static utility.Actions.waitForVisibilityOfElement;

public class BasePage {


    public BasePage() {
        PageFactory.initElements(getInstance(), this);
        waitForVisibilityOfElement(pageContent);
    }

    @FindBy(id = "columns")
    private WebElement pageContent;
}

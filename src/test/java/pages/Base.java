package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverSingleton.getInstance;

public class Base {
    static final int WAIT_TIMEOUT = 10;
    private static WebDriverWait wait = new WebDriverWait(getInstance(), WAIT_TIMEOUT);

    public Base() {
        PageFactory.initElements(getInstance(), this);
        waitForVisibilityOfElement(pageContent);
    }

    @FindBy(id = "columns")
    private WebElement pageContent;

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

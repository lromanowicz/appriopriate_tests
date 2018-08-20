package pages;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static utility.Screenshot.captureScreenshot;

public class Profile extends Base {

    public Profile() {
        super();
    }

    @FindAll(@FindBy(css = ".myaccount-link-list > li"))
    private List<WebElement> profilePageLinks;

    @FindBy(css = "#center_column > h1")
    private WebElement profilePageHeader;

    public List<String> getProfilePageLinks() {
        List<String> links = new ArrayList<String>();
        for(WebElement link : profilePageLinks) {
            links.add(link.getText());
        }
        System.out.println(links);
        return links;
    }

    @Step
    public void userShouldBeSuccessfullyRegistered() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "MY ACCOUNT";
        captureScreenshot();
        Assert.assertThat(profilePageHeaderText, IsEqual.equalTo(expectedHeaderText));
    }
}

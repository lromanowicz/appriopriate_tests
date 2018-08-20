package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

import static config.WebDriverSingleton.getInstance;

public class Screenshot {

    @Attachment(value="Screenshot", type="image/png")
    public static byte[] captureScreenshot() {
        return ((TakesScreenshot) getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}

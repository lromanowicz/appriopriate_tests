package config;
import org.junit.After;
import org.junit.Before;

import static utility.Screenshot.captureScreenshot;

public class TestBase extends BrowserConfig {

    @Before
    public void setUp() {
        openBrowser();
    }

    @After
    public void tearDown() {
        captureScreenshot();
        quitBrowser();
    }
}

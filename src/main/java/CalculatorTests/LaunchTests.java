package CalculatorTests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LaunchTests {
    static ProcessBuilder builder;
    static Process process;

    @BeforeAll
    static void setup() throws IOException {
        builder = new ProcessBuilder("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe").inheritIO();;
        process = builder.start();
    }

    @AfterAll
    static void tearDown() {
        process.destroy();
    }

    @Test
    void CalculatorTest() throws MalformedURLException {
        WindowsDriver CalculatorSession = null;
        WebElement CalculatorResult = null;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

        CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        CalculatorSession.findElementByAccessibilityId("num5Button").click();
        CalculatorSession.findElementByAccessibilityId("plusButton").click();
        CalculatorSession.findElementByAccessibilityId("num9Button").click();
        CalculatorSession.findElementByAccessibilityId("equalButton").click();


        CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
        Assertions.assertTrue(CalculatorResult.getText().contains("14"));

        CalculatorSession.closeApp();
    }
}

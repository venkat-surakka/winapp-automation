package functional;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected static WindowsDriver CalculatorSession = null;
    protected static WebElement CalculatorResult = null;
    protected static ProcessBuilder builder;
    protected static Process process;

    private static boolean winAppDriverStarted = false;
    private static boolean appStarted = false;

    public static void startProcess() {
        System.out.println("Inside test base!!");

        builder = new ProcessBuilder("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe").inheritIO();;
        try {
            if(!winAppDriverStarted)
            {
                process = builder.start();
                winAppDriverStarted = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

        try {
            if(!appStarted)
            {
                CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
                appStarted = true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    protected void clearCalculatorResults() {
        CalculatorSession.findElementByAccessibilityId("CalculatorResults").clear();
    }
}

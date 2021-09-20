package functionalTests.pages;

import io.appium.java_client.pagefactory.WindowsFindBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    WindowsDriver windowsDriver;

    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    WebElement equalsButton;

    public CalculatorPage(WindowsDriver windowsDriver) {
        this.windowsDriver = windowsDriver;
        PageFactory.initElements(windowsDriver, this);
    }

    public void clickEquals() {
        equalsButton.click();
    }
}

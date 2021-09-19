package functional.calculator;

import functional.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.GenericFunctions;

import java.util.List;

import static functional.TestBase.startProcess;

public class XpathTests extends TestBase {
    @BeforeAll
    public static void Setup() {
        startProcess();
    }

    @Test
    void ElementsTest() {
        clearCalculatorResults();

        CalculatorSession.findElementByAccessibilityId("num5Button").click();
        CalculatorSession.findElementByAccessibilityId("plusButton").click();
        CalculatorSession.findElementByAccessibilityId("num9Button").click();
        CalculatorSession.findElementByAccessibilityId("equalButton").click();


//        CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
//        Assertions.assertTrue(CalculatorResult.getText().contains("14"));

        String currentText = GenericFunctions.getCurrentResults(CalculatorSession);
        Assertions.assertTrue(currentText.contains("14"));

        // Similarly for getCellValue it should be
        String cellValue = GenericFunctions.getCellValue(CalculatorSession, 2, 0);
    }
}
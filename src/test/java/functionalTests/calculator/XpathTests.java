package functionalTests.calculator;

import functionalTests.TestBase;
import functionalTests.pages.CalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilities.GenericFunctions;

public class XpathTests extends TestBase {
    private static CalculatorPage calculatorPO;

    @BeforeAll
    public static void Setup() {
        startProcess();
        calculatorPO = new CalculatorPage(CalculatorSession);
    }

    @Test
    void ElementsTest() {
        clearCalculatorResults();

        CalculatorSession.findElementByAccessibilityId("num5Button").click();
        CalculatorSession.findElementByAccessibilityId("plusButton").click();
        CalculatorSession.findElementByAccessibilityId("num9Button").click();
        calculatorPO.clickEquals();

        String currentText = GenericFunctions.getCurrentResults(CalculatorSession);
        Assertions.assertTrue(currentText.contains("14"));
    }
}
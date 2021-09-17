package functional.calculator;

import functional.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LaunchTests extends TestBase {
    @BeforeAll
    public static void Setup() {
        startProcess();
    }

    @Test
    void AdditionTest()
    {
        clearCalculatorResults();

        CalculatorSession.findElementByAccessibilityId("num5Button").click();
        CalculatorSession.findElementByAccessibilityId("plusButton").click();
        CalculatorSession.findElementByAccessibilityId("num9Button").click();
        CalculatorSession.findElementByAccessibilityId("equalButton").click();


        CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
        Assertions.assertTrue(CalculatorResult.getText().contains("14"));
    }

    @Test
    void SubtractionTest()
    {
        clearCalculatorResults();

        CalculatorSession.findElementByAccessibilityId("num9Button").click();
        CalculatorSession.findElementByAccessibilityId("minusButton").click();
        CalculatorSession.findElementByAccessibilityId("num3Button").click();
        CalculatorSession.findElementByAccessibilityId("equalButton").click();


        CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
        Assertions.assertTrue(CalculatorResult.getText().contains("6"));
    }
}

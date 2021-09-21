package sanityTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static sanityTests.TestDataSetup.process;

@ExtendWith(TestDataSetup.class)
public class SanityTestSuite {
    @Test
    void passTest() {
        Assertions.assertTrue(true);

        System.out.println("Process status: " + process.isAlive());
    }

    @Test
    void failTest() {
        Assertions.assertTrue(false);
    }
}

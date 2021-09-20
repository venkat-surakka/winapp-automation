package sanityTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SanityTestSuite {
    @Test
    void passTest() {
        Assertions.assertTrue(true);;
    }

    @Test
    void failTest() {
        Assertions.assertTrue(false);
    }
}

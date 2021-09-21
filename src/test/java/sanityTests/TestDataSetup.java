package sanityTests;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestDataSetup implements BeforeAllCallback, AfterAllCallback, ExtensionContext.Store.CloseableResource {
    private static boolean isStarted = false;
    public static Process process;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("c:\\windows\\system32\\notepad.exe");
        process = builder.start();

        System.out.println("Starting notepad!!!");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        process.destroy();
        System.out.println("Killed notepad!!!");
    }

    @Override
    public void close() throws Throwable {
    }
}

package kata_bank_account;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void testMain() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[0]);

        String output = outContent.toString().trim();
        System.out.println("Captured output:\n" + output);

        String[] expectedLines = {
            "Balance: 13000.00",
            "Deposits: 1",
            "Withdrawals: 1",
            "Annual Interest Rate: 3.00%",
            "Monthly Fee: 0.00",
            "Account Active: Yes",
            "Balance: 3005.00",
            "Deposits: 1",
            "Withdrawals: 1",
            "Annual Interest Rate: 2.00%",
            "Monthly Fee: 0.00"
        };

        for (String expectedLine : expectedLines) {
            assertTrue(output.contains(expectedLine),
                    "Expected output to contain: " + expectedLine + "\nBut was: " + output);
        }
    }
}

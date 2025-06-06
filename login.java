import java.io.IOException;

public class LoginSystem {

    // Custom method to read password from console and display asterisk (*) for each character
    public static String readPasswordMasked() throws IOException {
        StringBuilder password = new StringBuilder();
        // Read characters until Enter (line feed or carriage return)
        while (true) {
            int ch = System.in.read();

            // Enter keys to finish password input
            if (ch == '\r' || ch == '\n') {
                System.out.println(); // Move to next line after user presses Enter
                break;
            }
            // Backspace handling (ASCII 8 or 127)
            if (ch == 8 || ch == 127) {
                if (password.length() > 0) {
                    password.deleteCharAt(password.length() - 1);
                    // Erase the last asterisk from console
                    System.out.print("\b \b");
                }
                continue;
            }
            // Append character to password buffer
            password.append((char) ch);
            // Print asterisk instead of the character
            System.out.print("*");
        }
        return password.toString();
    }

    public static void main(String[] args) throws IOException {
        // Hardcoded correct username and password for demonstration
        String correctUsername = "admin";
        String correctPassword = "password123";

        System.out.println("Welcome to the Login System!");
        // Allow up to 3 login attempts
        for (int tries = 1; tries <= 3; tries++) {
            System.out.print("Enter username: ");
            byte[] inputBytes = new byte[100];
            int readBytes = System.in.read(inputBytes);
            // Read username trimming newline chars
            String username = new String(inputBytes, 0, readBytes).trim();

            System.out.print("Enter password: ");
            String password = readPasswordMasked();

            // Check credentials
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful!");
                return; // Exit upon success
            } else {
                System.out.println("Invalid username or password. Attempts left: " + (3 - tries));
            }
        }
        System.out.println("Too many failed attempts. Access denied.");
    }
}

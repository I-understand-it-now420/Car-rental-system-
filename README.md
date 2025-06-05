# Car-rental-system-
A system that can analyse cars and implement functionalities like car rental 

import java.util.Scanner;
import java.io.Console;

public class LoginSystem {
    // Predefined credentials
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = System.console();
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        boolean loggedIn = false;

        System.out.println("=== Login System ===");

        while (attempts < MAX_ATTEMPTS && !loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            // Using Console for secure password input if available
            char[] passwordChars = null;
            if (console != null) {
                passwordChars = console.readPassword("Enter password: ");
            } else {
                // Fallback for IDEs that don't support Console
                System.out.print("Enter password (characters will be shown as *): ");
                passwordChars = new char[0];
                // Simulate password masking
                String password = scanner.nextLine();
                passwordChars = password.toCharArray();
                // Print backspaces to "mask" the input (works in some terminals)
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b"); // Adjust based on max expected length
                for (int i = 0; i < password.length(); i++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            String password = new String(passwordChars);
            
            // Clear the password from memory
            if (passwordChars != null) {
                java.util.Arrays.fill(passwordChars, ' ');
            }

            // Validate credentials
            if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                loggedIn = true;
                System.out.println("Login successful! Welcome, " + username + ".");
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (!loggedIn) {
            System.out.println("Maximum login attempts reached. System locked.");
        }

        scanner.close();
    }
}
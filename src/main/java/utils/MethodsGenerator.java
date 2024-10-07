package utils;

import com.github.javafaker.Faker;

/**
 * Utility class for generating random data.
 * This class uses the Faker library to generate random email addresses.
 */
public class MethodsGenerator {
    static Faker faker = new Faker();

    /**
     * Generates a random email address.
     *
     * @return A randomly generated email address as a String.
     * The email address is formatted according to standard email conventions.
     * Example output: john.doe@example.com
     */
    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    /**
     * Generates a random first name.
     *
     * @return A randomly generated first name.
     */
    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    /**
     * Generates a random last name.
     *
     * @return A randomly generated last name.
     */
    public static String generateRandomLastName() {
        return faker.name().lastName();
    }

    /**
     * Generates a random postal code.
     *
     * @return A randomly generated postal code.
     */
    public static String generateRandomPostalCode() {
        return faker.address().zipCode();
    }

    /**
     * Generates a random password using Faker with a specified length.
     * The password will contain a mix of characters (uppercase, lowercase, digits, and special characters).
     *
     * @param length the desired length of the password
     * @return a randomly generated password
     * @throws IllegalArgumentException if length is less than 1
     */
    public static String generateRandomPassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Password length must be at least 1.");
        }
        String upperCaseLetters = faker.lorem().characters(2, 5, true, false);  // At least 2 uppercase letters
        String lowerCaseLetters = faker.lorem().characters(2, 5, false, false); // At least 2 lowercase letters
        String digits = faker.numerify("####");  // At least 4 digits
        String specialChars = faker.regexify("[!@#\\$%\\^&\\*]{1,3}");  // At least 1-3 special characters
        String combinedPassword = upperCaseLetters + lowerCaseLetters + digits + specialChars;
        return combinedPassword.substring(0, Math.min(combinedPassword.length(), length));
    }
}

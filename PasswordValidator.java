public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        int uppercaseCount = 0;
        int digitCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
        }

        return uppercaseCount >= 2 && digitCount >= 1;
    }

    public static void main(String[] args) {
        String password1 = "ABcd123"; // Valid
        String password2 = "abcd123"; // Invalid
        String password3 = "Abcd123"; // Invalid

        System.out.println("password1 valid? " + isValidPassword(password1));
        System.out.println("password2 valid? " + isValidPassword(password2));
        System.out.println("password3 valid? " + isValidPassword(password3));
    }
}


public class StringManipulator {
    // Precondition: str.length > 0
    // Postcondition: The characters of the str have been reversed, output the new reversed String
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters at left and right indices
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move indices towards the center
            left++;
            right--;
        }

        // Convert the character array back to a string
        return new String(charArray);
    }

    // Precondition: str.length > 0
    // Postcondition: The sum of the ASCII values for each character in the string aas an integer
    public static int getAsciiSum(String str) {
        int sum = 0;

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Get the Unicode value of the current character
            char currentChar = str.charAt(i);
            int unicodeValue = (int) currentChar;
    
            // Sum up the Unicode values
            sum += unicodeValue;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "a";
        s = reverseString(s);
        int n = getAsciiSum(s);
        System.out.println(n);
    }
}

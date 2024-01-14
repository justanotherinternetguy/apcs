public class LetterFrequency {

    public static void main(String[] args) {
        String inputString = "the quick brown fox jumped over the lazy dog or over Veer";

        inputString = inputString.toLowerCase();

        int[] letterFrequency = new int[26];

        for (char ch : inputString.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letterFrequency[ch - 'a']++;
            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = ch - 'a';
            System.out.println(ch + ": " + letterFrequency[index]);
        }
    }
}
    
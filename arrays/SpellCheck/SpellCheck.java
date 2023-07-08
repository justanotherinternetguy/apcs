import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpellCheck {
  private static final String WORDS_FILE_PATH = "words.txt"; // Path to the file containing the words

  private List<String> words;

  public SpellCheck() {
    words = loadWords();
  }

  public void runSpellChecker() {
    Scanner scanner = new Scanner(System.in);
    String input;

    do {
      System.out.print("Enter a word (or QUIT to exit): ");
      input = scanner.nextLine().trim();

      if (input.equalsIgnoreCase("QUIT")) {
        break;
      }

      if (isWordCorrect(input)) {
        System.out.println("The word is spelled correctly!");
      } else {
        String possibleMatch = findPossibleMatch(input);
        if (possibleMatch != null) {
          System.out.println("Do you mean " + possibleMatch + "?");
        } else {
          System.out.println("No words match.");
        }
      }
    } while (true);

    scanner.close();
  }

  private List<String> loadWords() {
    List<String> words = new ArrayList<>();

    try {
      File file = new File(WORDS_FILE_PATH);
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String word = scanner.nextLine().trim();
        words.add(word);
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return words;
  }

  private boolean isWordCorrect(String word) {
    return words.contains(word);
  }

  private String findPossibleMatch(String input) {
    for (String word : words) {
      if (isSimilarWord(input, word)) {
        return word;
      }
    }

    return null;
  }

  private boolean isSimilarWord(String input, String word) {
    int mismatchCount = 0;
    int lengthDiff = Math.abs(input.length() - word.length());
    int maxLength = Math.max(input.length(), word.length());

    if (lengthDiff > 2) {
      return false; // Words are too different in length
    }

    for (int i = 0, j = 0; i < input.length() && j < word.length(); i++, j++) {
      if (input.charAt(i) != word.charAt(j)) {
        mismatchCount++;

        if (mismatchCount > 2) {
          return false;
        }

        if (input.length() < word.length()) {
          i--; // Skip a character in the longer word
        } else if (input.length() > word.length()) {
          j--; // Skip a character in the longer word
        }
      }
    }

    return mismatchCount == 1;
  }

  public static void main(String[] args) {
    SpellCheck spellChecker = new SpellCheck();
    spellChecker.runSpellChecker();
  }
}

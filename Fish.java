import java.io.*;
import java.util.*;
class Fish {
    public static void main(String[] args) {
        String[] randomStrings = generateRandomStringArray();

	System.out.println("BEFORE");

	for (String str : randomStrings) { //FIRST
            System.out.print(str + ", ");
        }
	System.out.println();

        changeNamesToTuna(randomStrings); // main fun

	System.out.println("AFTER");
        for (String str : randomStrings) {
            System.out.print(str + ", ");
        }
    }

    public static String[] generateRandomStringArray() {
        Random random = new Random();
        int arraySize = random.nextInt(100) + 1;
        String[] randomStrings = new String[arraySize];
        
        for (int i = 0; i < arraySize; i++) {
            int stringLength = random.nextInt(20) + 1;
            StringBuilder stringBuilder = new StringBuilder();
            
            for (int j = 0; j < stringLength; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                stringBuilder.append(randomChar);
            }
            
            randomStrings[i] = stringBuilder.toString();
        }
        
        return randomStrings;
    }

    public static void changeNamesToTuna(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > 10) {
                strings[i] = "Tuna";
            }
        }
    }
}

import java.io.*;
import java.util.*;

class CrayonTime {
	public static void main (String[] args) {
		Random rand = new Random();
		int stringLen = rand.nextInt(1, 15);
		String stringArr[] = new String[stringLen];
		populate(stringArr);
		System.out.println("BEFORE");
		display(stringArr);
		System.out.println("__________");
		System.out.println("AFTER");
		changeFirstLetterToZ(stringArr);
		display(stringArr);
	}

	static void populate(String stringArr[]) {
		Random rand = new Random();
		for (int i = 0; i < stringArr.length; i++) {
			StringBuilder randomString = new StringBuilder();
			for (int j = 0; j < 8; j++) {
			    char randomChar = (char) (rand.nextInt(26) + 'A');
			    randomString.append(randomChar);
			}
			stringArr[i] = randomString.toString();
		}
	}
	static void display(String stringArr[]) {
	    for (int i = 0; i < stringArr.length; i++) {
		System.out.println(stringArr[i]);
	    }
	}
	static void changeFirstLetterToZ(String stringArr[]) {
	    for (int i = 0; i < stringArr.length; i++) {
		if (stringArr[i].length() > 0) {
		    char firstChar = stringArr[i].charAt(0);
		    if (firstChar >= 'P') {
			stringArr[i] = 'Z' + stringArr[i].substring(1);
		    }
		}
	    }
	}
}

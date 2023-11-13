import java.util.*;
import java.io.*;

class UseBase {
  public HashMap<String, Integer> hexMap;
  public UseBase() {
    hexMap = new HashMap<String, Integer>();
    for (int i = 0; i < 10; i++) {
      hexMap.put(Integer.toString(i), i);
    }
    hexMap.put("A", 10);
    hexMap.put("B", 11);
    hexMap.put("C", 12);
    hexMap.put("D", 13);
    hexMap.put("E", 14);
    hexMap.put("F", 15);
  }

  public String add(String num1, String num2, int base) {
    int dec1 = convertToDec(num1, base);
    int dec2 = convertToDec(num2, base);
    int sum = dec1 + dec2;
    return convertFromDec(sum, base);
  }

  public String subtract(String num1, String num2, int base) {
    int dec1 = convertToDec(num1, base);
    int dec2 = convertToDec(num2, base);
    int difference = dec1 - dec2;
    return convertFromDec(difference, base);
  }

  public String multiply(String num1, String num2, int base) {
    int dec1 = convertToDec(num1, base);
    int dec2 = convertToDec(num2, base);
    int product = dec1 * dec2;
    return convertFromDec(product, base);
  }
  
  public String divide(String num1, String num2, int base) {
    int dec1 = convertToDec(num1, base);
    int dec2 = convertToDec(num2, base);
    int quotient = dec1 / dec2;
    return convertFromDec(quotient, base);
  }

  public int convertToDec(String num, int base) {
    int res_dec = 0;
    for (int i = 0; i < num.length(); i++) {
      int temp_dig = hexMap.get(Character.toString(num.charAt(i)));
      res_dec += (temp_dig * Math.pow(base, num.length() - i - 1));
    }
    return res_dec;
  }

  public String convertFromDec(int dec_num, int base) {
    StringBuilder res = new StringBuilder();

    while (dec_num > 0) {
      int remainder = dec_num % base;
      res.insert(0, remainder);
      dec_num /= base;
    }

    return res.toString();
  }

  public static void main(String[] args) {
    UseBase ub = new UseBase();
    System.out.println("0101 to decimal: " + ub.convertToDec("0101", 2));
    System.out.println("2454 to base 16: " + ub.convertFromDec(2454, 16));
    System.out.println(ub.add("0101", "0101", 2));
    System.out.println(ub.subtract("677", "574", 8));
    System.out.println(ub.divide("1AB", "3", 16));
  }
}

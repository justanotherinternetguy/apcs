class PracticeWithBoxing {
  public static void main(String[] args) {
    Integer s = 21;
    Integer z = 35;
    int sum = s + z;
    System.out.println("the sum of s and z is " + sum);
    int c[] = new int[5];

    Integer cc[] = new Integer[5];

    Number n[] = new Number[5];
    n[0] = 34;
    n[1] = 3.14159;
    n[2] = 56;
    n[3] = 1;
    n[4] = 0.1;

    for (Number x : n)
      {
        System.out.println(x);
      }
   
    System.out.println("the number is " + s);
  }
}

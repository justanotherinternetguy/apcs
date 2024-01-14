import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    int L;
    int i = 0;
    BufferedReader r = new BufferedReader(new FileReader("beesetup1.txt"));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    List<String> lines = r.lines().collect(Collectors.toList());

    System.out.println(lines.get(1).split(",")[0]);
    r.close();
  }
}

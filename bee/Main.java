import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.reflect.Array;


public class Main {
  public static void main(String[] args) throws IOException {
    int L;
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Bee> bees = new ArrayList<Bee>();

    BufferedReader r = new BufferedReader(new FileReader("beesetup1.txt"));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    List<String> lines = r.lines().collect(Collectors.toList());

    L = Integer.valueOf(lines.get(0).split(",")[0]);

    for (int i = 1; i < 15 + 1; i++) {
      String t = lines.get(i);
      int x = Integer.valueOf(t.split(",")[0]);
      int y = Integer.valueOf(t.split(",")[1]);
      int z = Integer.valueOf(t.split(",")[2]);

      // push to homeNode
      homeNodes.add(new Node(x, y, z, false, true));
    }

    for (int i = 15 + 1; i < 15 + 15 + 1; i++) {
      String t = lines.get(i);
      int x = Integer.valueOf(t.split(",")[0]);
      int y = Integer.valueOf(t.split(",")[1]);
      int z = Integer.valueOf(t.split(",")[2]);
      // System.out.println(t);
      bees.add(new Bee(x, y, z, false));
    }

    for (int i = 15 + 15 + 1 + 1; i < lines.size(); i++) {
      String t = lines.get(i);
      int x = Integer.valueOf(t.split(",")[0]);
      int y = Integer.valueOf(t.split(",")[1]);
      int z = Integer.valueOf(t.split(",")[2]);
      // System.out.println(t);
      obstacleNodes.add(new Node(x, y, z, true, false));
    }

    r.close();
  }

}

public class Node {
  private int x, y, z;
  private boolean isObstacle, isHome;
  public Node(int x, int y, int z, boolean o, boolean h) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.isObstacle = o;
    this.isHome = h;
  }

  public int getX() {
    return(this.x);
  }
  public int getY() {
    return(this.y);
  }
  public int getZ() {
    return(this.z);
  }
}

public class Bee {
	private int x;
	private int y;
	private int z;
  private boolean atHome;

  private int fx, fy, fz;

	public Bee(int x, int y, int z, boolean atHome) {
		this.x = x;
		this.y = y;
		this.z = z;
    this.atHome = atHome;
	}

  public int moveBee(int tx, int ty, int tz) {
    return 0;
  }

  private void calcFinalPos() {
  }
}

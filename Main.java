import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.reflect.Array;


public class Main {
  public static Node findClosestHomeNode(Bee bee, List<Node> homeNodes) {
    Node closestNode = null;
    double minDistance = Double.MAX_VALUE;

    for (Node homeNode : homeNodes) {
      double distance = bee.getCurrentPosition().calculateDistance(homeNode);

      if (distance < minDistance) {
        minDistance = distance;
        closestNode = homeNode;
      }
    }

    return closestNode;
  }

  public static void main(String[] args) throws IOException {
    int N;

    BufferedReader r = new BufferedReader(new FileReader("beesetup1.txt"));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    List<String> lines = r.lines().collect(Collectors.toList());


    // // System.out.println(lines.get(0));
    // N = Integer.valueOf(lines.get(0).split(",")[0]);
    // System.out.println(N);
    // Bee b1 = new Bee(new Node(1, 1, 1, false));
    // System.out.println(b1.move(new Node(25, 3, 3, false)));
    // System.out.println(b1.toString());

    int gridSize = 25;

    List<List<List<Node>>> hive = new ArrayList<>();
    List<Node> home = new ArrayList<>();
    List<Bee> bees = new ArrayList<Bee>();

    for (int i = 0; i < gridSize; i++) {
      List<List<Node>> layer = new ArrayList<>();
      for (int j = 0; j < gridSize; j++) {
          List<Node> row = new ArrayList<>();
          for (int k = 0; k < gridSize; k++) {
              row.add(new Node(i, j, k, false));
          }
          layer.add(row);
      }
      hive.add(layer);
    }

    for (int i = 1; i < 15 + 1; i++) {
      String line = lines.get(i);
      String[] coordinates = line.split(",");
      int x = Integer.parseInt(coordinates[0]);
      int y = Integer.parseInt(coordinates[1]);
      int z = Integer.parseInt(coordinates[2]);
      home.add(new Node(x, y, z, false));
    }


    for (int i = 15 + 1; i < 15 + 15 + 1; i++) {
      String line = lines.get(i);
      String[] coordinates = line.split(",");
      int x = Integer.parseInt(coordinates[0]);
      int y = Integer.parseInt(coordinates[1]);
      int z = Integer.parseInt(coordinates[2]);
      bees.add(new Bee(new Node(x, y, z, false)));
    }

    for (int i = 15 + 15 + 1 + 1; i < lines.size(); i++) {
      String line = lines.get(i);
      String[] coordinates = line.split(",");
      int x = Integer.parseInt(coordinates[0]);
      int y = Integer.parseInt(coordinates[1]);
      int z = Integer.parseInt(coordinates[2]);
      hive.get(x).get(y).get(z).setObstacle(true);
    }


    Bee b1 = bees.get(0);
    // System.out.println(b1.move(new Node(2, 2, 0, true)));

    // System.out.println(hive.size());
    // System.out.println(hive.get(0).size());
    // System.out.println(hive.get(0).get(0).size());
    // System.out.println(hive.get(0).get(0).get(5).toString());

    // System.out.println(findClosestHomeNode(b1, home));

    Node target = findClosestHomeNode(b1, home);
    System.out.println(target.toString());

    r.close();
  }
}

public class Node implements Comparable<Node> {
  int x;
  int y;
  int z;
  boolean isObstacle;
  int g, h; // cost values
  Node parent;
  
  public Node(int x, int y, int z, boolean isObstacle) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.isObstacle = isObstacle;
    this.g = 0;
    this.h = 0;
    this.parent = null;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setZ(int z) {
    this.z = z;
  }

  public boolean isObstacle() {
    return isObstacle;
  }

  public void setObstacle(boolean isObstacle) {
    this.isObstacle = isObstacle;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ", " + z + ")" + " " + "Is obstacle: " + this.isObstacle;
  }

  public double calculateDistance(Node otherNode) {
    int deltaX = this.x - otherNode.getX();
    int deltaY = this.y - otherNode.getY();
    int deltaZ = this.z - otherNode.getZ();

    return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
  }

  public boolean equals(Node otherNode) {
    return this.x == otherNode.getX() && this.y == otherNode.getY() && this.z == otherNode.getZ();
  }
  public int f() {
    return g + h;
  }

  @Override
  public int compareTo(Node other) {
      return Integer.compare(this.f(), other.f());
  }
}


public class Bee {
  private Node pos;

  public Bee(Node initialPosition) {
    this.pos = initialPosition;
  }

  public Node getCurrentPosition() {
    return pos;
  }

  public boolean move(Node potentialPos) {
    if (isValid(potentialPos)) {
      this.pos.setX(potentialPos.getX());
      this.pos.setY(potentialPos.getY());
      this.pos.setZ(potentialPos.getZ());
      return true;
    }
    return false;
  }

  private boolean isValid(Node potentialPos) {
    int changedCoordinates = 0;

    if (potentialPos.getX() != pos.getX()) {
        changedCoordinates++;
    }

    if (potentialPos.getY() != pos.getY()) {
        changedCoordinates++;
    }

    if (potentialPos.getZ() != pos.getZ()) {
        changedCoordinates++;
    }

    if (changedCoordinates > 2) {
        return false;
    }

    if (potentialPos.isObstacle()) {
      return false;
    }

    return potentialPos.getX() >= 0 && potentialPos.getX() <= 24 &&
           potentialPos.getY() >= 0 && potentialPos.getY() <= 24 &&
           potentialPos.getZ() >= 0 && potentialPos.getZ() <= 24;
  }

  @Override
  public String toString() {
    return "Bee at position: " + pos.toString();
  }
}


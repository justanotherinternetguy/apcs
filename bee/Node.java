public class Node {
  private int x, y, z;
  private boolean isObstacle;
  public Node (int x, int y, int z, boolean o, boolean h) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.isObstacle = o;
    this.isHome = h;
  }
}

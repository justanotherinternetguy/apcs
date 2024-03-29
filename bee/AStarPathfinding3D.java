import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AStarPathfinding3D {
    private static final int[][] DIRECTIONS = {
            {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, // straight
            {1, 1, 0}, {1, -1, 0}, {-1, 1, 0}, {-1, -1, 0}, // diagonal on XY plane
            {0, 1, 1}, {0, -1, 1}, {0, 1, -1}, {0, -1, -1}, // diagonal on XZ plane
            {1, 0, 1}, {-1, 0, 1}, {1, 0, -1}, {-1, 0, -1} // diagonal on YZ plane
    };

    private int[][][] cube;
    private int size;

    public AStarPathfinding3D(int[][][] cube) {
        this.cube = cube;
        this.size = cube.length;
    }

    public AStarPathfinding3D(String obstacleFile, int size) {
        this.size = size;
        this.cube = new int[size][size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    cube[i][j][k] = 0;
                }
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(obstacleFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] coordinates = line.split(",");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                int z = Integer.parseInt(coordinates[2]);
                cube[x][y][z] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Node3D> findPath(Node3D start, Node3D goal) {
        PriorityQueue<Node3D> openSet = new PriorityQueue<>();
        List<Node3D> closedSet = new ArrayList<>();

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node3D current = openSet.poll();

            if (current.x == goal.x && current.y == goal.y && current.z == goal.z) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (int[] dir : DIRECTIONS) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];
                int newZ = current.z + dir[2];

                if (isValid(newX, newY, newZ) && cube[newX][newY][newZ] == 0) {
                    Node3D neighbor = new Node3D(newX, newY, newZ);
                    double tentativeG = current.g + 1.0;

                    if (!closedSet.contains(neighbor) || tentativeG < neighbor.g) {
                        neighbor.g = tentativeG;
                        neighbor.h = calculateHeuristic(neighbor, goal);
                        neighbor.parent = current;

                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }
        }

        return Collections.emptyList();
    }

    private boolean isValid(int x, int y, int z) {
        if (x < 0 || x >= size || y < 0 || y >= size || z < 0 || z >= size) {
            return false;
        }
    
        // Check if the diagonal movement is blocked between two obstacles
        if (x > 0 && y > 0 && cube[x - 1][y][z] == 1 && cube[x][y - 1][z] == 1) {
            return false;
        }
    
        return cube[x][y][z] == 0;
    }

    private double calculateHeuristic(Node3D a, Node3D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
    }

    private List<Node3D> reconstructPath(Node3D node) {
        List<Node3D> path = new ArrayList<>();

        while (node != null) {
            path.add(new Node3D(node.x, node.y, node.z));
            node = node.parent;
        }

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int size = 40;
        int[][][] cube = new int[size][size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    cube[i][j][k] = 0;
                }
            }
        }

        // cube[1][1][1] = 1;
        // cube[1][1][0] = 1;
        // cube[0][1][0] = 1;
        // cube[1][0][0] = 1;
        String obstacleFile = "./beesetup1.txt"; // Replace with your obstacle file path
        AStarPathfinding3D pathfinder = new AStarPathfinding3D(obstacleFile, size);
        // AStarPathfinding3D pathfinder = new AStarPathfinding3D(cube);

        Node3D start = new Node3D(7, 32,24);

        Node3D goal = new Node3D(31,16, 11);

        List<Node3D> path = pathfinder.findPath(start, goal);

        if (!path.isEmpty()) {
            System.out.println("Path found:");
            int pathLength = calculatePathLength(path);
            System.out.println("Path length: " + pathLength);

            for (Node3D node : path) {
                System.out.println("(" + node.x + ", " + node.y + ", " + node.z + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
    private static int calculatePathLength(List<Node3D> path) {
        int pathLength = 0;
    
        for (int i = 0; i < path.size() - 1; i++) {
            Node3D current = path.get(i);
            Node3D next = path.get(i + 1);
    
            // manhattan dist between two nodes
            int distanceX = Math.abs(next.x - current.x);
            int distanceY = Math.abs(next.y - current.y);
            int distanceZ = Math.abs(next.z - current.z);
    
            pathLength += Math.max(Math.max(distanceX, distanceY), distanceZ);
        }
    
        return pathLength;
    }
}

class Node3D implements Comparable<Node3D> {
    int x, y, z; // coordinates
    double g; // cost from start node
    double h; // heuristic value (estimated cost to goal)
    Node3D parent; // parent node

    public Node3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.g = 0.0;
        this.h = 0.0;
        this.parent = null;
    }

    public double f() {
        return g + h;
    }

    @Override
    public int compareTo(Node3D other) {
        return Double.compare(this.f(), other.f());
    }
}

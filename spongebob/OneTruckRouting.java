import java.io.*;
import java.util.*;
import java.util.regex.*;

/*
- 5k feet in a mile
- Street width = 0
- Homes are 100x100 = 10k ft area in total
- 10 homes on each side of a block (each block is 1k feet) (20 homes on each street)
- entire map = 100,000 x 100,000 (40 square miles)
- 500 streets (E/W) that are 200 feet apart (width of 2 homes)
- 100 avenues (N/S) that are 1000 feet apart (width of 10 homes)

for every street: (1, 3, 5, 7...):
- 1, 2
for every avenue: (1, 11, 21, 31...):
1, 2, 3, 4, 5, 6, 7, 8, 9, 10

The houses are numbered A,B,C,D,E,F,G,H,I & J for the west side of the street
AA,BB,CC,DD,EE,FF,GG,HH,II & JJ for the east side of the street.

Each street
- 20 * 100 = 2k houses on each street
BUT
- SC (200x1000 = one full block) (2S x 3A) (300 units)
- PC (one full block) (149S x 33A) (500 units)
- DC (125S x 22A)

Total number of houses = (2000 * 500) - 20 - 20 - 20 = 999940

- Buy truck = 100k
- Rent truck for 10 days = 15k per day
- Fuel = 5 per mile
- Maintenance for BOUGHT trucks = every 100 miles for 1k
- Employee = 30/hour for first 8 hours + 45 for every extra hour
- 30 seconds to travel 1 block
- 1min/30sec to deliver EACH pkg
- If you traverse partway up a street: 3 seconds per house u travel (and 3 seconds back down)
- For SC + PC: 30/15 seconds for each pkg to be delivered
- Sim runs for 10 days

- Total cost calculations
- Bought trucks = 100,000 * boughtTruckCount
- Rental trucks = (15,000 * rentalTruckCount) * daysRented
- Fuel = 5 * totalDistance
- Wages = employeeCount * ((30 * firstHours) + (45 * overtimeHours))

- Total time calculations

 */
class Location {
  int x;
  int y;
  int demand; // The demand of goods for this location

  public Location(int x, int y, int demand) {
    this.x = x;
    this.y = y;
    this.demand = demand;
  }
}


class Vehicle {
  int capacity;
  List<Location> route;

  public Vehicle(int capacity) {
    this.capacity = capacity;
    this.route = new ArrayList<>();
  }
}

public class OneTruckRouting {
  public static String fp = "./cycle0Practice.txt";
  private List<Location> locations;
  private List<Vehicle> vehicles;

  public OneTruckRouting() {
    this.locations = new ArrayList<>();
    this.vehicles = new ArrayList<>();
  }

  public void addLocation(Location location) {
    locations.add(location);
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public void solve() {
    // Calculate the savings for all possible pairs of locations
    int[][] savings = new int[locations.size()][locations.size()];
    for (int i = 0; i < locations.size(); i++) {
      for (int j = i + 1; j < locations.size(); j++) {
        savings[i][j] = calculateSavings(locations.get(i), locations.get(j));
      }
    }

    // Sort the savings array in descending order
    List<int[]> sortedSavings = new ArrayList<>();
    for (int i = 0; i < locations.size(); i++) {
      for (int j = i + 1; j < locations.size(); j++) {
        sortedSavings.add(new int[]{i, j, savings[i][j]});
      }
    }
    sortedSavings.sort((a, b) -> Integer.compare(b[2], a[2]));

    // Merge routes using the savings
    for (int[] s : sortedSavings) {
      int i = s[0];
      int j = s[1];
      Location locI = locations.get(i);
      Location locJ = locations.get(j);

      Vehicle selectedVehicle = null;
      for (Vehicle vehicle : vehicles) {
        if (vehicle.capacity >= locI.demand + locJ.demand) {
          selectedVehicle = vehicle;
          break;
        }
      }

      if (selectedVehicle != null) {
        selectedVehicle.route.add(0, locJ); // Insert J before I in the route
        selectedVehicle.route.add(0, locI);
        locations.remove(locI);
        locations.remove(locJ);
      }
    }

    // Print the routes
    int vehicleNumber = 1;
    for (Vehicle vehicle : vehicles) {
      System.out.print("Vehicle " + vehicleNumber + " Route: ");
      for (Location location : vehicle.route) {
        System.out.print("(" + location.x + ", " + location.y + ") ");
      }
      System.out.println();
      vehicleNumber++;
    }
  }

  private int calculateSavings(Location i, Location j) {
    // For simplicity, we use the Euclidean distance as savings between two locations
    return (int) (Math.sqrt(Math.pow(i.x - j.x, 2) + Math.pow(i.y - j.y, 2)));
  }


  static String readLine(String filePath, int lineNumber) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      int currentLine = 1;
      while ((line = br.readLine()) != null) {
        if (currentLine == lineNumber) {
          return line;
        }
        currentLine++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null; // Line number not found or error occurred
  }

  public static int countLines(String filePath) {
    int lineCount = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      while (br.readLine() != null) {
        lineCount++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lineCount;
  }


  public static int extractX(String input) {
    Pattern pattern = Pattern.compile("(\\d+)[a-zA-Z]");
    Matcher matcher = pattern.matcher(input);

    if (matcher.find()) {
      return Integer.parseInt(matcher.group(1));
    } else {
      throw new IllegalArgumentException("Failed to extract x.");
    }
  }

  public static int extractY(String input) {
    Pattern pattern = Pattern.compile("(?<=,)\\d+(?=[a-zA-Z])");
    Matcher matcher = pattern.matcher(input);

    if (matcher.find()) {
      return Integer.parseInt(matcher.group());
    } else {
      throw new IllegalArgumentException("Failed to extract y.");
    }
  }

  public static String extractZ(String input) {
    Pattern pattern = Pattern.compile("[a-zA-Z]+$");
    Matcher matcher = pattern.matcher(input);

    if (matcher.find()) {
      return matcher.group();
    } else {
      throw new IllegalArgumentException("Failed to extract z.");
    }
  }

  public static void main(String[] args) {
    int cycleCount = Integer.parseInt(readLine(fp, 1));
    int totalPkgs = Integer.parseInt(readLine(fp, 2));
    int SCunits = Integer.parseInt(readLine(fp, countLines(fp)-2));
    int PCunits = Integer.parseInt(readLine(fp, countLines(fp)));

    OneTruckRouting vrp = new OneTruckRouting();
    vrp.addLocation(new Location(250, 220, 0));
    vrp.addLocation(new Location(0, 276, 1));
    vrp.addLocation(new Location(0, 65, 1));
    vrp.addLocation(new Location(1, 476, 1));

    vrp.addVehicle(new Vehicle(totalPkgs));

    vrp.solve();
  }
}

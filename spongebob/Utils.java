import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
- 5k feet in a mile
- Street width = 0
- Homes are 100x100 = 10k ft area in total
- 10 homes on each side of a block (each block is 1k feet) (20 homes on each street)
- entire map = 100,000 x 100,000 (40 square miles)
- 500 streets (E/W) that are 200 feet apart (width of 2 homes)
- 100 avenues (N/S) that are 1000 feet apart (width of 10 homes)


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


public class Utils {
  public static void main(String[] args) {
  }
}

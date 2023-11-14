public class MainBuilding {
    public static void main(String[] args) {
        ApartmentBuilding apartmentComplex1 = new ApartmentBuilding(100, 2, 2);
        ApartmentBuilding apartmentComplex2 = new ApartmentBuilding(50, 1, 1);

        Warehouse warehouse1 = new Warehouse(5000);
        Warehouse warehouse2 = new Warehouse(8000);

        CommercialBuilding commercialBuilding1 = new CommercialBuilding(5);
        CommercialBuilding commercialBuilding2 = new CommercialBuilding(3);

        Building.compareBuildings(apartmentComplex1, apartmentComplex2);
        Building.compareBuildings(warehouse1, warehouse2);
        Building.compareBuildings(commercialBuilding1, commercialBuilding2);
        apartmentComplex1.printBuildingValue();
        apartmentComplex2.printBuildingValue();
        warehouse1.printBuildingValue();
        warehouse2.printBuildingValue();
        commercialBuilding1.printBuildingValue();
        commercialBuilding2.printBuildingValue();
    }
}




public abstract class Building {
    public int marketValue;

    public abstract int calculateMarketValue();

    public int getMarketValue() {
        return marketValue;
    }

    public static void compareBuildings(Building building1, Building building2) {
        int value1 = building1.calculateMarketValue();
        int value2 = building2.calculateMarketValue();

        if (value1 > value2) {
            System.out.println("Building 1 is more valuable.");
        } else if (value1 < value2) {
            System.out.println("Building 2 is more valuable.");
        } else {
            System.out.println("Both buildings have the same market value.");
        }


    }
    public void printBuildingValue() {
      System.out.println("Market value of the building: $" + marketValue);
    }
}

class ApartmentBuilding extends Building {
    private int numApartments;
    private int numBedrooms;
    private int numBathrooms;

    public ApartmentBuilding(int numApartments, int numBedrooms, int numBathrooms) {
        this.numApartments = numApartments;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.marketValue = calculateMarketValue();
    }

    @Override
    public int calculateMarketValue() {
        return numApartments * (numBedrooms + numBathrooms) * 10000; // Adjust the formula as needed
    }
}

class Warehouse extends Building {
    private int sizeInSquareFeet;

    public Warehouse(int sizeInSquareFeet) {
        this.sizeInSquareFeet = sizeInSquareFeet;
        this.marketValue = calculateMarketValue();
    }

    @Override
    public int calculateMarketValue() {
        return sizeInSquareFeet * 50; // Adjust the formula as needed
    }
}

class CommercialBuilding extends Building {
    private int numberOfFloors;

    public CommercialBuilding(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.marketValue = calculateMarketValue();
    }

    @Override
    public int calculateMarketValue() {
        return numberOfFloors * 50000; // Adjust the formula as needed
    }
}


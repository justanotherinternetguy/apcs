import java.io.*;
import java.util.*;


public class TestInvestment 
{
	public TestInvestment() 
	{
	}

	public static void main(String[] args) 
	{
		new TestInvestment();
	
	
	Investment I[] = new Investment[3];
	
	
	I[0] = new CD("Casey", "973-555-3434","111-22-3333",21,1000.0,8.5,90);
	I[1] = new MutualFund("John", "973-555-3434","111-22-3333",21,1000.0,10.50);	
	I[2] = new CD("Farrell", "973-555-3434","111-22-3333",21,1000.0,6.5,90);
	
	I[0].calcValue();
	I[1].calcValue();
	I[2].calcValue();
	
	
	if(I[0].compareTo(I[2]) > 0)
		{
		System.out.println(I[0].getName() + " Has More Invested");
		System.out.println(I[0].toString());
		}
		else
		{
		System.out.println(I[1].getName() + " Has More Invested");
		System.out.println(I[1].toString());
		}
	
	if(I[2].compareTo(I[1]) > 0)
		{
		System.out.println(I[2].getName() + " Has More Invested");
		System.out.println(I[2].toString());
		}
		else
		{
		System.out.println(I[1].getName() + " Has More Invested");
		System.out.println(I[1].toString());
		}
	
	// Print Details of the Mutual Fund
	System.out.println(I[1].getName() + " " + I[1].getSsn() + " " +
		I[1].getValue());
	
	}
}


abstract class Investment implements Comparable<Investment> {
    private String name;
    private String phoneNumber;
    private String ssn;
    private int age;
    private double value;

    public Investment(String name, String phoneNumber, String ssn, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.ssn = ssn;
        this.age = age;
        this.value = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public int getAge() {
        return age;
    }

    public double getValue() {
        return value;
    }

    protected void setValue(double value) {
        this.value = value;
    }

    public abstract void calcValue();

    public int compareTo(Investment other) {
        return Double.compare(this.value, other.value);
    }

    public String toString() {
        return "Name: " + name + ", Value: $" + value + ", Type: " + getClass().getSimpleName();
    }
}

class CD extends Investment {
    private double amount;
    private double rate;
    private int term;

    public CD(String name, String phoneNumber, String ssn, int age, double amount, double rate, int term) {
        super(name, phoneNumber, ssn, age);
        this.amount = amount;
        this.rate = rate;
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public double getRate() {
        return rate;
    }

    public int getTerm() {
        return term;
    }

    @Override
    public void calcValue() {
        double value = amount * (term * (rate / 360));
        setValue(value);
    }
}

class MutualFund extends Investment {
    private double units;
    private double unitValue;

    public MutualFund(String name, String phoneNumber, String ssn, int age, double units, double unitValue) {
        super(name, phoneNumber, ssn, age);
        this.units = units;
        this.unitValue = unitValue;
    }

    public double getUnits() {
        return units;
    }

    public double getUnitValue() {
        return unitValue;
    }

    @Override
    public void calcValue() {
        double value = units * unitValue;
        setValue(value);
    }
}



import java.io.*;
import java.util.*;


class Employee {
	private double rate;
	private int hours;
	private String name;

	public Employee() {
	}

	public boolean setRate(double rate) {
		if (rate > 999) {
			return false;
		}
		else {
			this.rate = rate;
			return true;
		}
	}

	public boolean setName(String name) {
		if (name.length() < 2) {
			return false;
		}
		else {
			this.name = name;
			return true;
		}
	}

	public boolean setHours(int hours) {
		if (hours > 24) {
			return false;
		}
		else {
			this.hours = hours;
			return true;
		}
	}

	public double getSalary() {
		return rate;
	}

	public int getHours() {
		return hours;
	}

	public String getName() {
		return name;
	}

	public double calculateTotalSalary() {
		return (double) (this.hours * this.rate);
	}

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setRate(500.0);
		e1.setName("Bobby");
		e1.setHours(5);
		System.out.println(e1.calculateTotalSalary());
	}
}

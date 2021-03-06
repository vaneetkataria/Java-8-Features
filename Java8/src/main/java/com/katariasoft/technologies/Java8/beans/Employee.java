package com.katariasoft.technologies.Java8.beans;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.katariasoft.technologies.Java8.streams.EmployeeListSorterUsingComparing;

public class Employee implements Comparable<Employee> {

	Comparator<Employee> sortByRelevanceComparator = new EmployeeListSorterUsingComparing().getByRelevance();
	private Function<Employee, String> nameProvider = e -> e.getName();

	/*
	 * Here Functional interface is taking 1 argument and implementation method
	 * reference is taking no arguments This is 1-0 rule for instance methods .
	 */
	private Function<Employee, String> nameProviderByMethodRef = Employee::getName;
	private static BiFunction<Employee, Employee, String> twoEmployeeesNameProvider = (e1, e2) -> e1.getName() + " "
			+ e2.getName();
	// Here again 1-0 rule holds true . As Functional interface is taking two
	// arguments and
	// instance method is taking 1 argument .
	private static BiFunction<Employee, Employee, String> twoEmployeeesNameProviderByMethodRef = Employee::twoEmployeesNameProvider;

	private long id;
	private String name;
	private byte age;
	private String designation;
	private double salary;
	private String location;
	private String designationBand;
	private String maritalStatus;
	private String sex;
	private long phoneNumber;
	private Address address;

	public Employee(String name, byte age, String designation, double salary, String location, String designationBand,
			String maritalStatus, String sex, long phoneNumber, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		this.location = location;
		this.designationBand = designationBand;
		this.maritalStatus = maritalStatus;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String twoEmployeesNameProvider(Employee e2) {
		return this.getName() + " " + e2.getName();
	}

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOf(Employee e) {
		return e.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesignationBand() {
		return designationBand;
	}

	public void setDesignationBand(String designationBand) {
		this.designationBand = designationBand;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static class Address implements Comparable<Address> {

		// while chaining comparators just declare first comparator's type.
		private Comparator<Address> chainedAddressComparator = Comparator.comparing((Address a) -> a.getCountry())
				.thenComparing(a -> a.getState()).thenComparing(a -> a.getCity()).thenComparing(a -> a.getStreetNo())
				.thenComparing(a -> a.getHouseNo());

		private int houseNo;
		private int streetNo;
		private String city;
		private String state;
		private String country;

		public Address(int houseNo, int streetNo, String city, String state, String country) {
			super();
			this.houseNo = houseNo;
			this.streetNo = streetNo;
			this.city = city;
			this.state = state;
			this.country = country;
		}

		public int getHouseNo() {
			return houseNo;
		}

		public void setHouseNo(int houseNo) {
			this.houseNo = houseNo;
		}

		public int getStreetNo() {
			return streetNo;
		}

		public void setStreetNo(int streetNo) {
			this.streetNo = streetNo;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		@Override
		public int compareTo(Address o) {
			return chainedAddressComparator.compare(this, o);
		}

		@Override
		public String toString() {
			return "Address [houseNo=" + houseNo + ", streetNo=" + streetNo + ", city=" + city + ", state=" + state
					+ ", country=" + country + "]";
		}

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", designation=" + designation + ", salary=" + salary
				+ ", location=" + location + ", designationBand=" + designationBand + ", maritalStatus=" + maritalStatus
				+ ", sex=" + sex + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Employee o) {

		return sortByRelevanceComparator.compare(this, o);

	}

	public static void main(String args[]) {
		Employee e1 = new Employee();
		e1.setName("Vaneet");
		Employee e2 = new Employee();
		e2.setName("Sahil");
		System.out.println(twoEmployeeesNameProvider.apply(e1, e2));

	}

}

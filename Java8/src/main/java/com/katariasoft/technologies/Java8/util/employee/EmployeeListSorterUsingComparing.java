package com.katariasoft.technologies.Java8.util.employee;

import java.util.Comparator;
import com.katariasoft.technologies.Java8.beans.Employee;

public class EmployeeListSorterUsingComparing {

	private Comparator<Employee> byName = Comparator.comparing(e -> e.getName());
	private Comparator<Employee> byAge = Comparator.comparingInt(e -> e.getAge());
	private Comparator<Employee> byDesignationBand = Comparator.comparing(e -> e.getDesignationBand());
	private Comparator<Employee> bySalary = Comparator.comparingDouble(e -> e.getSalary());
	private Comparator<Employee> byMobileNo = Comparator.comparingLong(e -> e.getPhoneNumber());
	private Comparator<Employee> byAddress = Comparator.comparing(e -> e.getAddress());

	// composite sorter
	private Comparator<Employee> byRelevance = bySalary.thenComparing(byAge).thenComparing(byDesignationBand)
			.thenComparing(byName).thenComparing(byMobileNo).thenComparing(byAddress);

	// composite sorter chained
	private Comparator<Employee> byRelevanceChained = Comparator.comparingDouble((Employee e) -> e.getSalary())
			.thenComparing(Comparator.comparingInt(e -> e.getAge()))
			.thenComparing(Comparator.comparing(e -> e.getDesignationBand()))
			.thenComparing(Comparator.comparing(e -> e.getName()))
			.thenComparing(Comparator.comparingLong(e -> e.getPhoneNumber()))
			.thenComparing(Comparator.comparing(e -> e.getAddress()));

	private Comparator<Employee> nullFirstByRelevanceChained = Comparator.nullsFirst(byRelevanceChained);
	private Comparator<Employee> nullLastByRelevanceChained = Comparator.nullsLast(byRelevanceChained);

	public Comparator<Employee> getByName() {
		return byName;
	}

	public Comparator<Employee> getByAge() {
		return byAge;
	}

	public Comparator<Employee> getByDesignationBand() {
		return byDesignationBand;
	}

	public Comparator<Employee> getBySalary() {
		return bySalary;
	}

	public Comparator<Employee> getByMobileNo() {
		return byMobileNo;
	}

	public Comparator<Employee> getByAddress() {
		return byAddress;
	}

	public Comparator<Employee> getByRelevance() {
		return byRelevanceChained;
	}

	public Comparator<Employee> getByRelevanceChained() {
		return byRelevanceChained;
	}

	public Comparator<Employee> getByRelevanceNullFirst() {
		return nullFirstByRelevanceChained;
	}

	public Comparator<Employee> getByRelevanceNullLast() {
		return nullLastByRelevanceChained;
	}

	public static void main(String args[]) {
		EmployeeListSorterUsingComparing sorter = new EmployeeListSorterUsingComparing();
		System.out.println("EmployeeList before sorting is :" + EmployeeList.get());
		System.out.println("EmployeeList after sorting is :");
		EmployeeList.get().stream().sorted(sorter.byRelevance).forEach(System.out::println);
		System.out.println("###By Chained comparator");
		EmployeeList.get().stream().sorted(sorter.byRelevanceChained).forEach(System.out::println);
		System.out.println("###Null First sorted by refrence");
		EmployeeList.getIncludingNulls().stream().sorted(sorter.nullFirstByRelevanceChained)
				.forEach(System.out::println);
		System.out.println("Null Last sorted by refrence");
		EmployeeList.getIncludingNulls().stream().sorted(sorter.nullLastByRelevanceChained)
				.forEach(System.out::println);
	}

}
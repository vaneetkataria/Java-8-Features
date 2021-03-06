package com.katariasoft.technologies.Java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.katariasoft.technologies.Java8.beans.Employee;
import com.katariasoft.technologies.Java8.interfaces.funtional.predefined.consumer.EmployeesConsumer;
import com.katariasoft.technologies.Java8.interfaces.funtional.predefined.pridicate.employee.EmployeeFilterWithPredicate;
import com.katariasoft.technologies.Java8.interfaces.funtional.predefined.supplier.OtpSupplierProvider;
import com.katariasoft.technologies.Java8.interfaces.funtional.predefined.unaryoperator.EmployeeUnaryOperators;
import com.katariasoft.technologies.Java8.util.employee.EmployeeList;

public class MiscStreamProcessor {

	private EmployeeUnaryOperators employeeUnaryOperators = new EmployeeUnaryOperators();
	private EmployeeFilterWithPredicate employeeFilterWithPredicate = new EmployeeFilterWithPredicate();
	private EmployeesConsumer employeesConsumer = new EmployeesConsumer();
	private EmployeeListSorterUsingComparing employeeListSorterCmp = new EmployeeListSorterUsingComparing();
	private OtpSupplierProvider otpSupplierProvider = new OtpSupplierProvider();

	public static interface MiscStreamProcessorCases {
		String printAll = "printAll";
		String sayHelloToAll = "sayHelloToAll";
		String incrementEmployeeSalary = "incrementEmployeeSalary";
		String incrementEmployeeSalaryWithParticularDesignationTechLead = "incrementEmployeeSalaryWithParticularDesignationTechLead";
		String printAllDesignationBands = "printAllDesignationBands";
		String printAllSalaries = "printAllSalaries";
		String sendSmsToPromotionEligibleEmployees = "sendSmsToPromotionEligibleEmployees";
		String printDistinctDesignations = "printDistinctDesignations";
		String printDistinctSalaries = "printDistintSalaries";
		String printEmployeesSortedByRelevance = "printEmployeesSortedByRelevance";
		String sendSmsEmailToEmployeesSkipFirstTwo = "sendSmsEmailToEmployeesSkipFirstTwo";
		String minMaxCountOfSortedByRelevanceEmployees = "minMaxCountOfSortedByRelevanceEmployees";
		String anyMatchAllMatchNoneMatch = "anyMatchAllMatchNoneMatch";
		String findFirstFindAny = "findFirstFindAny";
		String streamOfElements = "streamOfElements";
		String infiniteStream = "infiniteStream";
		String reducers = "reducers";
		String reducersWithIdentitySupplied = "reducersWithIdentitySupplied";
		String mapReducers = "mapReducers";
		String collectors = "collectors";

	}

	public static void main(String args[]) {
		List<String> teamMembers = Arrays.asList("Vaneet", "Pratapi", "Deepak", "Dheeraj", "Franka");
		// List<String> teamMembers = new ArrayList<>();
		MiscStreamProcessor processor = new MiscStreamProcessor();
		String testCase = MiscStreamProcessorCases.minMaxCountOfSortedByRelevanceEmployees;
		// Execute test case.
		switch (testCase) {
		case MiscStreamProcessorCases.printAll:
			processor.printAll(teamMembers);
			break;
		case MiscStreamProcessorCases.sayHelloToAll:
			processor.sayHelloToAll(teamMembers);
			break;
		case MiscStreamProcessorCases.incrementEmployeeSalary:
			processor.incrementEmployeeSalary(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.incrementEmployeeSalaryWithParticularDesignationTechLead:
			processor.incrementEmployeeSalaryWithParticularDesignationTechLead(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.printAllDesignationBands:
			processor.printAllDesignationBands(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.printAllSalaries:
			processor.printAllSalaries(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.sendSmsToPromotionEligibleEmployees:
			processor.sendSmsToPromotionEligibleEmployees(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.printDistinctDesignations:
			processor.printDistinctDesignations(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.printDistinctSalaries:
			processor.printDistinctSalaries(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.printEmployeesSortedByRelevance:
			processor.printEmployeesSortedByRelevance(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.sendSmsEmailToEmployeesSkipFirstTwo:
			processor.sendSmsEmailToEmployees(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.minMaxCountOfSortedByRelevanceEmployees:
			processor.minMaxCountOfSortedByRelevanceEmployees(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.anyMatchAllMatchNoneMatch:
			processor.anyMatchAllMatchNoneMatch(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.findFirstFindAny:
			processor.findFirstFindAny(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.streamOfElements:
			processor.streamOfElements();
			break;
		case MiscStreamProcessorCases.infiniteStream:
			processor.infiniteStream();
			break;
		case MiscStreamProcessorCases.reducers:
			processor.reducers(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.reducersWithIdentitySupplied:
			processor.reducersWithIdentitySupplied(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.collectors:
			processor.collectors(EmployeeList.get());
			break;
		case MiscStreamProcessorCases.mapReducers:
			processor.mapReducers(EmployeeList.get());
			break;
		default:
			break;
		}

	}

	public void printAll(List<String> values) {
		Objects.requireNonNull(values);
		values.stream().forEach(System.out::println);
	}

	public void sayHelloToAll(List<String> values) {
		Objects.requireNonNull(values);
		values.stream().forEach(e -> System.out.println("Hello " + e));
	}

	public List<Employee> incrementEmployeeSalary(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		System.out.println("Employees with old salary are :" + employees);
		List<Employee> incrementedSalaryList = employees.stream()
				.map(employeeUnaryOperators.getSingleEmployeeSalaryIncrementor()).collect(Collectors.toList());
		System.out.println("Employees with new salary are :" + incrementedSalaryList);
		return incrementedSalaryList;
	}

	public List<Employee> incrementEmployeeSalaryWithParticularDesignationTechLead(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		System.out.println("Employees with old salary are :" + employees);
		List<Employee> incrementedSalaryList = employees.stream()
				.peek(e -> System.out.println("Next employee in the pipeline is:" + e.getName()))
				.filter(employeeFilterWithPredicate.getHavingDesignationTechLeadPredicate())
				.peek(e -> System.out
						.println("Next filtered promotion eligible employee in the pipeline is:" + e.getName()))
				.map(employeeUnaryOperators.getSingleEmployeeSalaryIncrementor())
				.peek(e -> System.out.println(
						"Next filtered promotion eligible employee salary incrimented in the pipeline is:" + e))
				.collect(Collectors.toList());
		System.out.println("Filtered Employees with new salary are :" + incrementedSalaryList);
		return incrementedSalaryList;
	}

	public void printAllDesignationBands(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		employees.stream().mapToInt(e -> Integer.valueOf(e.getDesignationBand()).intValue())
				.forEach(System.out::println);
	}

	public void printAllSalaries(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		employees.stream().mapToDouble(e -> e.getSalary()).forEach(System.out::println);
	}

	public void sendSmsToPromotionEligibleEmployees(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		employees.stream().peek(e -> System.out.println("Next employee in the pipeline is:" + e.getName()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println(e.getName() + "is promotion eligible")).mapToLong(e -> e.getPhoneNumber())
				.peek(p -> System.out.println("Going to send sms on " + p))
				.forEach(employeesConsumer.getHolidayAnnouncementSender());
	}

	public void printDistinctDesignations(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		employees.stream().peek(e -> System.out.println("Next employee in the pipeline is:" + e.getName())).map(e -> {
			Objects.requireNonNull(e);
			return e.getDesignation();
		}).peek(s -> System.out.println("Next employee designation in the pipeline is:" + s)).distinct()
				.peek(s -> System.out.println("Next ditinct employee designation in the pipeline is:" + s))
				.forEach(System.out::println);
	}

	public void printDistinctSalaries(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		employees.stream().peek(e -> System.out.println("Next employee in the pipeline is:" + e.getName()))
				.mapToDouble(e -> e.getSalary())
				.peek(s -> System.out.println("Next employee salary in the pipeline is:" + s)).distinct()
				.peek(s -> System.out.println("Next Distinct salry in the pipeline is:" + s))
				.forEach(System.out::println);
	}

	public void printEmployeesSortedByRelevance(List<Employee> employees) {
		Objects.requireNonNull(employees, "Employee List cannot be empty.");
		System.out.println("Employee List without sorting : " + employees);
		Employee[] employeesArr = employees.stream()
				.peek(e -> System.out.println("Next employee in the pipeline " + "is :" + e.getName()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println(e.getName() + " is Promotion eligible ."))
				.sorted(employeeListSorterCmp.getByRelevance()).toArray(Employee[]::new);
		Arrays.stream(employeesArr).forEach(System.out::println);

	}

	public void sendSmsEmailToEmployees(List<Employee> employees) {
		Objects.requireNonNull(employees);
		employees.stream().limit(4)
				.peek(e -> System.out.println("Next employee in the pipeline before max limit is: " + e.getName()))
				.skip(2).peek(e -> System.out.println("Next employee in the pipeline after skip is " + e.getName()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println(e.getName() + " is Promotion eligible ."))
				.forEach(e -> System.out.println("Sms email sent to " + e.getName()));
	}

	public void minMaxCountOfSortedByRelevanceEmployees(List<Employee> employees) {
		employees = new ArrayList<>();
		Objects.requireNonNull(employees);
		long count = employees.stream()/* .limit(3).skip(1) */
				.peek(e -> System.out.println("Next employee in the pipeline " + "is :" + e.getName()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out
						.println("Next employee eligible for promotion in the pipeline " + "is :" + e.getName()))
				// .sorted(employeeListSorterCmp.getByRelevance()).forEach(System.out::println);
				// .min(employeeListSorterCmp.getByRelevance()).ifPresent(System.out::println);
				// .max(employeeListSorterCmp.getByRelevance()).ifPresent(System.out::println);
				.count();
		System.out.println("Num employees eligible for promotion is: " + count);

	}

	public void anyMatchAllMatchNoneMatch(List<Employee> employees) {
		Objects.requireNonNull(employees);
		System.out.println(employees.stream()
				.peek(e -> System.out.println("Next employee in the pipeline " + "is :" + e.getName()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out
						.println("Next employee eligible for promotion in the pipeline " + "is :" + e.getName()))
				// .anyMatch(e -> e.getAge() < 40));
				// .allMatch(e -> e.getAge() < 28));
				.noneMatch(e -> e.getAge() < 26));

	}

	public void findFirstFindAny(List<Employee> employees) {
		Objects.requireNonNull(employees);
		employees.stream().peek(e -> System.out.println("Next employee in the pipeline " + "is :" + e.getName()))
				.filter(e -> e.getAge() < 28)
				.peek(e -> System.out
						.println("Next employee eligible after filteration in the pipeline " + "is :" + e.getName()))
				.findFirst().ifPresent(System.out::println);

	}

	public void streamOfElements() {
		Stream.of("vaneet", "Pratapi", "Deepak", "Dheeraj", "Franka").limit(4).skip(1).filter(s -> s.length() > 6)
				.sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	public void infiniteStream() {
		Stream<Integer> infiniteIntegers = Stream.iterate(1, i -> i + 1);
		infiniteIntegers.limit(100).skip(10).filter(i -> i % 2 == 0).forEach(System.out::println);

		Stream<String> infiniteStrings = Stream.iterate("a", s -> s.concat(1 + ""));
		infiniteStrings.limit(20).skip(10).forEach(System.out::println);

		Stream<String> infiniteRandomNumbers = Stream.generate(otpSupplierProvider.getEightDigitOtpProvider());
		infiniteRandomNumbers.peek(s -> System.out.println("Next Random number is : " + s))
				.filter(s -> Integer.parseInt(s) % 2 == 0)
				.peek(s -> System.out.println("Next Even Random number is : " + s)).forEach(s -> {
					try {
						Thread.sleep(1000);
						System.out.println(s);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});

	}

	public void reducers(List<Employee> employees) {

		System.out.println("###Sum of employee salaries by reduce is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee salary is :" + e.getSalary()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce((s1, s2) -> s1 + s2).orElse(0.0d));
		System.out.println("\n");

		System.out.println("###Minimum of employee salaries by reduce is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee is :" + e))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce((d1, d2) -> (d1 <= d2) ? d1 : d2).orElse(0.0d));
		System.out.println("\n");

		System.out.println("###Maximum of employee salaries by reduce is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee is :" + e))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce((d1, d2) -> (d1 >= d2) ? d1 : d2).orElse(0.0d));
		System.out.println("\n");

		// Here average calculated will be wrong
		// 1. Average function defined here is not associative .
		// 2. (1+2)+3 = 1+(2+3) = (1+3)+2 = 1+2+3 = 6
		// 3. (min(1, 2), 3) = (min(1, (2, 3)) = (min(1, 3) ,2)) hence associative .
		// 4. (max(1, 2), 3) = (max(1, (2, 3)) = (max(1, 3) ,2)) hence associative .
		// 5. avg(avg(1, 2), 3) != avg(avg(2,3) ,1) Hence will not work.
		System.out.println("###Average of employee salaries by reduce is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee is :" + e))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce((d1, d2) -> (d1 + d2) / 2));
		System.out.println("\n");

		System.out
				.println(employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.mapToDouble(Employee::getSalary).summaryStatistics());

	}

	public void reducersWithIdentitySupplied(List<Employee> employees) {

		System.out.println("\n");
		System.out.println("##### With Identity ######");
		System.out.println("\n");

		System.out.println("###Sum of employee salaries by reduce with identity 0  is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee salary is :" + e.getSalary()))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce(0, (s1, s2) -> s1 + s2));
		System.out.println("\n");

		System.out.println("###Minimum of employee salaries by reduce with identity Double.MAX_VALUE  is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee is :" + e))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce(Double.MAX_VALUE, (d1, d2) -> (d1 <= d2) ? d1 : d2));
		System.out.println("\n");

		System.out.println("###Maximum of employee salaries by reduce with identity Double.MIN_VALUE is : ");
		System.out.println(employees.stream().peek(e -> System.out.println("Next employee is :" + e))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee salary eligible for promition is :" + e))
				.mapToDouble(Employee::getSalary).reduce(Double.MIN_VALUE, (d1, d2) -> (d1 >= d2) ? d1 : d2));
		System.out.println("\n");

		System.out
				.println(employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.mapToDouble(Employee::getSalary).summaryStatistics());
	}

	public void mapReducers(List<Employee> employees) {
		System.out.println("\n");
		System.out.println("##### Map Reducers ######");
		System.out.println("\n");

		System.out.println("Sum of salaries of employees with map reducers is :"
				+ employees.stream().peek(e -> System.out.println("Next employee is :" + e))
						.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.peek(e -> System.out.println("Next employee eligible for promotion is :" + e))
						.reduce(0.0d, (sal, e) -> sal + e.getSalary(), (sal1, sal2) -> sal1 + sal2));
		System.out.println("\n");

		System.out.println("Min of salaries of employees with map reducers is :"
				+ employees.stream().peek(e -> System.out.println("Next employee is :" + e))
						.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.peek(e -> System.out.println("Next employee eligible for promotion is :" + e))
						.reduce(Double.MAX_VALUE, (sal, e) -> sal <= e.getSalary() ? sal : e.getSalary(),
								(sal1, sal2) -> sal1 <= sal2 ? sal1 : sal2));
		System.out.println("\n");

		System.out.println("Max of salaries of employees with map reducers is :"
				+ employees.stream().peek(e -> System.out.println("Next employee is :" + e))
						.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.peek(e -> System.out.println("Next employee eligible for promotion is :" + e))
						.reduce(Double.MIN_VALUE, (sal, e) -> sal >= e.getSalary() ? sal : e.getSalary(),
								(sal1, sal2) -> sal1 >= sal2 ? sal1 : sal2));
		System.out.println("\n");

		System.out.println(employees.stream().peek(e -> System.out.println("Next employee is :" + e))
				.filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.peek(e -> System.out.println("Next employee eligible for promotion is :" + e))
				.mapToDouble(Employee::getSalary).summaryStatistics());

	}

	public void collectors(List<Employee> employees) {
		Objects.requireNonNull(employees);

		// ###
		// collect in a set.
		System.out.println("###Distict Employee names eligible for promition in linked list.");
		employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.map(Employee::getName).collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);
		System.out.println("\n");
		// ###
		// collect in a set.
		System.out.println("###Distict Employee names eligible for promition.");
		employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.map(Employee::getName).collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("\n");
		// ###
		// collect in a set.
		System.out.println("###Distict Employee salaries eligible for promition.");
		employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.map(Employee::getSalary).collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("\n");
		// ###
		// collect in a set.
		System.out.println("###Distict Employee ages eligible for promition.");
		employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.map(Employee::getAge).collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("\n");
		// ###
		// collect in a set.
		System.out.println("###summaryStatistics of Employee salaries eligible for promition.");
		System.out
				.println(employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.mapToDouble(Employee::getSalary).summaryStatistics());
		System.out.println("\n");
		// ###
		// concatenate strings
		System.out.println("###All employee locations eligible for promotions");
		System.out
				.println(employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.map(Employee::getLocation).collect(Collectors.joining("|")));
		// ###
		// collect in a map group by location
		System.out.println("###All employee eligible for promotions group by location");
		employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
				.collect(Collectors.groupingBy(Employee::getLocation))
				.forEach((k, l) -> System.out.println(k + "=" + l));
		System.out.println("\n");
		// ###
		// collect in a map group by location then salary
		System.out.println("###All employee eligible for promotions group by location then salary then sex");
		System.out
				.println(employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.collect(Collectors.groupingBy(Employee::getLocation,
								Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy(Employee::getSex)))));
		System.out.println("\n");
		// ###
		// collect in a tree map group by location then salary
		System.out
				.println("###All employee eligible for promotions group by location then salary then sex in tree map");
		System.out
				.println(employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
						.collect(Collectors.groupingBy(Employee::getLocation, TreeMap::new,
								Collectors.groupingBy(Employee::getSalary, TreeMap::new,
										Collectors.groupingBy(Employee::getSex, TreeMap::new, Collectors.toList())))));
		// ###
		// collect in a linked hash map group by location then salary
		System.out.println(
				"###All employee eligible for promotions group by location then salary then sex in linked hashmap ");
		System.out
				.println(
						employees.stream().filter(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())
								.collect(Collectors.groupingBy(Employee::getLocation, LinkedHashMap::new,
										Collectors.groupingBy(Employee::getSalary, LinkedHashMap::new,
												Collectors.groupingBy(Employee::getSex)))));

		System.out.println("###All employee group by eligible for promotions ");
		System.out.println(employees.stream().collect(
				Collectors.partitioningBy(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate())));
		System.out.println("\n");

		System.out.println(
				"###All employee group by eligible for promotions then by location then by salary then by sex   ");
		System.out.println(employees.stream()
				.collect(Collectors.partitioningBy(employeeFilterWithPredicate.getPromotionEligibleEmployeesPredicate(),
						Collectors.groupingBy(Employee::getLocation, TreeMap::new, Collectors.groupingBy(
								Employee::getSalary, TreeMap::new, Collectors.groupingBy(Employee::getSex))))));
		System.out.println("\n");

		System.out.println("###Employee Name , salary map ");
		System.out.println(employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary)));
		System.out.println("\n");

		System.out.println("###Salary to names comma separated map.");
		Map<Double, String> salaryNamesCommaSeparatedMap = employees.stream().collect(Collectors
				.toMap(Employee::getSalary, Employee::getName, (n1, n2) -> String.join(",", n1, n2), TreeMap::new));
		System.out.println(salaryNamesCommaSeparatedMap);

		System.out.println("###Salary to list of names map.");
		System.out.println(employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList())));
		System.out.println("/n");

		System.out.println("###location to comma separated names map.");
		System.out.println(employees.stream().collect(Collectors.toMap(Employee::getLocation, Employee::getName,
				(n1, n2) -> String.join(",", n1, n2), TreeMap::new)));
	}

}

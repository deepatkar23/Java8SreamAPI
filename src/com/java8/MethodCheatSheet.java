package com.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MethodCheatSheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<Employee> employee=EmployeeDataBase.getAllEmployees();
		
		//Old foreach way
		/*
		 * for (Employee employee2 : employee) {
		 * System.out.println(employee2.toString()); }
		 */
		
		//java 8 foreach way
		//employee.forEach(e->System.out.println(e.getName()+":"+e.getSalary()));
		
		//java8 stream api way
	//	employee.stream().forEach(e->System.out.println(e.getName()+":"+e.getDept()));
		
		//method referenec way
		//employee.stream().forEach(System.out::println);
		
		//Filter employee with Development Department
		
		/*
		 * List<Employee>
		 * devEmployee=employee.stream().filter(e->e.getDept().equalsIgnoreCase(
		 * "Development") && e.getSalary()>80000).collect(Collectors.toList());
		 * System.out.println(devEmployee);
		 */
		
		//in SET
		/*
		 * Set<Employee>
		 * devEmployees=employee.stream().filter(e->e.getDept().equalsIgnoreCase(
		 * "Development") && e.getSalary()>80000).collect(Collectors.toSet());
		 */
		
		//in MAP
				
		/*
		 * Map<Integer, String>
		 * devEmployees=employee.stream().filter(e->e.getDept().equalsIgnoreCase(
		 * "Development") &&
		 * e.getSalary()>80000).collect(Collectors.toMap(Employee::getId,
		 * Employee::getName));
		 */		
		
		//MAP
		List<String> depEmploy=employee.stream().map(Employee::getDept).collect(Collectors.toList());
		//Distinct
		List<String> depEmployd=employee.stream().map(Employee::getDept).distinct().collect(Collectors.toList());
		
		//FlatMap -- to get the values from map of map like here from projects values
		List<String> projectName =employee.stream().flatMap(e->e.getProjects().stream()).map(Project::getName).collect(Collectors.toList());
		//System.out.println(projectName);
		
		
		//sorted
		//ASC
		List<Employee> projectNames=employee.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		
		
		//DESC
				List<Employee> projectNamesdesc=employee.stream().sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
						.collect(Collectors.toList());
		
			//	projectNamesdesc.forEach(System.out::println);
	
		//min && max
				
			Optional<Employee> maxsala=employee.stream().max(Comparator.comparingDouble(Employee::getSalary));
			//System.out.println(maxsala);
			
			Optional<Employee> minsala=employee.stream().min(Comparator.comparingDouble(Employee::getSalary));
			//projectNamesdesc.forEach(System.out::println);	
			
		//	System.out.println(minsala);
			
		//grouping by	
			
			Map<String, List<Employee>> grpemployee=employee.stream().collect(Collectors.groupingBy(Employee::getGender));
		//	System.out.println(grpemployee);
			
			//Gender -> [name]
			Map<String, List<String>> grpemployees=employee.stream().
					collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName, Collectors.toList())));
			
			//System.out.println(grpemployees);
			
			//Gender -> [count]
			Map<String, Long> grpemployeesCount=employee.stream().
					collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
			
			System.out.println(grpemployeesCount);
			
			
			   //findFirst

	        Employee findFirstElement = employee.stream()
	                .filter(e -> e.getDept().equals("Development"))
	                .findFirst()
	                .orElseThrow(()->new IllegalArgumentException("Employee not found "));

//	        System.out.println(findFirstElement.get());//NPE
	//
//	        if(findFirstElement.isPresent()){
//	            System.out.println(findFirstElement.get());
//	        }
	//
//	        findFirstElement.ifPresent(e-> System.out.println(e.getName()));

	        //System.out.println(findFirstElement);

	        //findAny

	        Employee findAnyElement = employee.stream()
	                .filter(e -> e.getDept().equals("Development"))
	                .findAny()
	                .orElseThrow(()->new IllegalArgumentException("Employee not found "));

	       // System.out.println(findAnyElement);

	        //anyMatch(Predicate) , allMatch(Predicate) , noneMatch(Predicate)

	        boolean developmentEmpAnyMatch = employee.stream()
	                .anyMatch(e -> e.getDept().equals("Development"));
	        //System.out.println("is there any employee match from development dept "+developmentEmpAnyMatch);


	        boolean developmentEmpAllMatch = employee.stream()
	                .allMatch(e -> e.getSalary()>50000);//55000
	        //System.out.println(developmentEmpAllMatch); //false


	        boolean isNoneMatch = employee.stream()
	                .noneMatch(e -> e.getDept().equals("abc"));
	        //System.out.println(isNoneMatch);

	        //limit(long)

	        List<Employee> topPaidEmployees = employee.stream()
	                .sorted(Comparator.comparing(Employee::getSalary).reversed())
	                .limit(4)
	                .collect(Collectors.toList());

	        topPaidEmployees.forEach(e-> System.out.println(e.getName()));

	        //skip(long)
	        List<Employee> skipEmployees = employee.stream().skip(10)
	                .collect(Collectors.toList());


	//
//	        forEach(Consumer)
//	        filter(Predicate)
//	        collect(Collector)
//	        map(Function)
//	        distinct()
//	        flatMap(Function)
//	        sorted(Comparator both ASC and DESC)
//	        min() & max()
//	        GroupBy
//	        findFirst()
//	        findAny()
//	        anyMatch(Predicate)
//	        allMatch(Predicate)
//	        noneMatch(Predicate)
//	        limit(long maxSize)
//	        skip(long n)

	}

}

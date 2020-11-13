
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    
    public static List<Employee> loadEmpFromFile() {
        List<Employee> employees = new ArrayList<>();
        String fileName = "C:\\SGUS\\Java_SE_II\\Collectors\\src\\empDetails.txt";
        File f = new File(fileName);
        if(f.exists()){
            System.out.println(" File Indeed exists !!!!");
            try(Stream <String> stream = Files.lines(Paths.get(fileName))){
                
                stream.forEach(System.out::println);
            }catch(IOException e){
                System.out.println(" Exception in reading from file " + e.getMessage());
            }
        }
            
            return employees;
    }

    public static List<Employee> loadEmp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Doe", "HR", 4000, "SE", 4.8));
        employees.add(new Employee("Mark", "Doe", "PR", 5000, "SSE", 2.8));
        employees.add(new Employee("Thor", "Doe", "SE", 6000, "MG", 1.8));
        employees.add(new Employee("Tony", "Stark", "MK", 7000, "CEO", 3.8));
        employees.add(new Employee("Thor", "Rogers", "IT", 1000, "CXO", 5.8));
        employees.add(new Employee("Ant", "Man", "SE", 3000, "COO", 4.8));
        employees.add(new Employee("Spider", "Man", "MK", 2000, "CFO", 7.8));
        employees.add(new Employee("Rocket", "Racoon", "IT", 8000, "SE", 8.8));
        employees.add(new Employee("John", "Doe", "HR", 4000, "SE", 6.8));
        employees.add(new Employee("Mark", "Doe", "PR", 5000, "SSE", 4.8));
        employees.add(new Employee("Wonder", "Woman", "SE", 6000, "MG", 2.8));
        employees.add(new Employee("Tony", "Stark", "MK", 7000, "CEO", 1.8));
        employees.add(new Employee("Steve", "Rogers", "IT", 1000, "CXO", 0.8));
        employees.add(new Employee("Tony", "Man", "SE", 3000, "COO", 2.8));
        employees.add(new Employee("Spider", "Man", "MK", 2000, "CFO", 3.8));
        employees.add(new Employee("Rocket", "Racoon", "IT", 8000, "SE", 4.8));
        employees.add(new Employee("John", "Doe", "HR", 4000, "SE", 5.8));
        employees.add(new Employee("Steve", "Doe", "PR", 5000, "SSE", 6.8));
        employees.add(new Employee("Thor", "Doe", "SE", 6000, "MG", 7.8));
        employees.add(new Employee("Thor", "Stark", "MK", 7000, "CEO", 8.8));
        employees.add(new Employee("Steve", "Rogers", "IT", 1000, "CXO", 9.8));
        employees.add(new Employee("Thor", "Man", "SE", 3000, "COO", 10.8));
        employees.add(new Employee("Spider", "Man", "MK", 2000, "CFO", 11.8));
        employees.add(new Employee("Thor", "Racoon", "IT", 8000, "SE", 12.8));
        return employees;
    }

    public static void main(String[] args) {

        System.out.println(" Starting here ......");

        
        //loadEmpFromFile();
        
      //  System.out.println(" Employees whose salary is more than 7k ......");
        
        System.out.println(loadEmp().stream().collect(Collectors.counting()));
                
    System.out.println(loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toList()));
    
    
    
        System.out.println(loadEmp()
                .stream()
                .filter(e -> e.getSalary() >= 7000)
                .map(e -> e.getlName())
                .collect(Collectors.toList()));

        // Fetch all LNames and create a list 
        System.out.println(loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toList()));

        // Fetch all LNames and create a set with no duplicate values
        System.out.println(" \n\n Employee listed by Last Name   ::: " + loadEmp()
                .stream()
                .map(e -> e.getlName())
                .collect(Collectors.toSet()));

        // Fetch number of employees working for a department 
        System.out.println(" \n\n Employee by dept ::: " + loadEmp()
                .stream()
                .collect(
                        
                        Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(Collectors.counting(), f -> f.intValue())
                )));

        // Average Years of Experience 
        System.out.println(" \n\n Avg Exp ::: " + loadEmp()
                .stream()
                .collect(Collectors.averagingDouble(e -> e.getYoe()))
                );
        
        
        // Average Years of Experience 
        System.out.println(" \n\n Employee by years of exp  ::: " + loadEmp()
                .stream()
                .collect(Collectors.groupingBy(Employee::getYoe))
                );
        
        // Get full name of emplyees 
        
        System.out.println(" \n\n Employee Fullname " + 
                loadEmp()
        .stream()
                .map(e -> (e.getfName() + " " + e.getlName()))
                .collect(Collectors.joining("\t;;\t"))
                );
        
        // Total Salary of all Employees
        
        System.out.println(" \n\n Total Salary of all Employees \t\t" + 
                loadEmp()
        .stream()
        .collect(Collectors.summarizingInt(Employee::getSalary)));
        
        // Summary of Experience 
        
           // Total Salary of all Employees
        
        System.out.println(" \n\n Experience Report of all Employees \t\t" + 
                loadEmp()
        .stream()
        .collect(Collectors.summarizingDouble(Employee::getYoe)));
       
        
        // Max Salary among Employees 
        
        System.out.println(" \n\n Max salary \t\t" + 
                loadEmp().stream()
    .collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.toList()))
    .firstEntry()
    .getValue());
       
    }
}

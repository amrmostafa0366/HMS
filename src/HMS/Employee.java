package HMS;

import java.util.ArrayList;
import java.util.Scanner;

enum Job{Management,Receptionist,Bellman,Security,HouseKeeper,Accountant,Chief,Laundry}
public class Employee extends Person{
    private Job job;
    private double salary;

    public Employee(String name, int age, String gender, String ssn, Job job, double salary) {
        super(name, age, gender, ssn);
        this.job = job;
        this.salary = salary;
    }
    public Employee(){}

    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private Employee createEmployee(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee name:");
        String name = scanner.nextLine();

        System.out.println("Enter Employee age:");
        int age = scanner.nextInt();

        System.out.println("Enter Employee gender:");
        String gender = scanner.next();

        System.out.println("Enter Employee SSN:");
        String ssn = scanner.next();

        System.out.println("Enter Employee Job:");
        String job = scanner.next();
        Job type = Job.valueOf(job);

        System.out.println("Enter Employee Salary:");
        double salary = scanner.nextDouble();

        return new Employee(name, age, gender, ssn, type, salary);
    }
    public void addEmployee(ArrayList<Employee> employees){
        employees.add(createEmployee());
    }
    /////////// get Employee By /////////////
    ///ssn
    public Employee getEmployee(ArrayList<Employee> employees,String ssn){
        for(Employee employee : employees){
            if(employee.getSsn().equals(ssn)){
                return employee;
            }
        }
        return null;
    }
    public Employee getEmployee(ArrayList<Employee> employees, double salary){
        for(Employee employee : employees ){
            if(employee.getSalary() == salary){
                return employee;
            }
        }
        return null;
    }
    /////////////////////////////////////////////////////////

    public void updateEmployee(ArrayList<Employee> employees,int index){
        employees.set(index,createEmployee());
    }

    public void deleteEmployee(ArrayList<Employee> employees , int index){
        if(index<0 ||index>employees.size()) {
            employees.remove(index);
        }else{
            System.out.println("Invalid");
        }
    }
    public void display(ArrayList<Employee> employees){
        int i = 1;
        for(Employee employee: employees){
            System.out.println(i+++"." + employee.toString());
        }
    }

    public void displayDepartment(ArrayList<Employee> employees,String department){
        ArrayList<Employee> employeesDepartment = new ArrayList<>();
        for(Employee employee : employees){
            if(employee.getJob() == Job.valueOf(department)){
                employeesDepartment.add(employee);
            }
        }
        display(employeesDepartment);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Employee{" +
                "job=" + job +
                ", salary=" + salary +
                '}';
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String name;
    String address;
    String designation;
    double salary;
    int experience;

    public Employee(String name, String address, String designation,
            double salary, int experience) {
        this.name = name;
        this.address = address;
        this.designation = designation;
        this.salary = salary;
        this.experience = experience;
    }

    public String toString() {
        return  /*Integer.toString(i++)+*/"\t"+name  +"\t"+ address +"\t"+ designation  +"\t\t"+salary  + "\t\t"+ experience + "\n";
    }
}

public class EmployeeManager {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void removeEmployee(String name) {
        if (employees.size() == 0) {
            System.out.println("No employees to remove");
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).name.equals(name)) {
                employees.remove(i);
                System.out.println("Employee removed");
            }
            else {
                System.out.println("Employee not found");
            }
        }
    }

    public void displayEmployees() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Sl.no\tName\tAddress\tDesignation\tSalary\tExperience");
        System.out.println("------------------------------------------------------------");
        int i=1;
        for (Employee e : employees) {
            System.out.print((i++));
            System.out.println(e);// I think in effect System.out.println(e.toString()); is happening I dont remember
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager em = new EmployeeManager();

        while (true) {
            System.out.println("---------------------------------------------------------------\n\t\t\t\tMenu\n---------------------------------------------------------------");
            System.out.print("1. Add employee\n2. Remove employee\n3. Display employees\n4. Exit\nOPtion: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter designation: ");
                    String designation = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    System.out.print("Enter experience: ");
                    int experience = sc.nextInt();

                    em.addEmployee(new Employee(name, address,
                            designation, salary, experience));
                    break;
                case 2:
                    System.out.print("Enter name of employee to remove: ");
                    String nam = sc.nextLine();

                    em.removeEmployee(nam);
                    break;
                case 3:
                    em.displayEmployees();
                    break;
                case 4:
                    sc.close();
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
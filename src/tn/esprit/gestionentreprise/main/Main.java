package tn.esprit.gestionentreprise.main;

import tn.esprit.gestionentreprise.entities.CompanyArrayList;
import tn.esprit.gestionentreprise.entities.Employee;

public class Main {
    public static void main(String[] args) {
        CompanyArrayList company = new CompanyArrayList();

        Employee e1 = new Employee(3, "Ben Salah", "Amine", "IT", 2);
        Employee e2 = new Employee(1, "Trabelsi", "Sarra", "Finance", 3);
        Employee e3 = new Employee(2, "Gharbi", "Yassine", "IT", 1);
        Employee e4 = new Employee(4, "Jlassi", "Ines", "Finance", 1);

        company.addEmployee(e1);
        company.addEmployee(e2);
        company.addEmployee(e3);
        company.addEmployee(e4);
        company.addEmployee(new Employee(3, "Ben Salah", "Other", "HR", 5)); // same id + name: refused

        System.out.println("--- All employees ---");
        company.displayEmployee();

        System.out.println("--- Search ---");
        System.out.println(company.searchEmployee("Gharbi"));   // true
        System.out.println(company.searchEmployee("Unknown"));  // false
        System.out.println(company.searchEmployee(e2));         // true

        System.out.println("--- Sort by id (Comparable) ---");
        company.sortEmployeeById();
        company.displayEmployee();

        System.out.println("--- Sort by department then grade (Comparator) ---");
        company.sortEmployeeByDepartementNameAndGrade();
        company.displayEmployee();

        System.out.println("--- Delete ---");
        company.deleteEmployee(e3);
        company.deleteEmployee(e3);
        company.displayEmployee();
    }
}

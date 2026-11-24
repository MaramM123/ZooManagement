package tn.esprit.gestionentreprise.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompanyArrayList implements IGestion<Employee> {
    private ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Cannot add a null employee");
            return;
        }
        if (employees.contains(employee)) { // contains() relies on Employee.equals()
            System.out.println("Employee already exists: " + employee.getLastName());
            return;
        }
        employees.add(employee);
    }

    @Override
    public boolean searchEmployee(String name) {
        for (Employee e : employees) {
            if (e.getLastName() != null && e.getLastName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean searchEmployee(Employee employee) {
        return employees.contains(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (employees.remove(employee)) { // remove(Object) also relies on equals()
            System.out.println("Employee deleted: " + employee.getLastName());
        } else {
            System.out.println("Employee not found: " + (employee == null ? null : employee.getLastName()));
        }
    }

    @Override
    public void displayEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employees");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Override
    public void sortEmployeeById() {
        Collections.sort(employees);
    }

    @Override
    public void sortEmployeeByDepartementNameAndGrade() {
        Comparator<Employee> byDepartmentThenGrade = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int result = e1.getDepartmentName().compareTo(e2.getDepartmentName());
                if (result != 0) {
                    return result;
                }
                return Integer.compare(e1.getGrade(), e2.getGrade());
            }
        };
        Collections.sort(employees, byDepartmentThenGrade);
    }
}

package service;

import entity.Employee;
import repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositoryImpl employeeRepository;

    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void showEmployee() {
        int nomor = 1;
        Employee[] employees = employeeRepository.getAll();
        System.out.println("-- LIST EMPLOYEE --");
        for (var i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(nomor + ". " + employees[i].getName() + " (" + employees[i].getNip() + ")");
                nomor++;
            }
        }
        System.out.println();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    private int employeesLength() {
        int length = 0;
        for (Employee employee : employeeRepository.getAll()) {
            if (employee != null) {
                length++;
            }
        }

        return length;
    }

    @Override
    public void removeEmployee(int number) {
        if (number <= employeesLength() && number > 0) {
            boolean result = employeeRepository.remove(number);
            if (result) {
                System.out.println("Successes delete with number: " + number);
            } else {
                System.out.println("Failed! on number: " + number);
            }
        } else {
            System.out.println("Number is not valid!");
        }
    }
}

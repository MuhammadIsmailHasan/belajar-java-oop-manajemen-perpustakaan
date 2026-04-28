package service;

import entity.Employee;

public interface EmployeeService {

    void showEmployee();
    void addEmployee(Employee employee);
    void removeEmployee(int number);
}

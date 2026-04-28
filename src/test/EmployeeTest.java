package test;

import entity.Employee;
import repository.EmployeeRepositoryImpl;
import service.EmployeeServiceImpl;

public class EmployeeTest {

    public static void main(String[] args) {
//        testShowEmployee();
//        testAddEmployee();
//        testRemoveEmployee();
    }
    public static void testShowEmployee() {
        Employee ismail = new Employee();
        ismail.setName("ismail");
        ismail.setNip(19960422);

        Employee rizka = new Employee();
        rizka.setName("rizka");
        rizka.setNip(19971107);

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        employeeRepository.employees[0] = ismail;
        employeeRepository.employees[1] = rizka;
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.showEmployee();
    }

    public static void testAddEmployee() {
        Employee ismail = new Employee();
        ismail.setName("ismail");
        ismail.setNip(19960422);

        Employee rizka = new Employee();
        rizka.setName("rizka");
        rizka.setNip(19971107);

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.addEmployee(ismail);
        employeeService.addEmployee(rizka);

        employeeService.showEmployee();
    }

    public static void testRemoveEmployee() {
        Employee ismail = new Employee();
        ismail.setName("ismail");
        ismail.setNip(19960422);

        Employee rizka = new Employee();
        rizka.setName("rizka");
        rizka.setNip(19971107);

        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.addEmployee(ismail);
        employeeService.addEmployee(rizka);

        employeeService.showEmployee();
        employeeService.removeEmployee(1);
        employeeService.removeEmployee(0);
        employeeService.removeEmployee(5);
        employeeService.showEmployee();
    }

}

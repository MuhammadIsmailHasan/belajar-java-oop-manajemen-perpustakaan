package test.view;

import entity.Employee;
import repository.EmployeeRepositoryImpl;
import service.EmployeeServiceImpl;
import view.EmployeeView;

public class EmployeeViewTest {

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
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
        employeeService.addEmployee(ismail);
        employeeService.addEmployee(rizka);

        EmployeeView employeeView = new EmployeeView(employeeService);
        employeeView.showEmployeeView();
    }

    public static void testAddEmployee() {
        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);

        EmployeeView employeeView = new EmployeeView(employeeService);
        employeeView.addEmployeeView();

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

        EmployeeView employeeView = new EmployeeView(employeeService);

        employeeService.showEmployee();
        employeeView.removeEmployeeView();
        employeeService.showEmployee();

    }
}

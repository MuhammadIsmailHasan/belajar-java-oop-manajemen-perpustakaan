package view;

import entity.Employee;
import service.EmployeeServiceImpl;
import utils.InputUtil;

public class EmployeeView {

    EmployeeServiceImpl employeeService;

    public EmployeeView(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public void showEmployeeView() {
        while(true) {
            employeeService.showEmployee();

            System.out.println("Choose by number, what do you want?");
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("x. Exit");

            String userInput = InputUtil.inputUser("employee service");

            if (userInput.equalsIgnoreCase("1")) {
                addEmployeeView();
            } else if (userInput.equalsIgnoreCase("2")) {
                removeEmployeeView();
            } else if (userInput.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Please, write valid number!");
            }
        }
    }

    public void addEmployeeView() {
        System.out.println("If you wanna cancel, write 'x'!");

        Employee employee = new Employee();
        var nameInput = InputUtil.inputUser("employee name");
        var nipInput = InputUtil.inputUser("employee nip");

        if (nameInput.equalsIgnoreCase("x") || nipInput.equalsIgnoreCase("x")) {
            showEmployeeView();
        } else {
            employee.setName(nameInput);
            employee.setNip(Integer.parseInt(nipInput));

            employeeService.addEmployee(employee);
        }
    }

    public void removeEmployeeView() {
        System.out.println("If you wanna cancel, write 'x'!");
        var number = InputUtil.inputUser("number of employee");

        if (number.equalsIgnoreCase("x")) {
            showEmployeeView();
        } else {
            try {
                employeeService.removeEmployee(Integer.parseInt(number));
            } catch (Exception e) {
                System.out.println("Cannot convert number of " + e.getMessage());
            }
        }

    }
}

package repository;


import entity.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    public Employee[] employees = new Employee[3];

    @Override
    public Employee[] getAll() {
        return employees;
    }

    @Override
    public Employee getByNip(int nip) {
        for (Employee employee : employees) {
            if (employee != null && employee.getNip() == nip) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public void save(Employee employee) {
        resize();

        for (var i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    private boolean isFull() {
        boolean full = true;
        for (var i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                full = false;
            }
        }

        return full;
    }

    private void resize() {
        if (isFull()) {
            Employee[] temporaryBook = employees;
            employees = new Employee[employees.length * 2];

            for (var i = 0; i < temporaryBook.length; i++) {
                employees[i] = temporaryBook[i];
            }
        }
    }

    @Override
    public boolean remove(int number) {
        boolean isSuccess = false;
        if (employees[number - 1] != null) {
            employees[number - 1] = null;
            isSuccess = true;
        }
        return isSuccess;
    }
}

package repository;

import entity.Employee;

public interface EmployeeRepository {

    Employee[] getAll();

    Employee getByNip(int nip);

    void save(Employee employee);

    boolean remove(int number);
}

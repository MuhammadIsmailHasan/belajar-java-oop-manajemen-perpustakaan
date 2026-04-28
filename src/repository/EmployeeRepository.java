package repository;

import entity.Employee;

public interface EmployeeRepository {

    Employee[] getAll();

    Employee getByNip(int nip);

    public void save(Employee employee);

    public boolean remove(int number);
}

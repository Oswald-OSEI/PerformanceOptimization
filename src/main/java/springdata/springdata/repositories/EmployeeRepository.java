package springdata.springdata.repositories;

import springdata.springdata.entities.Employee;

import java.util.List;

public interface EmployeeRepository<T extends Employee> extends BasePersonsInHospitalRepository<T> {
    List<Employee> findAllByEmployeeType(String employeeType);
}

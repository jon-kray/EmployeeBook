package service;

import model.Employee;
import repository.MemEmployeeRepository;

public class MemEmployeeService {

    private MemEmployeeRepository employeeRepository = new MemEmployeeRepository();

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    public boolean delete(Long id) {
        return employeeRepository.delete(id);
    }

    public Employee[] findAll() {
        return employeeRepository.findAll();
    }


}

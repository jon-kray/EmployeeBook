package repository.impl;

import model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EmployeeMemRepositoryTest {

    private final EmployeeMemRepository employeeMemRepository = new EmployeeMemRepository();
    @Test
    public void saveTest() {
        Employee employee = employeeMemRepository.save(new Employee("Evgeniy", "Ufa"));
        Assert.assertTrue(employeeMemRepository.findById(employee.getId()).isPresent());
    }
    @Test
    public void updateTest() {
        Employee employee = employeeMemRepository.save(new Employee("Evgeniy", "Ufa"));
        boolean result = employeeMemRepository.update(employee.getId(), new Employee("Evgeniy", "Kazan"));
        Assert.assertTrue(result);
        Employee checkEmployeeUpdate = employeeMemRepository.findById(employee.getId()).orElseThrow();
        Assert.assertEquals("Evgeniy", checkEmployeeUpdate.getName());
        Assert.assertEquals("Kazan", checkEmployeeUpdate.getCity());
    }

    @Test
    public void updateNotSuccess() {
        employeeMemRepository.save(new Employee("Evgeniy", "Ufa"));
        boolean result = employeeMemRepository.update(1l, new Employee("Evgeniy", "Kazan"));
        Assert.assertFalse(result);
    }

    @Test
    public void deleteTest() {
        Employee employeeFirst = employeeMemRepository.save((new Employee("Evgeniy", "Ufa")));
        Employee employeeSecond = employeeMemRepository.save(new Employee("Goha", "Kazan"));
        boolean result = employeeMemRepository.delete(employeeSecond.getId());
        Assert.assertTrue(result);
        Assert.assertEquals(1, employeeMemRepository.findAll().size());

    }

    @Test
    public void deleteNotSuccess() {
        employeeMemRepository.save((new Employee("Evgeniy", "Ufa")));
        employeeMemRepository.save(new Employee("Goha", "Kazan"));
        boolean result = employeeMemRepository.delete(1l);
        Assert.assertFalse(result);
        Assert.assertEquals(2, employeeMemRepository.findAll().size());
    }

    @Test
    public void findByNameTest() {
        employeeMemRepository.save((new Employee("Evgeniy", "Ufa")));
        employeeMemRepository.save(new Employee("Goha", "Kazan"));
        employeeMemRepository.save((new Employee("Evgeniy", "Tula")));

        List<Employee> employees = employeeMemRepository.findByName("Evgeniy");
        Assert.assertEquals(2, employees.size());
        employees.forEach(employee -> Assert.assertEquals("Evgeniy", employee.getName()));
    }

    @Test
    public void findByNameTestIsEmpty() {
        employeeMemRepository.save((new Employee("Evgeniy", "Ufa")));
        employeeMemRepository.save(new Employee("Goha", "Kazan"));
        employeeMemRepository.save((new Employee("Evgeniy", "Tula")));

        List<Employee> employees = employeeMemRepository.findByName("Boris");
        Assert.assertTrue(employees.isEmpty());
    }
}
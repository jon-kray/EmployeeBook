package actions.impl;

import actions.EmployeeAction;
import dto.EmployeeDto;
import input.Input;
import model.Employee;
import service.EmployeeService;

public class CreateAction implements EmployeeAction {
    @Override
    public String name() {
        return "**** Create a new Emloyee ****";
    }

    @Override
    public boolean execude(Input input, EmployeeService employeeService) {
        String name = input.askStr("Enter name: ");
        String city = input.askStr("Enter city: ");
        EmployeeDto employee = new EmployeeDto(name, city);
        return employeeService.save(employee);
    }
}

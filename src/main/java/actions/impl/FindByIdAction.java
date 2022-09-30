package actions.impl;

import actions.EmployeeAction;
import dto.EmployeeDto;
import input.Input;
import service.EmployeeService;

import java.util.Optional;

public class FindByIdAction implements EmployeeAction {

    @Override
    public String name() {
        return "**** Find Employees By Id ****";
    }

    @Override
    public boolean execude(Input input, EmployeeService employeeService) {
        long id = input.askLong("Enter id");
        Optional<EmployeeDto> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            System.out.println(employee.get());
        }else {
            System.out.println("Employee not found. ");
        }
        return true;
    }
}

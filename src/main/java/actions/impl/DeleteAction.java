package actions.impl;

import actions.EmployeeAction;
import input.Input;
import service.EmployeeService;

public class DeleteAction implements EmployeeAction {
    @Override
    public String name() {
        return "**** Delete Employee ****";
    }

    @Override
    public boolean execude(Input input, EmployeeService employeeService) {
        long id = input.askLong("Enter id: ");
        if (employeeService.delete(id)) {
            System.out.println("Successfuly");
        } else {
            System.out.println("Unsuccessfuly");
        }
        return true;
    }
}

package actions.impl;

import actions.EmployeeAction;
import input.Input;
import service.EmployeeService;

public class ExitProgrammAction implements EmployeeAction {
    @Override
    public String name() {
        return "**** Exit Program ****";
    }

    @Override
    public boolean execude(Input input, EmployeeService employeeService) {
        return false;
    }
}

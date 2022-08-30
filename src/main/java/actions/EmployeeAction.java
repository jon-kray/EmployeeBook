package actions;

import input.Input;
import service.EmployeeService;

public interface EmployeeAction {

    String name();

    boolean execude(Input input, EmployeeService employeeService);
}

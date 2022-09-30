package actions.impl;

import actions.EmployeeAction;
import dto.EmployeeDto;
import input.Input;
import model.Employee;
import service.EmployeeService;
import sort.Ordered;
import util.OutputUtil;

import java.util.List;

public class FindAllAction implements EmployeeAction {
    @Override
    public String name() {
        return "**** Find all Employees ****";
    }

    @Override
    public boolean execude(Input input, EmployeeService employeeService) {
        OutputUtil.print(employeeService.findAll(Ordered.DEFAULT));
        return true;
    }
}

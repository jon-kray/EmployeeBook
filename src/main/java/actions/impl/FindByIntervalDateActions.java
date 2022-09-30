package actions.impl;

import actions.EmployeeAction;
import input.Input;
import service.EmployeeService;
import util.Constants;
import util.OutputUtil;

import java.time.DateTimeException;

public class FindByIntervalDateActions implements EmployeeAction {
    @Override
    public String name() {
        return "**** Find Employees By Interval Date ****";
    }

    @Override
    public boolean execude(Input input, EmployeeService employeeService) {
        System.out.printf("Please enter date by format - %s\n", Constants.PATTERN_DATE);
        String start = input.askStr("Enter start date: ");
        String end = input.askStr("Enter end date: ");
        try {
            OutputUtil.print(employeeService.findByIntervalDate(start, end));
        }catch(DateTimeException exception) {
            System.out.println("Incorrect date format. Repeat please.");
        }

        return true;
    }
}

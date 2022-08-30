package start;

import actions.*;
import input.ConsoleInput;
import input.Input;
import service.EmployeeService;



public class StartUI {

    public void init(Input input, EmployeeService employeeService, EmployeeAction[] employeeAction) {

        boolean isRunning = true;

        while (isRunning) {
            showMenu(employeeAction);
            int select = (int) input.askLong("Select: ");
            if (select < 0 || select >= employeeAction.length) {
                System.out.println("Wrong input, you can select: 0 ... " + (employeeAction.length - 1));
                continue;
            }
            EmployeeAction action = employeeAction[select];
            isRunning = action.execude(input, employeeService);

        }
    }

    private void showMenu(EmployeeAction[] employeeActions) {
        System.out.println("Welcome. It is menu.");
        for (int index = 0; index < employeeActions.length; index++) {
            System.out.println(index + ". " + employeeActions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        EmployeeService employeeService = new EmployeeService();

        EmployeeAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new DeleteAction(),
                new ExitProgrammAction()
        };
        new StartUI().init(input, employeeService, actions);
    }
}
















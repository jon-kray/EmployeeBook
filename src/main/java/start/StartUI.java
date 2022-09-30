package start;

import actions.*;
import actions.impl.*;
import input.ConsoleInput;
import input.Input;
import mapper.EmployeeMapper;
import model.Employee;
import repository.Repository;
import repository.impl.EmployeeMemRepository;
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
        final Input input = new ConsoleInput();
        final Repository<Long, Employee> store = new EmployeeMemRepository();
        final EmployeeService employeeService = new EmployeeService(store, new EmployeeMapper());
        final EmployeeAction[] actions = {
                new CreateAction(),
                new UpdateAction(),
                new DeleteAction(),
                new FindAllAction(),
                new FindByIdAction(),
                new FindByIntervalDateActions(),
                new FindByNameAction(),
                new SortedByOrdedAction(),
                new ExitProgrammAction()
        };
        new StartUI().init(input, employeeService, actions);
    }
}
















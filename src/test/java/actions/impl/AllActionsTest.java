package actions.impl;

import input.ConsoleInput;
import input.Input;
import mapper.EmployeeMapper;
import model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import repository.impl.EmployeeMemRepository;
import service.EmployeeService;
import sort.Ordered;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AllActionsTest {
    
    private final CreateAction createAction = new CreateAction();

    private final DeleteAction deleteAction = new DeleteAction();

    private  final FindAllAction findAllAction = new FindAllAction();

    private final FindByIdAction findByIdAction = new FindByIdAction();

    private final FindByIntervalDateActions findByIntervalDateActions = new FindByIntervalDateActions();

    private final FindByNameAction findByNameAction = new FindByNameAction();

    private final SortedByOrdedAction sortedByOrdedAction = new SortedByOrdedAction();

    private final UpdateAction updateAction = new UpdateAction();

    private final EmployeeMapper employeeMapper = new EmployeeMapper();

    private final EmployeeMemRepository employeeMemRepository = Mockito.mock(EmployeeMemRepository.class);

    private final EmployeeService employeeService = new EmployeeService(employeeMemRepository, employeeMapper);



    @Test
    public void whenSave() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askStr("Enter name")).thenReturn("Evgeniy");
        Mockito.when(input.askStr("Enter city")).thenReturn("Ufa");
        Employee employee = new Employee("Evgeniy", "Ufa");
        employee.setId(1l);
        employee.setCreated(LocalDateTime.now());
        Mockito.when(employeeMemRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(employee);

        boolean saveSuccess = createAction.execude(input, employeeService);

        Assert.assertTrue(saveSuccess);

    }

    @Test
    public void whenDelete() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askLong("Enter id: ")).thenReturn(123456789L);

        Mockito.when(employeeMemRepository.delete(ArgumentMatchers.eq(123456789L))).thenReturn(true);

        boolean deleteSuccess = deleteAction.execude(input, employeeService);

        Assert.assertTrue(deleteSuccess);

    }

    @Test
    public void findAll() {
        Input input = Mockito.mock(ConsoleInput.class);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Evgeniy", "Ufa"));
        employees.add(new Employee("Anatoliy", "Ufa"));
        employees.add(new Employee("Tania", "Kazan"));

        Mockito.when(employeeMemRepository.findAll()).thenReturn(employees);

        boolean findSuccess = findAllAction.execude(input, employeeService);

        Assert.assertTrue(findSuccess);

    }

    @Test
    public void findById() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askLong("Enter id")).thenReturn(123456789L);
        Employee employee = new Employee("Evgeniy", "Ufa");
        employee.setId(123456789L);
        employee.setCreated(LocalDateTime.now());

        Mockito.when(employeeMemRepository.findById(ArgumentMatchers.eq(123456789L)))
                .thenReturn(Optional.of(employee));

        boolean findByIdSuccess = findByIdAction.execude(input, employeeService);

        Assert.assertTrue(findByIdSuccess);

    }

    @Test
    public void findByIntervalDate() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askStr("Enter start date: ")).thenReturn("27-09-2022 21:34");
        Mockito.when(input.askStr("Enter end date: ")).thenReturn("27-09-2022 21:40");
        Employee employeeFirst = new Employee("Evgeniy", "Ufa");
        employeeFirst.setId(1L);
        employeeFirst.setCreated(employeeMapper.parseDate("27-09-2022 21:35"));
        Employee employeeSecond = new Employee("Anatoliy", "Ufa");
        employeeSecond.setId(2L);
        employeeSecond.setCreated(employeeMapper.parseDate("27-09-2022 21:38"));
        List<Employee> employees = List.of(employeeFirst, employeeSecond);

        Mockito.when(employeeMemRepository.findByCreatedDateInterval(ArgumentMatchers.any(LocalDateTime.class),
                ArgumentMatchers.any(LocalDateTime.class))).thenReturn(employees);

        boolean result = findByIntervalDateActions.execude(input, employeeService);

        Assert.assertTrue(result);

    }

    @Test
    public void findByName() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askStr("Enter name: ")).thenReturn("Evgeniy");
        Employee employee = new Employee("Evgeniy", "Ufa");
        employee.setId(1L);
        employee.setCreated(LocalDateTime.now());
        Mockito.when(employeeMemRepository.findByName(ArgumentMatchers.eq("Evgeniy")))
                .thenReturn(List.of(employee));

        boolean findSuccess = findByNameAction.execude(input, employeeService);

        Assert.assertTrue(findSuccess);

    }

    @Test
    public void whenSortedByOrded() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askStr("Enter order type (ASC/DESC): ")).thenReturn(String.valueOf(Ordered.DESC));
        List<Employee> employees = new ArrayList<>();
        Employee employeeFirst = new Employee("Evgeniy", "Ufa");
        employees.add(employeeFirst);
        Employee employeeSecond = new Employee("Anatoliy", "Ufa");
        employees.add(employeeSecond);
        Employee employeeThird = new Employee("Tania", "Kazan");
        employees.add(employeeThird);

        Mockito.when(employeeMemRepository.findAll()).thenReturn(employees);

        boolean result = sortedByOrdedAction.execude(input, employeeService);

        Assert.assertTrue(result);

    }

    @Test
    public void whenUpdate() {
        Input input = Mockito.mock(ConsoleInput.class);
        Mockito.when(input.askStr("Enter name: ")).thenReturn("Evgeniy");
        Mockito.when(input.askStr("Enter city: ")).thenReturn("Ufa");
        Mockito.when(input.askLong("Enter id: ")).thenReturn(123456789L);

        Mockito.when(employeeMemRepository.update(ArgumentMatchers.anyLong(), ArgumentMatchers.any(Employee.class)))
                .thenReturn(true);

        boolean updateSaccess = updateAction.execude(input, employeeService);

        Assert.assertTrue(updateSaccess);

    }

}
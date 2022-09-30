package service;

import dto.EmployeeDto;
import mapper.EmployeeMapper;
import org.junit.Assert;
import org.junit.Test;
import repository.impl.EmployeeMemRepository;
import sort.Ordered;
import java.util.List;


public class EmployeeServiceTest {

    private final EmployeeMapper employeeMapper = new EmployeeMapper();
    private final EmployeeService employeeService = new EmployeeService(new EmployeeMemRepository(), new EmployeeMapper());
    @Test
    public void whenSortingDefault() {
        EmployeeDto first = new EmployeeDto("Evgeniy", "Ufa");
        EmployeeDto second = new EmployeeDto("Anatoliy", "Ufa");
        EmployeeDto third = new EmployeeDto("Tania", "Moscow");
        employeeService.save(first);
        employeeService.save(second);
        employeeService.save(third);

        List<EmployeeDto> result = employeeService.findAll(Ordered.DEFAULT);
        Assert.assertEquals("Evgeniy", result.get(0).getName());
        Assert.assertEquals("Anatoliy",result.get(1).getName());
        Assert.assertEquals("Tania", result.get(2).getName());
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void whenSortingDesc() {
        EmployeeDto first = new EmployeeDto("Evgeniy", "Ufa");
        EmployeeDto second = new EmployeeDto("Anatoliy", "Ufa");
        EmployeeDto third = new EmployeeDto("Tania", "Moscow");
        employeeService.save(first);
        employeeService.save(second);
        employeeService.save(third);

        List<EmployeeDto> result = employeeService.findAll(Ordered.DESC);
        Assert.assertEquals("Anatoliy", result.get(0).getName());
        Assert.assertEquals("Evgeniy",result.get(1).getName());
        Assert.assertEquals("Tania", result.get(2).getName());
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void whenSortingAsc() {
        EmployeeDto first = new EmployeeDto("Evgeniy", "Ufa");
        EmployeeDto second = new EmployeeDto("Anatoliy", "Ufa");
        EmployeeDto third = new EmployeeDto("Tania", "Moscow");
        employeeService.save(first);
        employeeService.save(second);
        employeeService.save(third);

        List<EmployeeDto> result = employeeService.findAll(Ordered.ASC);
        Assert.assertEquals("Tania", result.get(0).getName());
        Assert.assertEquals("Evgeniy",result.get(1).getName());
        Assert.assertEquals("Anatoliy", result.get(2).getName());
        Assert.assertEquals(3, result.size());

    }


}
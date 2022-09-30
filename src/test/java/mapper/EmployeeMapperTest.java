package mapper;

import dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import model.Employee;
import org.junit.Assert;
import org.junit.Test;


@Slf4j
public class EmployeeMapperTest {

    private final EmployeeMapper employeeMapper = new EmployeeMapper();
    @Test
    public void fromEmployeeToEmployeeDto(){
        try {
        Employee employee = new Employee("Evgeniy", "Ufa");
        log.info("Employee DTO - {}", employeeMapper.fromEmployeeToEmployeeDto(employee));
        }catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void fromEmployeeDtoToEmployee() {
        try {
            EmployeeDto employeeDto = new EmployeeDto("Evgeniy", "Ufa");
            log.info("Employee DTO - {}", employeeMapper.fromEmployeeDtoToEmployeeEntity(employeeDto));
        }catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void parseDate() {
        try {
            String date = "20-09-2022 03:38";
            employeeMapper.parseDate(date);
        }catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void whenParseWithException() {
        employeeMapper.parseDate("ebfjhwerery");
    }
}
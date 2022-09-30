package mapper;

import dto.EmployeeDto;
import model.Employee;
import util.Constants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Маппер для класса Employee
 */

public class EmployeeMapper {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.PATTERN_DATE);

    /**
     *Преабразует сущность в ДТО + парсит дату в формат 1980-10-15 15:33
     * @param employee entity
     * @return dto
     */

    public EmployeeDto fromEmployeeToEmployeeDto(Employee employee) {

        return EmployeeDto.builder()
                .name(employee.getName())
                .city(employee.getCity())
                .created(employee.getCreated().format(dateTimeFormatter))
                .build();
    }

    /**
     * Преабразует employeeDto в entity.
     * @param employeeDto dto
     * @return entity
     */
    public Employee fromEmployeeDtoToEmployeeEntity(EmployeeDto employeeDto) {
        return Employee.builder()
                .name(employeeDto.getName())
                .city(employeeDto.getCity())
                .created(LocalDateTime.now())
                .build();
    }

    /**
     * Парсим строку в дату
     * @param date строка представленная датой
     * @return дата
     */

    public LocalDateTime parseDate(String date) {
        return LocalDateTime.parse(date, dateTimeFormatter);
    }
}

package repository.impl;

import lombok.extern.slf4j.Slf4j;
import model.Employee;
import repository.Repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static util.Constants.INCORRECT_INDEX;

@Slf4j
public class EmployeeMemRepository implements Repository<Long, Employee> {

    private final List<Employee> store = new ArrayList<>();
    @Override
    public void init() {
        log.info("Initialized memory storage.");

    }

    /**
     * Сохраняет Employee с Random id.
     * @return employee
     */
    @Override
    public Employee save(Employee employee) {
        long id = generateId();
        employee.setId(id);
        store.add(employee);
        log.info("User with id - {} saved.", id);
        return employee;
    }

    /**
     * Перезаписывает Employee по id.
     * @param id
     * @param employee
     * @return employee
     */
    @Override
    public boolean update(Long id, Employee employee) {
        int index = indexOf(id);
        boolean result = index != INCORRECT_INDEX;
        if (result) {
            employee.setId(id);
            employee.setCreated(store.get(index).getCreated());
            store.set(index, employee);
        }
        return result;
    }

    /**
     * Удаляет Employee по указаному id,
     * @param id
     * @return result
     */
    @Override
    public boolean delete(Long id) {
        int index = indexOf(id);
        boolean result = index != INCORRECT_INDEX;
        if (result) {
            store.remove(index);
        }

        return result;
    }


    /**
     * Находит Employee по указаному id.
     * @param id
     * @return employee
     */
    @Override
    public Optional<Employee> findById(Long id) {
        int index = indexOf(id);
        return index != INCORRECT_INDEX
                ? Optional.of(store.get(index))
                : Optional.empty();
    }

    /**
     * Находит всех Employee.
     * @return All Employee
     */
    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(store);
    }

    /**
     * Находит всех Employee по указаному имени.
     * @param name
     * @return employee
     */
    @Override
    public List<Employee> findByName(String name) {
        return store.stream()
                .filter(employee -> employee.getName().equals(name))
                .collect(Collectors.toList());

    }
    @Override
    public List<Employee> findByCreatedDateInterval(LocalDateTime start, LocalDateTime end) {
        Predicate<Employee> afterDate = employee -> !employee.getCreated().isAfter(end);
        Predicate<Employee> beforeDate = employee -> !employee.getCreated().isBefore(start);
        return store.stream()
                .filter(afterDate.and(beforeDate))
                .collect(Collectors.toList());
    }

    private int indexOf(long id) {
        return IntStream.range(0, store.size())
                .filter(index -> store.get(index).getId() == id)
                .findFirst()
                .orElse(INCORRECT_INDEX);
    }

    private long generateId() {
        return Math.abs(new Random().nextLong());
    }
}

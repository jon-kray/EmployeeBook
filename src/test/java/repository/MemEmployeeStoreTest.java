package repository;

import model.Employee;
import org.junit.Assert;
import org.junit.Test;

public class MemEmployeeStoreTest {
    @Test
    public void whenSave() {
        MemEmployeeRepository memEmployeeStore = new MemEmployeeRepository();
        Employee employee = new Employee("Evgeniy", "Russia");
        memEmployeeStore.save(employee);
        Employee result = memEmployeeStore.findById(employee.getId());
        Assert.assertNotNull(result);
    }

}
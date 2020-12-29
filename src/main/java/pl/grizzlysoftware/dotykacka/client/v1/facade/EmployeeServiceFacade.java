package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Employee;
import pl.grizzlysoftware.dotykacka.client.v1.api.service.EmployeeService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class EmployeeServiceFacade extends DotykackaApiServiceFacade<EmployeeService> {

    protected BatchLoader batchLoader;

    public EmployeeServiceFacade(Long cloudId, EmployeeService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public Employee getEmployee(Long id) {
        var out = execute(service.getEmployee(cloudId, id));
        return out;
    }

    public Collection<Employee> getAllEmployees(int limit, int offset, String sortBy) {
        var out = execute(service.getEmployees(cloudId, limit, offset, sortBy));
        return out;
    }

    public Collection<Employee> getAllEmployees(String sortBy) {
        var out = batchLoader.load(page -> getAllEmployees(page.limit, page.offset, sortBy));
        return out;
    }

    public Collection<Employee> getAllEmployees() {
        var out = getAllEmployees(null);
        return out;
    }

    public Collection<Employee> getEmployees(int limit, int offset, String sortBy) {
        var out = execute(service.getEmployees(cloudId, limit, offset, sortBy));
        return out;
    }

    public Collection<Employee> getEmployees(int limit, int offset) {
        var out = getEmployees(limit, offset, null);
        return out;
    }

    public Employee updateEmployee(Long id, Employee customer) {
        return execute(service.updateEmployee(cloudId, id, customer));
    }

    public Employee createEmployee(Employee customer) {
        return execute(service.createEmployee(cloudId, customer));
    }

    public Employee deleteEmployee(Long id, boolean anonymize) {
        return execute(service.deleteEmployee(cloudId, id, anonymize));
    }

    public Employee deleteEmployee(Long id) {
        return execute(service.deleteEmployee(cloudId, id, null));
    }
}

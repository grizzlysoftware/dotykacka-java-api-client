package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Employee;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.EmployeeService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class EmployeeServiceFacade extends DotykackaApiServiceFacade<EmployeeService> {
    protected BatchLoader batchLoader;
    public EmployeeServiceFacade(Long cloudId, EmployeeService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createEmployee(Employee employee) {
        execute(service.createEmployee(cloudId, asList(employee)));
    }

    public void createEmployees(Collection<Employee> employees) {
        execute(service.createEmployee(cloudId, employees));
    }
    
    public void replaceEmployee(Employee employee) {
        execute(service.replaceEmployee(cloudId, employee.id, employee));
    }

    public void replaceEmployees(Collection<Employee> employees) {
        execute(service.replaceEmployees(cloudId, employees));
    }

    public void updateEmployee(Employee employee) {
        execute(service.updateEmployee(cloudId, employee.id, employee));
    }

    public void deleteEmployee(Long employeeId) {
        execute(service.deleteEmployee(cloudId, employeeId));
    }

    public Employee findEmployeeById(Long id) {
        var out = execute(service.findEmployeeById(cloudId, id));
        return out;
    }

    public Collection<Employee> findEmployees(int limit, int offset, String filter, String sort) {
        var out = execute(service.findEmployees(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Employee> findEmployees(int limit, int offset) {
        var out = findEmployees(limit, offset, null, null);
        return out;
    }

    public Collection<Employee> findAllEmployees(String sort) {
        var out = batchLoader.load(page -> findEmployees(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Employee> findAllEmployees() {
        var out = findAllEmployees(null);
        return out;
    }
}

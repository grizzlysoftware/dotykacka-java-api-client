package pl.grizzlysoftware.dotykacka.client.v2.facade;

import pl.grizzlysoftware.dotykacka.client.DotykackaApiServiceFacade;
import pl.grizzlysoftware.dotykacka.client.v2.api.dto.Customer;
import pl.grizzlysoftware.dotykacka.client.v2.api.service.CustomerService;
import pl.grizzlysoftware.dotykacka.util.BatchLoader;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CustomerServiceFacade extends DotykackaApiServiceFacade<CustomerService> {
    protected BatchLoader batchLoader;
    public CustomerServiceFacade(Long cloudId, CustomerService service) {
        super(cloudId, service);
        this.batchLoader = new BatchLoader(100);
    }

    public void createCustomer(Customer customer) {
        execute(service.createCustomer(cloudId, asList(customer)));
    }

    public void createCustomers(Collection<Customer> customers) {
        execute(service.createCustomer(cloudId, customers));
    }
    
    public void replaceCustomer(Customer customer) {
        execute(service.replaceCustomer(cloudId, customer.id, customer));
    }

    public void replaceCustomers(Collection<Customer> customers) {
        execute(service.replaceCustomers(cloudId, customers));
    }

    public void updateCustomer(Customer customer) {
        execute(service.updateCustomer(cloudId, customer.id, customer));
    }

    public void deleteCustomer(Long customerId) {
        execute(service.deleteCustomer(cloudId, customerId));
    }

    public Customer findCustomerById(Long id) {
        var out = execute(service.findCustomerById(cloudId, id));
        return out;
    }

    public Collection<Customer> findCustomers(int limit, int offset, String filter, String sort) {
        var out = execute(service.findCustomers(cloudId, limit, offset, filter, sort));
        return out;
    }

    public Collection<Customer> findCustomers(int limit, int offset) {
        var out = findCustomers(limit, offset, null, null);
        return out;
    }

    public Collection<Customer> findAllCustomers(String sort) {
        var out = batchLoader.load(page -> findCustomers(page.limit, page.offset, null, sort));
        return out;
    }

    public Collection<Customer> findAllCustomers() {
        var out = findAllCustomers(null);
        return out;
    }
}

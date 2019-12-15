package pl.grizzlysoftware.dotykacka.client.v1.facade;

import pl.grizzlysoftware.dotykacka.client.v1.api.service.CustomerService;
import pl.grizzlysoftware.dotykacka.client.v1.api.dto.customer.Customer;

import java.util.Collection;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public class CustomerServiceFacade extends DotykackaApiServiceFacade<CustomerService> {

    public CustomerServiceFacade(String cloudId, CustomerService service) {
        super(cloudId, service);
    }

    public Customer getCustomer(Long id) {
        var out = execute(service.getCustomer(cloudId, id));
        return out;
    }

    public Collection<Customer> getAllCustomers() {
        var out = execute(service.getCustomers(cloudId, null, null));
        return out;
    }

    public Collection<Customer> getCustomers(int limit, int offset) {
        var out = execute(service.getCustomers(cloudId, limit, offset));
        return out;
    }

    public Customer updateCustomer(Long id, Customer customer) {
        return execute(service.updateCustomer(cloudId, id, customer));
    }

    public Customer createCustomer(Customer customer) {
        return execute(service.createCustomer(cloudId, customer));
    }

    public Customer deleteCustomer(Long id, boolean anonymize) {
        return execute(service.deleteCustomer(cloudId, id, anonymize));
    }

    public Customer deleteCustomer(Long id) {
        return execute(service.deleteCustomer(cloudId, id, null));
    }
}

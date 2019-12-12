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

    public Collection<Customer> getCustomers() {
        var out = execute(service.getCustomers(cloudId));
        return out;
    }

    public void updateCustomer(Long id, Customer customer) {
        execute(service.updateCustomer(cloudId, id, customer));
    }

    public void createCustomer(Customer customer) {
        execute(service.createCustomer(cloudId, customer));
    }

    public void deleteCustomer(Long id, boolean anonymize) {
        execute(service.deleteCustomer(cloudId, id, anonymize));
    }

    public void deleteCustomer(Long id) {
        execute(service.deleteCustomer(cloudId, id, null));
    }
}

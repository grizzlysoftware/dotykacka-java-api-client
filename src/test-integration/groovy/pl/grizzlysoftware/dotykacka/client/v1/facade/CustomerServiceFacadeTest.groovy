/*
 * Copyright 2019 Grizzly Software, https://grizzlysoftware.pl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package pl.grizzlysoftware.dotykacka.client.v1.facade


import pl.grizzlysoftware.dotykacka.client.v1.api.service.CustomerService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification
import pl.grizzlysoftware.util.ResponseStatusException
import spock.lang.Unroll

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.CUSTOMER
import static pl.grizzlysoftware.util.CustomerUtils.randomCustomer
import static pl.grizzlysoftware.util.DotykackaApiInfo.API_URL
import static pl.grizzlysoftware.util.DotykackaApiInfo.CLOUD_ID
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class CustomerServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade;

    @Override
    void setup() {
        facade = new CustomerServiceFacade(CLOUD_ID, service(httpClient(), API_URL + CUSTOMER, CustomerService.class))
    }

    @Unroll
    def "throws ResponseStatusException with 404 status code when customer does not exist"(long id) {
        when:
            facade.getCustomer(id)
        then:
            def t = thrown(ResponseStatusException)
            t.statusCode == 404
        where:
            id << [0, 30, 490]
    }

    def "gets customer by id"() {
        given:
            def customer = randomCustomer()
        when:
            customer = facade.createCustomer(customer)
        then:
            def out = facade.getCustomer(customer.customerId)
        expect:
            out.customerId == customer.customerId
        cleanup:
            facade.deleteCustomer(customer.customerId)
    }

    def "gets all customers"() {
        given:
            def existingCustomers = facade.getAllCustomers()
        when:
            def customer = facade.createCustomer(randomCustomer())
        then:
            def customers = facade.getAllCustomers()
            customers.size() == existingCustomers.size() + 1
        cleanup:
            facade.deleteCustomer(customer.customerId)
    }

    def "gets set of customers"() {
        when:
            def existingCustomers = facade.getCustomers(5, 0)
        then:
            existingCustomers.size() <= 5
    }

    def "creates customer"() {
        given:
            def customer = randomCustomer()
        when:
            def out = facade.createCustomer(customer)
        then:
            out != null
            out.customerId != null
            out.firstName == customer.firstName
            out.lastName == customer.lastName
            out.email == customer.email
            out.note == customer.note
            out.phone == customer.phone
            out.birthday == customer.birthday
            out.barcode == customer.barcode
            out.points == customer.points
        cleanup:
            facade.deleteCustomer(out.customerId)
    }

    def "updates customer"() {
        given:
            def preCreateCustomer = randomCustomer()
        when:
            def preUpdateCustomer = facade.createCustomer(preCreateCustomer)
            preUpdateCustomer.firstName = "Jane"
        then:
            def postUpdateCustomer = facade.updateCustomer(preUpdateCustomer.customerId, preUpdateCustomer)
            postUpdateCustomer.customerId == preUpdateCustomer.customerId
            postUpdateCustomer.firstName != preCreateCustomer.firstName
            postUpdateCustomer.firstName == preUpdateCustomer.firstName
        cleanup:
            facade.deleteCustomer(postUpdateCustomer.customerId)
    }

    def "deletes customer"() {
        given:
            def customer = randomCustomer()
        when:
            def out = facade.createCustomer(customer)
            facade.deleteCustomer(out.customerId)
            customer = facade.getCustomer(out.customerId)
        then:
            customer.isDeleted == true
        cleanup:
            facade.deleteCustomer(out.customerId)
    }
}

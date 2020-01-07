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

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Employee
import pl.grizzlysoftware.dotykacka.client.v1.api.service.EmployeeService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification
import pl.grizzlysoftware.util.ResponseStatusException
import spock.lang.Unroll

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.EMPLOYEE
import static pl.grizzlysoftware.util.DotykackaApiInfo.API_URL
import static pl.grizzlysoftware.util.DotykackaApiInfo.CLOUD_ID
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class EmployeeServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade;

    @Override
    void setup() {
        facade = new EmployeeServiceFacade(CLOUD_ID, service(httpClient(), API_URL + EMPLOYEE, EmployeeService.class))
    }

    @Unroll
    def "throws ResponseStatusException with 404 status code when employee does not exist"(long id) {
        when:
            facade.getEmployee(id)
        then:
            def t = thrown(ResponseStatusException)
            t.statusCode == 404
        where:
            id << [1, 30, 490]
    }

    def "gets employee by id"() {
        given:
            def employee = new Employee()
            employee.name = "test_employee"
        when:
            employee = facade.createEmployee(employee)
        then:
            def out = facade.getEmployee(employee.id)
        expect:
            out.id == employee.id
        cleanup:
            facade.deleteEmployee(employee.id)
    }

    def "gets all employees"() {
        given:
            def existingEmployees = facade.getAllEmployees()
            def employee = new Employee()
            employee.name = "test_employee"
        when:
            def out = facade.createEmployee(employee)
        then:
            def employees = facade.getAllEmployees()
            employees.size() == existingEmployees.size() + 1
        cleanup:
            facade.deleteEmployee(out.id)
    }

    def "gets set of employees"() {
        when:
            def existingEmployees = facade.getEmployees(5, 0)
        then:
            existingEmployees != null
    }

    def "creates employee"() {
        given:
            def employee = new Employee()
            employee.name = "test_employee"
        when:
            def out = facade.createEmployee(employee)
        then:
            out != null
            out.id != null
        cleanup:
            facade.deleteEmployee(out.id)
    }

    def "updates employee"() {
        given:
            def preCreateEmployee = new Employee()
            preCreateEmployee.name = "John"
        when:
            def preUpdateEmployee = facade.createEmployee(preCreateEmployee)
            preUpdateEmployee.name = "Jane"
        then:
            def postUpdateEmployee = facade.updateEmployee(preUpdateEmployee.id, preUpdateEmployee)
            postUpdateEmployee.id == preUpdateEmployee.id
            postUpdateEmployee.name != preCreateEmployee.name
        cleanup:
            facade.deleteEmployee(postUpdateEmployee.id)
    }

    def "deletes employee"() {
        given:
            def employee = new Employee()
            employee.name = "John"
        when:
            def out = facade.createEmployee(employee)
            facade.deleteEmployee(out.id)
            employee = facade.getEmployee(out.id)
        then:
            employee.isDeleted == true
        cleanup:
            facade.deleteEmployee(out.id)
    }
}

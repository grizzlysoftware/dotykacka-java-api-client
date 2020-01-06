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

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Supplier
import pl.grizzlysoftware.dotykacka.client.v1.api.service.SupplierService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification
import pl.grizzlysoftware.util.ResponseStatusException
import spock.lang.Unroll

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.SUPPLIER
import static pl.grizzlysoftware.util.DotykackaApiInfo.API_URL
import static pl.grizzlysoftware.util.DotykackaApiInfo.CLOUD_ID
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class SupplierServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade;

    @Override
    void setup() {
        facade = new SupplierServiceFacade(CLOUD_ID, service(httpClient(), API_URL + SUPPLIER, SupplierService.class))
    }

    @Unroll
    def "throws ResponseStatusException with 404 status code when supplier does not exist"(long id) {
        when:
            facade.getSupplier(id)
        then:
            def t = thrown(ResponseStatusException)
            t.statusCode == 404
        where:
            id << [0, 30, 490]
    }

    def "gets supplier by id"() {
        given:
            def supplier = new Supplier()
            supplier.name = "test_supplier"
        when:
            supplier = facade.createSupplier(supplier)
        then:
            def out = facade.getSupplier(supplier.id)
        expect:
            out.id == supplier.id
        cleanup:
            facade.deleteSupplier(supplier.id)
    }

    def "gets all suppliers"() {
        given:
            def existingSuppliers = facade.getAllSuppliers()
            def supplier = new Supplier()
            supplier.name = "test_supplier"
        when:
            def out = facade.createSupplier(supplier)
        then:
            def suppliers = facade.getAllSuppliers()
            suppliers.size() == existingSuppliers.size() + 1
        cleanup:
            facade.deleteSupplier(out.id)
    }

    def "gets set of suppliers"() {
        when:
            def existingSuppliers = facade.getSuppliers(5, 0)
        then:
            existingSuppliers.size() <= 5
    }

    def "creates supplier"() {
        given:
            def supplier = new Supplier()
            supplier.name = "test_supplier"
        when:
            def out = facade.createSupplier(supplier)
        then:
            out != null
            out.id != null
        cleanup:
            facade.deleteSupplier(out.id)
    }

    def "updates supplier"() {
        given:
            def preCreateSupplier = new Supplier()
            preCreateSupplier.name = "John"
        when:
            def preUpdateSupplier = facade.createSupplier(preCreateSupplier)
            preUpdateSupplier.name = "Jane"
        then:
            def postUpdateSupplier = facade.updateSupplier(preUpdateSupplier.id, preUpdateSupplier)
            postUpdateSupplier.id == preUpdateSupplier.id
            postUpdateSupplier.name != preCreateSupplier.name
            postUpdateSupplier.name == preUpdateSupplier.name
        cleanup:
            facade.deleteSupplier(postUpdateSupplier.id)
    }

    def "deletes supplier"() {
        given:
            def supplier = new Supplier()
            supplier.name = "test_supplier"
        when:
            def out = facade.createSupplier(supplier)
            facade.deleteSupplier(out.id)
            supplier = facade.getSupplier(out.id)
        then:
            supplier.isDeleted == true
        cleanup:
            facade.deleteSupplier(out.id)
    }
}

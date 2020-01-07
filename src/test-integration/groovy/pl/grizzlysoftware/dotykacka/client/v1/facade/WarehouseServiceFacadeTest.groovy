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

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.Warehouse
import pl.grizzlysoftware.dotykacka.client.v1.api.service.WarehouseService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification
import pl.grizzlysoftware.util.ResponseStatusException
import spock.lang.Unroll

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.WAREHOUSE
import static pl.grizzlysoftware.util.DotykackaApiInfo.API_URL
import static pl.grizzlysoftware.util.DotykackaApiInfo.CLOUD_ID
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class WarehouseServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade;

    @Override
    void setup() {
        facade = new WarehouseServiceFacade(CLOUD_ID, service(httpClient(), API_URL + WAREHOUSE, WarehouseService.class))
    }

    @Unroll
    def "throws ResponseStatusException with 404 status code when warehouse does not exist"(long id) {
        when:
            facade.getWarehouse(id)
        then:
            def t = thrown(ResponseStatusException)
            t.statusCode == 404
        where:
            id << [0, 30, 490]
    }

    def "gets warehouse by id"() {
        given:
            def warehouse = new Warehouse()
            warehouse.name = "test_warehouse"
        when:
            warehouse = facade.createWarehouse(warehouse)
        then:
            def out = facade.getWarehouse(warehouse.id)
        expect:
            out.id == warehouse.id
        cleanup:
            facade.deleteWarehouse(warehouse.id)
    }

    def "gets all warehouses"() {
        given:
            def existingWarehouses = facade.getAllWarehouses()
            def warehouse = new Warehouse()
            warehouse.name = "test_warehouse"
        when:
            def out = facade.createWarehouse(warehouse)
        then:
            def warehouses = facade.getAllWarehouses()
            warehouses.size() == existingWarehouses.size() + 1
        cleanup:
            facade.deleteWarehouse(out.id)
    }

    def "gets set of warehouses"() {
        when:
            def existingWarehouses = facade.getWarehouses(5, 0)
        then:
            existingWarehouses.size() <= 5
    }

    def "creates warehouse"() {
        given:
            def warehouse = new Warehouse()
            warehouse.name = "test_warehouse"
        when:
            def out = facade.createWarehouse(warehouse)
        then:
            out != null
            out.id != null
        cleanup:
            facade.deleteWarehouse(out.id)
    }

    def "updates warehouse"() {
        given:
            def preCreateWarehouse = new Warehouse()
            preCreateWarehouse.name = "test_warehouse"
        when:
            def preUpdateWarehouse = facade.createWarehouse(preCreateWarehouse)
            preUpdateWarehouse.name = "test_warehouse_2"
        then:
            def postUpdateWarehouse = facade.updateWarehouse(preUpdateWarehouse.id, preUpdateWarehouse)
            postUpdateWarehouse.id == preUpdateWarehouse.id
            postUpdateWarehouse.name != preCreateWarehouse.name
            postUpdateWarehouse.name == preUpdateWarehouse.name
        cleanup:
            facade.deleteWarehouse(postUpdateWarehouse.id)
    }

    def "deletes warehouse"() {
        given:
            def warehouse = new Warehouse()
            warehouse.name = "test_warehouse"
        when:
            def out = facade.createWarehouse(warehouse)
            facade.deleteWarehouse(out.id)
            warehouse = facade.getWarehouse(out.id)
        then:
            warehouse.isDeleted == true
        cleanup:
            facade.deleteWarehouse(out.id)
    }
}

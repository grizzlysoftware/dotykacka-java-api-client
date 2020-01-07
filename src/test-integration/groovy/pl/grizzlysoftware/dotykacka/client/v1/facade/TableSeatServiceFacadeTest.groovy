package pl.grizzlysoftware.dotykacka.client.v1.facade

import pl.grizzlysoftware.dotykacka.client.v1.api.service.TableSeatService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification
import pl.grizzlysoftware.util.ResponseStatusException
import spock.lang.Unroll

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.BRANCH
import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.TABLESEAT
import static pl.grizzlysoftware.util.DotykackaApiInfo.*
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class TableSeatServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade

    @Override
    void setup() {
        facade = new TableSeatServiceFacade(CLOUD_ID, service(httpClient(), API_URL + TABLESEAT, TableSeatService.class))
    }

    @Unroll
    def "throws ResponseStatusException with 404 status code when table seat does not exist"(long id) {
        when:
            facade.getTableSeat(BRANCH_ID, id)
        then:
            def t = thrown(ResponseStatusException)
            t.statusCode == 404
        where:
            id << [0, 30, 490]
    }

    def "gets table seat"() {
        when:
            def out = facade.getTableSeat(BRANCH_ID, TABLESEAT_ID)
        then:
            out != null
            out.id == TABLESEAT_ID
    }

    def "gets table seats" () {
        when:
            def out = facade.getTableSeats(BRANCH_ID, 100, 0)
        then:
            out != null
    }

    def "gets all table seats" () {
        when:
            def out = facade.getTableSeats(BRANCH_ID)
        then:
            out != null
    }
}

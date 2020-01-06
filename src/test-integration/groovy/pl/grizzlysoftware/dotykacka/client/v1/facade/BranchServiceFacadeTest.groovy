package pl.grizzlysoftware.dotykacka.client.v1.facade

import pl.grizzlysoftware.dotykacka.client.v1.api.service.BranchService
import pl.grizzlysoftware.util.DotykackaSecureServiceSpecification

import static pl.grizzlysoftware.dotykacka.client.v1.api.util.DotykackaServiceContextPath.BRANCH
import static pl.grizzlysoftware.util.DotykackaApiInfo.API_URL
import static pl.grizzlysoftware.util.DotykackaApiInfo.BRANCH_ID
import static pl.grizzlysoftware.util.DotykackaApiInfo.CLOUD_ID
import static pl.grizzlysoftware.util.RetrofitUtils.service

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class BranchServiceFacadeTest extends DotykackaSecureServiceSpecification {
    def facade

    @Override
    void setup() {
        facade = new BranchServiceFacade(CLOUD_ID, service(httpClient(), API_URL + BRANCH, BranchService.class))
    }

    def "gets branch"() {
        when:
            def out = facade.getBranch(BRANCH_ID)
        then:
            out != null
            out.id == BRANCH_ID
    }

    def "gets branches" () {
        when:
            def out = facade.getBranches(100, 0)
        then:
            out != null
            def branch = out[0]
            branch.id == BRANCH_ID
    }

    def "gets all branches" () {
        when:
            def out = facade.getBranches()
        then:
            out != null
            def branch = out[0]
            branch.id == BRANCH_ID

    }
}

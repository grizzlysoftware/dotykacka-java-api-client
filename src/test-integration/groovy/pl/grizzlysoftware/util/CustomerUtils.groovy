package pl.grizzlysoftware.util

import pl.grizzlysoftware.dotykacka.client.v1.api.dto.customer.Customer

import static java.lang.System.currentTimeMillis

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
class CustomerUtils {
    static def "randomCustomer"() {
        def out = new Customer()
        out.firstName = "John"
        out.lastName = "Doe"
        out.email = "john@doe.pl"
        out.note = "some note"
        out.phone = "4879312123"
        out.birthday = currentTimeMillis() - 630_720_00
        out.barcode = "some barcode"
        out.points = 997
        return out
    }

    static def "customer"(firstName, lastName, email, note, phone, birthday, barcode, points) {
        def out = new Customer()
        out.firstName = firstName
        out.lastName = lastName
        out.email = email
        out.note = note
        out.phone = phone
        out.birthday = birthday
        out.barcode = barcode
        out.points = points
        return out
    }
}

package pl.grizzlysoftware.dotykacka.client.v1.api.dto.sales;

/**
 * @author Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 */
public enum ReceiptItemDateFields {
    INSERTED("inserted"),
    COMPLETED("completed"),
    UPDATED("updated"),
    VERSION_DATE("versiondate"),
    CANCELED_DATE("canceleddate");

    public final String name;
    ReceiptItemDateFields(String name) {
        this.name = name;
    }
}

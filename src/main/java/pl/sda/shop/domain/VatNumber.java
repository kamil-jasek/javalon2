package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;
import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Embeddable
public final class VatNumber {

    @Column(name = "vat_number")
    private String value;

    @JpaOnly
    private VatNumber() {}

    public VatNumber(String value) {
        PreconditionUtil.requireNonNull(value);
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        // validate vat number
    }

    public String getValue() {
        return value;
    }
}

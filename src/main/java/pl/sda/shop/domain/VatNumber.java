package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Embeddable
final class VatNumber {

    private String value;

    // for jpa
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatNumber vatNumber = (VatNumber) o;
        return value.equals(vatNumber.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

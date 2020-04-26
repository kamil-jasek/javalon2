package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class VatNumber {

    private final String value;

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

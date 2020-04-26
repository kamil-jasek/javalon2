package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class Company extends Customer {

    private final VatNumber vatNumber;

    public Company(String name, VatNumber vatNumber) {
        super(name, vatNumber.getValue());
        this.vatNumber = vatNumber;
    }

    public VatNumber getVatNumber() {
        return vatNumber;
    }
}

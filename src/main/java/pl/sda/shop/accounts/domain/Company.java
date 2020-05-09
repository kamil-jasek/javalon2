package pl.sda.shop.accounts.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Entity
@DiscriminatorValue("company")
final class Company extends Customer {

    @Embedded
    private VatNumber vatNumber;

    @JpaOnly
    private Company() {
    }

    public Company(String name, VatNumber vatNumber) {
        super(name, vatNumber.getValue());
        this.vatNumber = vatNumber;
    }

    public VatNumber getVatNumber() {
        return vatNumber;
    }
}

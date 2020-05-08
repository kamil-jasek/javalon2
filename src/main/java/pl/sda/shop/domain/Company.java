package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.Objects;

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

    private Company() {
        super();
    }

    public Company(String name, VatNumber vatNumber) {
        super(name, vatNumber.getValue());
        this.vatNumber = vatNumber;
    }

    public VatNumber getVatNumber() {
        return vatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return vatNumber.equals(company.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vatNumber);
    }
}

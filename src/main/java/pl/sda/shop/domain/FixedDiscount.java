package pl.sda.shop.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Entity
@DiscriminatorValue("fixed")
final class FixedDiscount extends OrderDiscount {

    @JpaOnly
    private FixedDiscount() {}

    public FixedDiscount(double discount) {
        super(discount);
    }
}

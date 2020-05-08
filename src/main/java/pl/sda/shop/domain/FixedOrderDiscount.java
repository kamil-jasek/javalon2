package pl.sda.shop.domain;

import pl.sda.shop.annotation.JpaOnly;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-08
 */
@Entity
@DiscriminatorValue("fixed_discount")
public final class FixedOrderDiscount extends OrderDiscount {

    @JpaOnly
    private FixedOrderDiscount() {}

    public FixedOrderDiscount(double discount) {
        super(discount);
    }
}

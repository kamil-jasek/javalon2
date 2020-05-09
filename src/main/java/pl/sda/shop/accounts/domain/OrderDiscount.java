package pl.sda.shop.accounts.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Entity
@Table(name = "order_discount")
@Inheritance
@DiscriminatorColumn(name = "discount_type")
abstract class OrderDiscount {

    @Id
    private UUID id;

    private double discount;

    @JpaOnly
    protected OrderDiscount() {}

    OrderDiscount(double discount) {
        validate(discount);
        this.id = UUID.randomUUID();
        this.discount = discount;
    }

    private void validate(double discount) {
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("Invalid discount: " + discount);
        }
    }

    public UUID getId() {
        return id;
    }

    public double getDiscount() {
        return discount;
    }

    BigDecimal getDecimalDiscount() {
        return BigDecimal.valueOf(discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDiscount discount1 = (OrderDiscount) o;
        return Double.compare(discount1.discount, discount) == 0 &&
                id.equals(discount1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount);
    }
}

package pl.sda.shop.domain;

import pl.sda.shop.annotation.JpaOnly;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static pl.sda.shop.util.PreconditionUtil.checkArgument;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-08
 */
@Entity
@Table(name = "order_discount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "order_discount_type", discriminatorType = DiscriminatorType.STRING)
abstract class OrderDiscount {

    @Id
    private UUID id;

    private double value;

    @JpaOnly
    protected OrderDiscount() {}

    protected OrderDiscount(double discount) {
        checkArgument(discount > 0 && discount < 1, "Invalid discount");
        this.id = UUID.randomUUID();
        this.value = discount;
    }

    public UUID getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDiscount that = (OrderDiscount) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package pl.sda.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-29
 */
@Entity
@Table(name = "discount_coupons")
final class Coupon {

    @Id
    private String code;

    private double discount;

    // for jpa
    private Coupon() {
    }

    public Coupon(String code, double discount) {
        requireNonNull(code, discount);
        this.code = code;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Double.compare(coupon.discount, discount) == 0 &&
                code.equals(coupon.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, discount);
    }
}

package pl.sda.shop.accounts.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.util.Objects;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Entity
@DiscriminatorValue("coupon")
final class CouponDiscount extends OrderDiscount {

    private String coupon;

    @JpaOnly
    private CouponDiscount() {}

    public CouponDiscount(String coupon, double discount) {
        super(discount);
        requireNonNull(coupon);
        this.coupon = coupon;
    }

    public String getCoupon() {
        return coupon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CouponDiscount that = (CouponDiscount) o;
        return coupon.equals(that.coupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coupon);
    }
}

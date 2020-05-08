package pl.sda.shop.domain;

import pl.sda.shop.annotation.JpaOnly;
import pl.sda.shop.util.PreconditionUtil;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.util.Objects;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-08
 */
@Entity
@DiscriminatorValue("coupon_discount")
public final class CouponOrderDiscount extends OrderDiscount {

    private String code;

    @JpaOnly
    private CouponOrderDiscount() {}

    public CouponOrderDiscount(String code, double discount) {
        super(discount);
        requireNonNull(code);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CouponOrderDiscount that = (CouponOrderDiscount) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code);
    }
}

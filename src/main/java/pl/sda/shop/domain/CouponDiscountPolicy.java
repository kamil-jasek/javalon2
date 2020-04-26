package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

import java.math.BigDecimal;
import java.util.List;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class CouponDiscountPolicy implements DiscountPolicy {

    private final List<String> coupons;
    private final String coupon;
    private final float discount;

    public CouponDiscountPolicy(List<String> coupons, String coupon, float discount) {
        requireNonNull(coupons, coupon);
        this.coupons = coupons;
        this.coupon = coupon;
        this.discount = discount;
    }

    @Override
    public BigDecimal calculate(Order order) {
        if (coupons.contains(coupon)) {
             return getDiscount(order);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getDiscount(Order order) {
        BigDecimal result = BigDecimal.ZERO;
        for (Item item : order.getItems()) {
            // result = result + (price * quantity)
            result = result.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        // total price * discount = 100 * 0.2 = 20
        return result.multiply(BigDecimal.valueOf(discount));
    }
}

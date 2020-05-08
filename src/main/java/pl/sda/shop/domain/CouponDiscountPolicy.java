package pl.sda.shop.domain;

import java.math.BigDecimal;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
final class CouponDiscountPolicy implements DiscountPolicy {

    private final CouponRepository repository;
    private final String discountCode;

    public CouponDiscountPolicy(CouponRepository repository, String discountCode) {
        requireNonNull(discountCode);
        this.repository = repository;
        this.discountCode = discountCode;
    }

    @Override
    public BigDecimal calculate(Order order) {
        return repository.find(discountCode)
                .map(coupon -> getDiscount(order, coupon))
                .orElse(BigDecimal.ZERO);
    }

    public String getDiscountCode() {
        return discountCode;
    }

    private BigDecimal getDiscount(Order order, Coupon coupon) {
        BigDecimal result = BigDecimal.ZERO;
        for (Item item : order.getItems()) {
            // result = result + (price * quantity)
            result = result.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        // total price * discount = 100 * 0.2 = 20
        return result.multiply(BigDecimal.valueOf(coupon.getDiscount()));
    }
}

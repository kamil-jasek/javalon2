package pl.sda.shop.domain;

import java.math.BigDecimal;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class FixedDiscountPolicy implements DiscountPolicy {

    // 0.2 = 20%
    private final float discount;

    public FixedDiscountPolicy(float discount) {
        if (discount <= 0 || discount >= 1) {
            throw new IllegalArgumentException("discount is invalid");
        }
        this.discount = discount;
    }

    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal result = BigDecimal.ZERO;
        for (Item item : order.getItems()) {
            // result = result + (price * quantity)
            result = result.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        // total price * discount = 100 * 0.2 = 20
        return result.multiply(BigDecimal.valueOf(discount));
    }
}

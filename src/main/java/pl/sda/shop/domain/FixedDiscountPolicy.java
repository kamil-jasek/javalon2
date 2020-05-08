package pl.sda.shop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
final class FixedDiscountPolicy implements DiscountPolicy {

    // 0.2 = 20%
    private float discount;

    // for jpa
    private FixedDiscountPolicy() {}

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

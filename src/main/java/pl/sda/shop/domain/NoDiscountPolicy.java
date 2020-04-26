package pl.sda.shop.domain;

import java.math.BigDecimal;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public BigDecimal calculate(Order order) {
        return BigDecimal.ZERO;
    }
}

package pl.sda.shop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
final class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public BigDecimal calculate(Order order) {
        return BigDecimal.ZERO;
    }
}

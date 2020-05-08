package pl.sda.shop.domain;

import java.math.BigDecimal;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
interface DiscountPolicy {

    BigDecimal calculate(Order order);
}

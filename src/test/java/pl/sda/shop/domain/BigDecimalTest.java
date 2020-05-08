package pl.sda.shop.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
final class BigDecimalTest {

    @Test
    void test() {
        BigDecimal number = BigDecimal.valueOf(344.33333);

        System.out.println(number.setScale(2, RoundingMode.HALF_UP));
    }
}

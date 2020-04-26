package pl.sda.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.shop.domain.Item;
import pl.sda.shop.domain.NoDiscountPolicy;
import pl.sda.shop.domain.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
final class NoDiscountPolicyTest {

    @Test
    void testNoDiscount() {
        // given
        List<Item> items = new ArrayList<>();
        items.add(new Item("Klocki lego", BigDecimal.valueOf(24.50), 2));
        Order order = new Order(items, new NoDiscountPolicy());

        // when
        BigDecimal result = order.getTotalPrice();

        // then
        assertEquals(BigDecimal.valueOf(49.00), result);
    }
}

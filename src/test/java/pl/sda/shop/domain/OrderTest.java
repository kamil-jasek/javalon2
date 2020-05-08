package pl.sda.shop.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-28
 */
@SpringBootTest
final class OrderTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void test() {
        final List<Item> items = new ArrayList<>();
        items.add(new Item("Klocki lego", BigDecimal.valueOf(24.50), 2));
        final Order writeOrder = new Order(items);

        em.persist(writeOrder);
        em.flush();
        em.clear();

        final Order readOrder = em.find(Order.class, writeOrder.getId());

        assertEquals(readOrder, writeOrder);
    }

    @Test
    @Transactional
    void testApplyDiscount() {
        final List<Item> items = new ArrayList<>();
        items.add(new Item("Klocki lego", BigDecimal.valueOf(24.50), 2));
        final Order writeOrder = new Order(items);
        final OrderDiscount discount = new FixedOrderDiscount(0.2);
        writeOrder.applyDiscount(discount);

        em.persist(writeOrder);
        em.flush();
        em.clear();

        final Order readOrder = em.find(Order.class, writeOrder.getId());
        assertEquals(readOrder, writeOrder);
        assertEquals(new BigDecimal("39.20"), readOrder.getTotalPrice());
    }
}

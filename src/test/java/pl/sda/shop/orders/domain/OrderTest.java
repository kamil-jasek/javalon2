package pl.sda.shop.orders.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shop.accounts.domain.AccountFacade;
import pl.sda.shop.accounts.domain.dto.CreatePersonAccountDto;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@SpringBootTest
final class OrderTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private AccountFacade facade;

    @Test
    @Transactional
    void testOrderWithFixedDiscount() {
        var accountId = facade.createPersonAccount(new CreatePersonAccountDto("Test", "Test", "PL94994949"));
        var order = new Order(accountId, asList(
                new Item("item1", BigDecimal.valueOf(20), 1),
                new Item("item2", BigDecimal.valueOf(15), 2)
        ));

        assertEquals(new BigDecimal("50.00"), order.getTotalPrice());

        order.applyDiscount(new FixedDiscount(0.5));
        assertEquals(new BigDecimal("25.00"), order.getTotalPrice());

        em.persist(order);
        em.flush();
        em.clear();

        var readOrder = em.find(Order.class, order.getId());
        assertEquals(readOrder, order);
        assertEquals(readOrder.getTotalPrice(), order.getTotalPrice());
    }

    @Test
    @Transactional
    void testOrderWithCouponDiscount() {
        var accountId = facade.createPersonAccount(new CreatePersonAccountDto("Test", "Test", "PL94994949"));
        var order = new Order(accountId, asList(
                new Item("test", new BigDecimal("10"), 1)
        ));
        order.applyDiscount(new CouponDiscount("ABC100", 0.2));

        em.persist(order);
        em.flush();
        em.clear();

        var readOrder = em.find(Order.class, order.getId());
        assertEquals(new BigDecimal("8.00"), readOrder.getTotalPrice());
        assertEquals(readOrder, order);
    }
}

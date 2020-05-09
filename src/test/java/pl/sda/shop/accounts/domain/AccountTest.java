package pl.sda.shop.accounts.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
final class AccountTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void testCreateAccount() {
        var account = new Account(new Company("Test S.A.", new VatNumber("PL993993939")));
        account.getCustomer()
                .addAddress(new Address("Test1", "02-500", "Wawa", "PL"));
        var order = new Order(asList(
                new Item("test", new BigDecimal("10"), 1)
        ));
        order.applyDiscount(new CouponDiscount("ABC400", 0.3));
        account.addOrder(order);

        em.persist(account);
        em.flush();
        em.clear();

        var readAccount = em.find(Account.class, account.getId());
        assertEquals(readAccount, account);
        assertEquals(new BigDecimal("7.00"), readAccount.getOrders()
                .get(0).getTotalPrice());
    }
}

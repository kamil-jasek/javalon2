package pl.sda.shop.accounts.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shop.accounts.domain.Account;
import pl.sda.shop.accounts.domain.Address;
import pl.sda.shop.accounts.domain.Company;
import pl.sda.shop.accounts.domain.VatNumber;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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


        em.persist(account);
        em.flush();
        em.clear();

        var readAccount = em.find(Account.class, account.getId());
        assertEquals(readAccount, account);
    }
}

package pl.sda.shop.accounts.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
final class AddressTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void testSaveAddress() {
        var address = new Address("Street", "01-500", "Wawa", "PL");

        em.persist(address);
        em.flush();
        em.clear();

        var readAddress = em.find(Address.class, address.getId());
        assertEquals(readAddress, address);
    }
}

package pl.sda.shop.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shop.domain.Address;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-27
 */
@SpringBootTest
final class AddressTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void createAddress() {
        final Address address = new Address("Test", "02300", "London", "UK");
        em.persist(address);
        em.flush();
        em.clear();

        final Address readAddress = em.find(Address.class, address.getId());
        assertEquals(readAddress, address);
    }
}

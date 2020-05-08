package pl.sda.shop.domain;

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
 * @since 2020-04-27
 */
@SpringBootTest
final class CustomerTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void createCompany() {
        Customer customer = new Company("test", new VatNumber("PL93883883"));
        em.persist(customer);
        em.flush();
        em.clear();

        final Customer readCustomer = em.find(Customer.class, customer.getId());
        assertEquals(readCustomer, customer);
    }
}

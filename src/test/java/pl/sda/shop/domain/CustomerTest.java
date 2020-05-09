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
 * @since 2020-05-09
 */
@SpringBootTest
final class CustomerTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void testCreatePerson() {
        var person = new Person("Jan", "Kowalski", "PL39399393");
        person.addAddress(new Address("Test", "01-500", "Wawa", "PL"));

        persistAndClear(person);

        var readPerson = em.find(Person.class, person.getId());
        assertEquals(readPerson, person);
    }

    @Test
    @Transactional
    void testCreateCompany() {
        var company = new Company("Company S.A.", new VatNumber("PL9399393"));
        company.addAddress(new Address("Test", "01-500", "Wawa", "PL"));

        persistAndClear(company);

        var readCompany = em.find(Company.class, company.getId());
        assertEquals(readCompany, company);
    }

    private void persistAndClear(Object entity) {
        em.persist(entity);
        em.flush();
        em.clear();
    }
}

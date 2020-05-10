package pl.sda.shop.accounts.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shop.accounts.domain.dto.CreatePersonAccountDto;
import pl.sda.shop.accounts.domain.dto.PersonQueryDto;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@SpringBootTest
final class AccountFacadeTest {

    @Autowired
    private AccountFacade facade;

    @Autowired
    private AccountRepository repository;

    @Test
    @Transactional
    void testCreatePerson() {
        // given
        var dto = new CreatePersonAccountDto("Jan", "Kowalski", "PL939939");

        // when
        var accountId = facade.createPersonAccount(dto);

        // then
        assertNotNull(accountId);

        var account = repository.findById(accountId);
        assertNotNull(account);
    }

    @Test
    @Transactional
    void testFindPersons() {
        // given
        facade.createPersonAccount(new CreatePersonAccountDto("Jan", "Kowalski", "PL93939"));
        facade.createPersonAccount(new CreatePersonAccountDto("Adam", "Nowak", "PL93939393"));

        // when
        var persons = facade.findPersonsByLastName("kowals");

        // then
        assertEquals(1, persons.size());
    }

    @Test
    @Transactional
    void testFilterPerson() {
        // given
        facade.createPersonAccount(new CreatePersonAccountDto("Jan", "Kowalski", "PL93939"));
        facade.createPersonAccount(new CreatePersonAccountDto("Adam", "Nowak", "PL93939393"));

        // when
        var persons = facade.filterPerson(new PersonQueryDto(null, null));
        // then
        assertEquals(2, persons.size());

        // when
        persons = facade.filterPerson(new PersonQueryDto("Jan", null));
        // then
        assertEquals(1, persons.size());

        // when
        persons = facade.filterPerson(new PersonQueryDto("Ad", "Now"));
        // then
        assertEquals(1, persons.size());
    }
}

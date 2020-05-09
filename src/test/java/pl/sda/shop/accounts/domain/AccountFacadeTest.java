package pl.sda.shop.accounts.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shop.accounts.domain.command.CreateAccountCommand;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@SpringBootTest
final class AccountFacadeTest {

    @Autowired
    private AccountFacade facade;

    @Autowired
    private AccountRepository repository;

    @Test
    @Transactional
    void testCreateAccount() {
        var cmd = new CreateAccountCommand(
                new CreateAccountCommand.Person("Jan", "Kowalski", "PL93939"));

        facade.createAccount(cmd);

        var count = repository.count();
        assertEquals(1, count);
    }
}

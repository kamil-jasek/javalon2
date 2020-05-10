package pl.sda.shop.accounts.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.shop.orders.domain.OrderFacade;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Configuration
class AccountFacadeConfig {

    @Bean
    AccountFacade accountFacade(AccountRepository repository,
                                OrderFacade orderFacade,
                                PersonRepository personRepository) {
        return new AccountFacade(
                new AccountMapper(),
                repository,
                orderFacade,
                personRepository);
    }
}

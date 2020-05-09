package pl.sda.shop.accounts.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Configuration
class AccountFacadeConfig {

    @Bean
    AccountFacade facade(AccountRepository repository) {
        return new AccountFacade(new CommandMapper(), repository);
    }
}

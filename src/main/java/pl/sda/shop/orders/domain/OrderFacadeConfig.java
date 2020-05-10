package pl.sda.shop.orders.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Configuration
class OrderFacadeConfig {

    @Bean
    OrderFacade orderFacade(OrderRepository repository) {
        return new OrderFacade(new OrderMapper(), repository);
    }
}

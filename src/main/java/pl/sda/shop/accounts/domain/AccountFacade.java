package pl.sda.shop.accounts.domain;

import lombok.RequiredArgsConstructor;
import pl.sda.shop.accounts.domain.command.CreateAccountCommand;
import pl.sda.shop.accounts.domain.query.OrdersQuery;

import javax.transaction.Transactional;
import java.util.List;

import static pl.sda.shop.accounts.domain.OrderSpecs.withQuery;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@RequiredArgsConstructor
public class AccountFacade {

    private final CommandMapper mapper;
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void createAccount(CreateAccountCommand cmd) {
        var customer = mapper.map(cmd.getCustomer());
        var account = new Account(customer);
        accountRepository.save(account);
    }

    public List findOrders(OrdersQuery query) {
        return orderRepository.findAll(withQuery(query));
    }
}

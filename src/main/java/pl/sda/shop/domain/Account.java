package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

import java.util.ArrayList;
import java.util.List;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class Account {

    private final Customer customer;
    private final List<Order> orders;

    public Account(Customer customer) {
        requireNonNull(customer);
        this.customer = customer;
        this.orders = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // methods for add order and remove order
}

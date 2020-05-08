package pl.sda.shop.domain;

import pl.sda.shop.annotation.JpaOnly;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Entity
@Table(name = "accounts")
final class Account {

    @Id
    private UUID id;

    @OneToOne
    private Customer customer;

    @OneToMany
    private List<Order> orders;

    @JpaOnly
    private Account() {
    }

    public Account(Customer customer) {
        requireNonNull(customer);
        this.id = UUID.randomUUID();
        this.customer = customer;
        this.orders = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // methods for add order and remove order
}

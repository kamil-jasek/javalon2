package pl.sda.shop.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public final class Account {

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
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
    public void addOrder(Order order) {
        requireNonNull(order);
        if (!orders.contains(order)) {
            orders.add(order);
        }
    }

    public Order removeOrder(int idx) {
        if (idx >= 0 && idx < orders.size()) {
            return orders.remove(idx);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) &&
                customer.equals(account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer);
    }
}

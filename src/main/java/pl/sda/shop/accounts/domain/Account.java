package pl.sda.shop.accounts.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.*;
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
final class Account {

    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @JpaOnly
    private Account() {
    }

    public Account(Customer customer) {
        requireNonNull(customer);
        this.id = UUID.randomUUID();
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
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

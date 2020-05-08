package pl.sda.shop.domain;

import javax.persistence.*;
import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type", discriminatorType = DiscriminatorType.STRING)
abstract class Customer {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String taxId;

    @OneToMany
    private List<Address> addresses = emptyList();

    // for jpa
    protected Customer() {}

    Customer(String name, String taxId) {
        requireNonNull(name, taxId);
        this.id = UUID.randomUUID();
        this.name = name;
        this.taxId = taxId;
        this.addresses = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void addAddress(Address address) {
        if (!addresses.contains(address)) {
            addresses.add(address);
        }
    }

    public List<Address> getAddresses() {
        return new ArrayList<>(addresses);
    }

    public Address removeAddress(int idx) {
        if (idx >= 0 && idx < addresses.size()) {
            return addresses.remove(idx);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                name.equals(customer.name) &&
                taxId.equals(customer.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, taxId);
    }
}

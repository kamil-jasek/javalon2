package pl.sda.shop.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public abstract class Customer {

    private final String name;
    private final String taxId;
    private final List<Address> addresses;

    protected Customer(String name, String taxId) {
        requireNonNull(name, taxId);
        this.name = name;
        this.taxId = taxId;
        this.addresses = new ArrayList<>();
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
}

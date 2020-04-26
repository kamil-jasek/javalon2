package pl.sda.shop.domain;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class Person extends Customer {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName, String taxId) {
        super(firstName + " " + lastName, taxId);
        requireNonNull(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

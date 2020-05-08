package pl.sda.shop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Entity
@DiscriminatorValue("person")
final class Person extends Customer {

    private String firstName;
    private String lastName;

    // for jpa
    private Person() {}

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

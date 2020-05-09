package pl.sda.shop.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Entity
@DiscriminatorValue("person")
public final class Person extends Customer {

    private String firstName;
    private String lastName;

    @JpaOnly
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

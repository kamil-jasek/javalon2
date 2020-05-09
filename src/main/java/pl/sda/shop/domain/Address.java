package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;
import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "addresses")
public final class Address {

    @Id
    private UUID id;

    private String street;
    private String zipCode;
    private String city;
    private String country;

    @JpaOnly
    private Address() {}

    Address(String street, String zipCode, String city, String country) {
        requireNonNull(street, zipCode, city, country);
        this.id = UUID.randomUUID();
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) &&
                street.equals(address.street) &&
                zipCode.equals(address.zipCode) &&
                city.equals(address.city) &&
                country.equals(address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, zipCode, city, country);
    }
}

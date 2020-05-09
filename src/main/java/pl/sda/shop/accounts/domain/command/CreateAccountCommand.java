package pl.sda.shop.accounts.domain.command;

import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Value
public final class CreateAccountCommand {

    public static abstract class Customer {}

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static final class Person extends Customer {
        String firstName;
        String lastName;
        String taxId;
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    public static final class Company extends Customer {
        String name;
        String vatNumber;
    }

    Customer customer;
}

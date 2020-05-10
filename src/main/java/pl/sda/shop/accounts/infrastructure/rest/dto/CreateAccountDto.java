package pl.sda.shop.accounts.infrastructure.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Data
public final class CreateAccountDto {

    public enum AccountType {
        PERSON, COMPANY
    }

    @NotNull
    private AccountType type;

    private String firstName;
    private String lastName;
    private String taxId;

    private String name;
}

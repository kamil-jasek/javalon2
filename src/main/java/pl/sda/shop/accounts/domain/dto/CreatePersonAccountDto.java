package pl.sda.shop.accounts.domain.dto;

import lombok.Value;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Value
public final class CreatePersonAccountDto {

    private String firstName;
    private String lastName;
    private String taxId;
}

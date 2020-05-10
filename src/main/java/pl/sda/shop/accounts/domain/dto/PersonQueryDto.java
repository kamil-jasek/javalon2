package pl.sda.shop.accounts.domain.dto;

import lombok.Value;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Value
public final class PersonQueryDto {

    private String firstName;
    private String lastName;
}

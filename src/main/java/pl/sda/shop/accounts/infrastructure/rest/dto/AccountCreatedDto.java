package pl.sda.shop.accounts.infrastructure.rest.dto;

import lombok.Value;

import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Value
public final class AccountCreatedDto {

    private UUID accountId;
}

package pl.sda.shop.accounts.domain.dto;

import lombok.Value;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Value
final class OrderResult {

    private String status;
    private String id;
}

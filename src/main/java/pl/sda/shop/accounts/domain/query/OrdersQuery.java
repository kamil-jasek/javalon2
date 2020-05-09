package pl.sda.shop.accounts.domain.query;

import lombok.Value;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
@Value
public final class OrdersQuery {
    private String status;
    private String productName;
}

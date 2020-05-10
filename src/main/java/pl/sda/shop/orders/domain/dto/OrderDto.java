package pl.sda.shop.orders.domain.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@Value
public final class OrderDto {

    private UUID id;
    private String status;
    private BigDecimal totalPrice;
}

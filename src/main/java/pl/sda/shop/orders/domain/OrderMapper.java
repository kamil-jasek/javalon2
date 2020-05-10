package pl.sda.shop.orders.domain;

import pl.sda.shop.orders.domain.dto.OrderDto;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
final class OrderMapper {

    OrderDto map(Order order) {
        return new OrderDto(order.getId(), order.getStatus().name(), order.getTotalPrice());
    }
}

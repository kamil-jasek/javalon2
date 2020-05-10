package pl.sda.shop.orders.domain;

import lombok.RequiredArgsConstructor;
import pl.sda.shop.orders.domain.dto.OrderDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@RequiredArgsConstructor
public final class OrderFacade {

    private final OrderMapper mapper;
    private final OrderRepository repository;

    public void createOrder() {

    }

    public List<OrderDto> listOrders(UUID accountId) {
        return repository.findAllByAccountId(accountId)
                .stream()
                .map(mapper::map)
                .collect(toList());
    }
}

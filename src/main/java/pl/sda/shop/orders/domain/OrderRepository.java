package pl.sda.shop.orders.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
interface OrderRepository extends JpaRepository<Order, UUID> {

    // from Order where accountId = :accountId
    List<Order> findAllByAccountId(UUID accountId);
}

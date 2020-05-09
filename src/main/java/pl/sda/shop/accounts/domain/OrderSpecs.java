package pl.sda.shop.accounts.domain;

import org.springframework.data.jpa.domain.Specification;
import pl.sda.shop.accounts.domain.query.OrdersQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
final class OrderSpecs {

    static Specification<Order> withQuery(OrdersQuery query) {
        return (root, cq, cb) -> {
            cq.distinct(true);
            return Stream.of(
                filterProductName(query.getProductName(), root, cb),
                filterStatus(query.getStatus(), root, cb))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .reduce(cb.conjunction(), cb::and);
        };
    }

    private static Optional<Predicate> filterProductName(String name, Root<Order> root, CriteriaBuilder cb) {
        return Optional.ofNullable(name).map(value -> {
            var items = root.join(Order_.items);
            return cb.like(items.get(Item_.name), name + "%");
        });
    }

    private static Optional<Predicate> filterStatus(String status, Root<Order> root, CriteriaBuilder cb) {
        return Optional.ofNullable(status)
                .map(OrderStatus::valueOf)
                .map(value -> cb.equal(root.get(Order_.status), value));
    }

}

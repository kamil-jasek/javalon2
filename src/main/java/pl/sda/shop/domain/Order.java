package pl.sda.shop.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
@Entity
@Table(name = "customer_orders")
final class Order {

    @Id
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderDiscount discount;

    // for jpa
    private Order() {
    }

    public Order(List<Item> items) {
        requireNonNull(items);
        this.id = UUID.randomUUID();
        this.items = items;
        this.status = OrderStatus.IN_PROGRESS;
    }

    public UUID getId() {
        return id;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (Item item : items) {
            // result = result + (price * quantity)
            result = result.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        BigDecimal discountPercent = getDiscountPercent();
        // result - (result * discount)
        return result.subtract(result.multiply(discountPercent)).setScale(2, RoundingMode.HALF_UP);
    }

    public void applyDiscount(OrderDiscount discount) {
        requireNonNull(discount);
        this.discount = discount;
    }

    private BigDecimal getDiscountPercent() {
        return discount != null ? BigDecimal.valueOf(discount.getValue()) : BigDecimal.ZERO;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package pl.sda.shop.domain;

import pl.sda.shop.util.PreconditionUtil;

import java.math.BigDecimal;
import java.util.List;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class Order {

    private final List<Item> items;
    private final DiscountPolicy discountPolicy;
    private OrderStatus status;

    public Order(List<Item> items, DiscountPolicy discountPolicy) {
        requireNonNull(items, discountPolicy);
        this.items = items;
        this.discountPolicy = discountPolicy;
        this.status = OrderStatus.IN_PROGRESS;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (Item item : items) {
            // result = result + (price * quantity)
            result = result.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return result.subtract(discountPolicy.calculate(this));
    }

    public OrderStatus getStatus() {
        return status;
    }
}

package pl.sda.shop.domain;

import java.math.BigDecimal;
import java.util.Objects;

import static pl.sda.shop.util.PreconditionUtil.requireNonNull;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class Item {

    private final String name;
    private final BigDecimal price;
    private final int quantity;

    public Item(String name, BigDecimal price, int quantity) {
        requireNonNull(name, price);
        validatePrice(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void validatePrice(BigDecimal price) {
        int comparison = price.compareTo(BigDecimal.ZERO);
        if (comparison <= 0) {
            throw new IllegalArgumentException("Price is invalid. Should be above 0.");
        }
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity &&
                name.equals(item.name) &&
                price.equals(item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}

package pl.sda.shop.accounts.domain;

import pl.sda.shop.util.annotation.JpaOnly;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
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
@Table(name = "order_items")
final class Item {

    @Id
    private UUID id;

    private String name;
    private BigDecimal price;
    private int quantity;

    @JpaOnly
    private Item() {}

    public Item(String name, BigDecimal price, int quantity) {
        requireNonNull(name, price);
        validatePrice(price);
        this.id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
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
                id.equals(item.id) &&
                name.equals(item.name) &&
                price.equals(item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }
}

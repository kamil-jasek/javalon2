package pl.sda.shop.util;

import java.util.Objects;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-26
 */
public final class PreconditionUtil {

    public static void requireNonNull(Object ...args) {
        for (Object obj : args) {
            Objects.requireNonNull(obj);
        }
    }

    public static void checkArgument(boolean valid, String message) {
        if (!valid) {
            throw new IllegalArgumentException(message);
        }
    }
}

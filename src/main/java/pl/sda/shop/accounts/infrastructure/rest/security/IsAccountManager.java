package pl.sda.shop.accounts.infrastructure.rest.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-16
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('ACCOUNT_MANAGER')")
public @interface IsAccountManager {
}

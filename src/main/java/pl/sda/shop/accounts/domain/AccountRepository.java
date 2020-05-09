package pl.sda.shop.accounts.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
interface AccountRepository extends JpaRepository<Account, UUID> {
}

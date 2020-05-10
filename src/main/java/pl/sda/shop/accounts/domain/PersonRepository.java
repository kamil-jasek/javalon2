package pl.sda.shop.accounts.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {
}

package pl.sda.shop.accounts.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("from Person p where lower(p.lastName) like lower(:lastName)")
    List<Person> findByLastName(@Param("lastName") String lastName);
}

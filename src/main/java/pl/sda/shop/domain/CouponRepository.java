package pl.sda.shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.shop.domain.Coupon;

import java.util.Optional;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-04-29
 */
interface CouponRepository extends JpaRepository<Coupon, String> {

    @Query("from Coupon c where c.code = ?1")
    Optional<Coupon> find(String code);
}

package pl.sda.shop.accounts.domain;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import pl.sda.shop.accounts.domain.dto.PersonQueryDto;

import javax.persistence.criteria.Predicate;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
final class PersonSpecs {

    static Specification<Person> withQuery(PersonQueryDto queryDto) {
        return (root, query, criteria) -> {
            // where firstName like :firstName% and lastName like :lastName%
            // where lastName = :lastName

            var predicate = criteria.conjunction(); // where 1=1

            if (queryDto.getFirstName() != null) {
                var firstNamePredicate = criteria.like(root.get("firstName"), queryDto.getFirstName() + "%");
                predicate = criteria.and(predicate, firstNamePredicate);
                // where 1=1 and firstName like :firstName
            }

            if (queryDto.getLastName() != null) {
                var lastNamePredicate = criteria.like(root.get("lastName"), queryDto.getLastName() + "%");
                predicate = criteria.and(predicate, lastNamePredicate);
                // where 1=1 and lastName like :lastName
                // where 1=1 and firstName like :firstName and lastName like :lastName
            }

            return predicate;
        };
    }
}

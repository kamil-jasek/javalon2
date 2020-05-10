package pl.sda.shop.accounts.domain;

import pl.sda.shop.accounts.domain.dto.CreatePersonAccountDto;
import pl.sda.shop.accounts.domain.dto.PersonDto;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
final class AccountMapper {

    Account map(CreatePersonAccountDto dto) {
        var person = new Person(dto.getFirstName(), dto.getLastName(), dto.getTaxId());
        return new Account(person);
    }

    PersonDto map(Person person) {
        return new PersonDto(person.getFirstName(), person.getLastName(), person.getTaxId());
    }
}

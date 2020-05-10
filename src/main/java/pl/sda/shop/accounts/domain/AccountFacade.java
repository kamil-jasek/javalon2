package pl.sda.shop.accounts.domain;

import lombok.RequiredArgsConstructor;
import pl.sda.shop.accounts.domain.dto.CreatePersonAccountDto;
import pl.sda.shop.accounts.domain.dto.PersonDto;
import pl.sda.shop.accounts.domain.dto.PersonQueryDto;
import pl.sda.shop.orders.domain.OrderFacade;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@RequiredArgsConstructor
public final class AccountFacade {

    private final AccountMapper mapper;
    private final AccountRepository repository;
    private final OrderFacade orderFacade;
    private final PersonRepository personRepository;

    public UUID createPersonAccount(CreatePersonAccountDto dto) {
        var account = mapper.map(dto);
        repository.save(account);
        return account.getId();
    }

    public List<PersonDto> findPersonsByLastName(String lastName) {
        return repository.findByLastName(lastName + "%")
                .stream()
                .map(mapper::map)
                .collect(toList());
    }

    public List<PersonDto> filterPerson(PersonQueryDto queryDto) {
        return personRepository.findAll(PersonSpecs.withQuery(queryDto))
                .stream()
                .map(mapper::map)
                .collect(toList());
    }

    public void testCommunicationBetweenFacades() {
        orderFacade.listOrders(UUID.randomUUID());
    }
}

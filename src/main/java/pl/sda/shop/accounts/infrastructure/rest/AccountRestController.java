package pl.sda.shop.accounts.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.shop.accounts.domain.AccountFacade;
import pl.sda.shop.accounts.domain.dto.CreatePersonAccountDto;
import pl.sda.shop.accounts.domain.dto.PersonQueryDto;
import pl.sda.shop.accounts.infrastructure.rest.dto.AccountCreatedDto;
import pl.sda.shop.accounts.infrastructure.rest.dto.CreateAccountDto;
import pl.sda.shop.accounts.infrastructure.rest.dto.PersonDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-10
 */
@RestController
@RequestMapping(value = "/api/v1/accounts")
@RequiredArgsConstructor
final class AccountRestController {

    private final AccountFacade facade;

    @PostMapping
    ResponseEntity<AccountCreatedDto> createAccount(@Valid @RequestBody CreateAccountDto dto) {
        if (dto.getType().equals(CreateAccountDto.AccountType.PERSON)) {
            var accountId = facade.createPersonAccount(new CreatePersonAccountDto(
                    dto.getFirstName(), dto.getLastName(), dto.getTaxId()));
            return ResponseEntity.ok(new AccountCreatedDto(accountId));
        }
        throw new IllegalArgumentException("Not implemented yet!");
    }

    @GetMapping(value = "/person")
    ResponseEntity<List<PersonDto>> filterPerson(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(facade
                .filterPerson(new PersonQueryDto(firstName, lastName))
                .stream()
                .map(person -> new PersonDto(person.getFirstName(), person.getLastName(), person.getTaxId()))
                .collect(toList()));
    }
}

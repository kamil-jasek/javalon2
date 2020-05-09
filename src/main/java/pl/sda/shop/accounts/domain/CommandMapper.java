package pl.sda.shop.accounts.domain;

import pl.sda.shop.accounts.domain.command.CreateAccountCommand;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2020-05-09
 */
final class CommandMapper {

    Customer map(CreateAccountCommand.Customer customer) {
        if (customer instanceof CreateAccountCommand.Company) {
            return map((CreateAccountCommand.Company) customer);
        } else if (customer instanceof CreateAccountCommand.Person) {
            return map((CreateAccountCommand.Person) customer);
        }
        throw new IllegalArgumentException("Invalid customer type");
    }

    private Person map(CreateAccountCommand.Person person) {
        return new Person(person.getFirstName(), person.getLastName(), person.getTaxId());
    }

    private Company map(CreateAccountCommand.Company company) {
        return new Company(company.getName(), new VatNumber(company.getVatNumber()));
    }
}

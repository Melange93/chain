package person.chain;

import person.Person;

public class PersonEmailExists extends PersonValidator {
    @Override
    public boolean hasError(Person person) {
        return person.getEmail() == null || person.getEmail().isBlank();
    }

    @Override
    public boolean canHandle(Person person) {
        return true;
    }
}

package person.chain;

import person.Person;

public class PersonNameIsValid extends PersonValidator {
    @Override
    public boolean hasError(Person person) {
        String[] names = person.getName().split(" ");
        if (names.length != 2) { // Kovacs Jozsef
            return true; // Kovacs Jozsef Pal
        }
        return names[0].length() <= 2 || names[1].length() <= 2; // Ko Pa
    }

    @Override
    public boolean canHandle(Person person) {
        return person.getName() != null && !person.getName().isBlank();
    }
}

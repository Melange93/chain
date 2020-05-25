package person.chain;

import person.Person;

public class PersonAgeShouldBeBiggerThanZero extends PersonValidator {
    @Override
    public boolean hasError(Person person) {
        return person.getAge()<0;
    }

    @Override
    public boolean canHandle(Person person) {
        return true;
    }
}

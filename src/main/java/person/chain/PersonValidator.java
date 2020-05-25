package person.chain;

import person.Person;

public abstract class PersonValidator implements Validator<Person> {

    private Validator<Person> next;

    @Override
    public Validator<Person> setNext(Validator<Person> next) {
        this.next = next;
        return next;
    }

    @Override
    public boolean isValid(Person person) {
        if (canHandle(person) && hasError(person)) {
            return false;
        }

        if (next == null) {
            return true;
        }

        return next.isValid(person);
    }

    public abstract boolean hasError(Person person);
}

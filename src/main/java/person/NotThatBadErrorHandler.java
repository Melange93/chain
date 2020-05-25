package person;

import lombok.Builder;
import lombok.NonNull;
import person.chain.Validator;

@Builder
public class NotThatBadErrorHandler implements HandlesError {

    private Validator<Person> personValidator;

    public NotThatBadErrorHandler(Validator<Person>... list) {
        this.personValidator = list[0];

        Validator<Person> previous = this.personValidator;
        for (Validator<Person> personV : list) {
            previous = previous.setNext(personV);
        }
    }

    @Override
    public boolean hasError(Person person) {
        return !personValidator.isValid(person);
    }
}

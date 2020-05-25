package person.chain;

import person.Person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonEmailIsValid extends PersonValidator {

    private static final String regex = "^(.+)@(.+)$";
    private static Pattern pattern = Pattern.compile(regex);

    @Override
    public boolean hasError(Person person) {
        Matcher matcher = pattern.matcher(person.getEmail());
        return !matcher.matches();
    }

    @Override
    public boolean canHandle(Person person) {
        return person.getEmail() != null && !person.getEmail().isBlank();
    }
}

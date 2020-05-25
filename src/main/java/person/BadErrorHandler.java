package person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BadErrorHandler implements HandlesError{

    private static final String regex = "^(.+)@(.+)$";

    @Override
    public boolean hasError(Person person) {

        Pattern pattern = Pattern.compile(regex);

        if (person.getName() != null && !person.getName().isBlank()) {
            String[] names = person.getName().split(" ");
            if (names.length != 2) { // Kovacs Jozsef
                return true; // Kovacs Jozsef Pal
            }
            if (names[0].length() <= 2 || names[1].length() <= 2) {
                return true; // Ko Pa
            }
        }

        if (person.getEmail() == null || person.getEmail().isBlank()) {
            return true;
        } else {
            Matcher matcher = pattern.matcher(person.getEmail());
            return !matcher.matches();
        }

    }

}

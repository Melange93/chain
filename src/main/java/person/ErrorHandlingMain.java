package person;

import person.chain.*;

import java.util.List;

public class ErrorHandlingMain {
    public static void main(String[] args) {
        Person p1 = Person.builder().name("Ko P").build();  // true
        Person p2 = Person.builder().name("Kis Pista").build(); // true
        Person p3 = Person.builder().name("Kis Pista").email("").build(); // true
        Person p4 = Person.builder().name("Kis Pista").email("a@b.com").build(); // false
        Person p5 = Person.builder().email("without@name.com").build(); // false
        Person p6 = Person.builder().email("without@name.com").age(-2).build(); // true
        List<Person> people = List.of(p1, p2, p3, p4, p5, p6);

        HandlesError handlesError1 = new BadErrorHandler();

        people.forEach(person -> System.out.println(handlesError1.hasError(person)));

        System.out.println("======");

        HandlesError handlesError2 = new NotThatBadErrorHandler(
                new PersonNameIsValid(),
                new PersonEmailIsValid(),
                new PersonEmailExists(),
                new PersonAgeShouldBeBiggerThanZero()
        );

        people.forEach(person -> System.out.println(handlesError2.hasError(person)));
    }
}

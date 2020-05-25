package person.chain;

public interface Validator<T> {

    Validator<T> setNext(Validator<T> next);
    boolean canHandle(T person);
    boolean isValid(T person);

}

package jaxrs.person;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(int id) {
        super("Person not found: " + id);
    }

}

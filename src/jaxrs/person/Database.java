package jaxrs.person;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Database {

    private static final List<Person> personList = new ArrayList<>();

    public List<Person> getAll(){
        return personList;
    }

    public Person getById(int id){
        try {
            return personList.get(id - 1);
        }catch (RuntimeException e){
            return null;
        }
    }

    public void add(Person person){
        personList.add(person);
    }

    public void deleteById(int id){
        personList.remove(id - 1);
    }

    public void updateById(int id, Person newPerson){
        personList.set(id - 1, newPerson);
    }
}

package ru.leonidaz.springcourse.PersonDAO;

import org.springframework.stereotype.Component;
import ru.leonidaz.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++COUNT,"Person1"));
        people.add(new Person(++COUNT,"Person2"));
        people.add(new Person(++COUNT,"Person3"));
        people.add(new Person(++COUNT,"Person4"));
    }

    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++COUNT);
        people.add(person);
    }

}

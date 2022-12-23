package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
       people = new ArrayList<>();

       people.add(new Person( ++PEOPLE_COUNT,"Elnar", 21, "elnar@mail.ru"));
       people.add(new Person(++PEOPLE_COUNT,"Adil",21,"adil@mail.ru"));
       people.add(new Person(++PEOPLE_COUNT,"Era", 23, "era@mail.ru"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return  people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdate = show(id);

        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setAge(updatePerson.getAge());
        personToBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}

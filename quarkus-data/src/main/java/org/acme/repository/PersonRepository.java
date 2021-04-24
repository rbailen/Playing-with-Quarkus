package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public List<Person> getPersons(){
        return findAll().list();
    }

    public Person getPerson(Long id){
        return findById(id);
    }

    public Person getPersonByNameAndAge(String name, Integer age){
        return find("name = ?1 and age = ?2", name, age).firstResult();
    }

    @Transactional
    public Person create(Person person){
        persist(person);
        return person;
    }
}

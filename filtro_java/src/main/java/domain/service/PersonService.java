package domain.service;

import domain.entity.Person;

public interface PersonService {
    void CreatePerson(Person person);
    void DeletePersonByName(Person person);
    void UpdatePerson(Person person);
}

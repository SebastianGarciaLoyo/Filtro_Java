package application;

import domain.entity.Person;
import domain.service.PersonService;

public class CreatePersonUseCase {
    private PersonService personService;

    public CreatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person) {
        personService.CreatePerson(person);
    }
}

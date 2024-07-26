package application;

import domain.entity.Person;
import domain.service.PersonService;

public class DeletePersonUseCase {
    private PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person) {
        personService.DeletePersonByName(person);
    }
}

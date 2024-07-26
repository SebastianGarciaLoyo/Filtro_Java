package application;

import domain.entity.Person;
import domain.service.PersonService;

public class UpdatePersonUseCase {
    private PersonService personService;
    
    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person) {
        personService.UpdatePerson(person);
    }

}

package infrastucture.in;

import java.util.Scanner;

import application.CreatePersonUseCase;
import domain.entity.Person;

public class PersonController {
    private CreatePersonUseCase createPersonUseCase;

    public PersonController(CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    public void MenuPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("1. Agregar Persona");
        System.out.println("2. Borrar Persona");
        System.out.println("3. Volver");
        System.out.println("=======================");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                CrearPersona(scanner);
                break;
            
            case 2:

                break;

            case 3:
                System.out.println("Volviendo...");
                return;
            default:
                System.out.println("Opcion no valida vuelva a intentar");
                break;
        }
    }


    private void CrearPersona(Scanner scanner) {
        System.out.println("Ingrese el nombre de la persona: ");
        String name =  scanner.nextLine();

        System.out.println("Ingrese el apellido de la persona: ");
        String lastname = scanner.nextLine();

        System.out.println("Ingrese el id de la ciudad donde vive (del 1 al 84 siendo 1: Leticia y 84: Plato): ");
        int id_city = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        System.out.println("Ingrese la dirrecion de la persona: ");
        String address = scanner.nextLine();

        System.out.println("Ingrese la edad de la persona: ");
        int age = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();

        System.out.println("Ingrese el correo electronico de la persona: ");
        String email = scanner.nextLine();

        System.out.println("Ingrese el genero de la persona(Hombre o Mujer): ");
        String gender = scanner.nextLine();


        Person person = new Person();
        person.setName(name);
        person.setLastname(lastname);
        person.setId_city(id_city);
        person.setAddress(address);
        person.setAge(age);
        person.setEmail(email);
        person.setGender(gender);

        
    }
}

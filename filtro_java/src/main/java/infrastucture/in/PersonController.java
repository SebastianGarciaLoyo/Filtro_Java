package infrastucture.in;

import java.util.List;
import java.util.Scanner;

import application.CreatePersonUseCase;
import application.DeletePersonUseCase;
import application.ExisteNombreExtraccion;
import application.UpdatePersonUseCase;
import application.verifiers.CheckInt;
import application.verifiers.CheckString;
import domain.entity.Person;

public class PersonController {
    private ExisteNombreExtraccion existeNombreExtraccion;
    private CreatePersonUseCase createPersonUseCase;
    private DeletePersonUseCase deletePersonUseCase;
    private UpdatePersonUseCase updatePersonUseCase;

    public PersonController(CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    public PersonController(DeletePersonUseCase deletePersonUseCase) {
        this.deletePersonUseCase = deletePersonUseCase; 
    }

    public PersonController(UpdatePersonUseCase updatePersonUseCase) {
        this.updatePersonUseCase = updatePersonUseCase;
    }

    public void MenuPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("1. Agregar Persona");
        System.out.println("2. Borrar Persona");
        System.out.println("3. Actualizar Persona");
        System.out.println("4. Volver");
        System.out.println("=======================");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                CrearPersona(scanner);
                break;
            
            case 2:
                BorrarPersona(scanner);
                break;

            case 3:
                ActualizarPersona(scanner);
                break;

            case 4:
                System.out.println("Volviendo...");
                return;
            default:
                System.out.println("Opcion no valida vuelva a intentar");
                break;
        }
    }



    private void CrearPersona(Scanner scanner) {
        



        boolean checkName = false;
        String name = "";
        while (!checkName) {
            System.out.println("Ingrese el nombre de la persona: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
        try{
            name = CheckString.check(scanner.nextLine());
            if (name.equalsIgnoreCase("salir")) {
                System.out.println("Registro Cancelado");
                return;
            } else {
                checkName = true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        }
        
        boolean checkLastname = false;
        String lastname = "";

        while (!checkLastname) {
            System.out.println("Ingrese el apellido de la persona: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                lastname = CheckString.check(scanner.nextLine());
                if(lastname.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                    return;
                } else {
                    checkLastname = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean checkCity = false;
        int id_city = 0;

        while (!checkCity) {
            System.out.println("Ingrese el id de la ciudad donde vive (del 1 al 84 siendo 1: Leticia y 84: Plato): ");
            System.out.println("Escriba -1 si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                id_city = CheckInt.check(scanner.nextLine());
                if (id_city == -1) {
                    System.out.println("Registro Cancelado");
                    return;
                } else if (id_city > 0) {
                    checkCity  = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean checkDirrecion = false;
        String address = "";

        while (!checkDirrecion) {
            System.out.println("Ingrese la dirrecion de la persona: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try{
                address = CheckString.check(scanner.nextLine());
                if (address.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                } else {
                    checkDirrecion = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        boolean checkEdad = false;
        int age = 0;

        while (!checkEdad) {
            System.out.println("Ingrese la edad de la persona: ");
            System.out.println("Escriba -1 si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                age = CheckInt.check(scanner.nextLine());
                if (age == -1) {
                    System.out.println("Registro Cancelado");
                    return;
                } else if (age > 0) {
                    checkEdad  = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean checkCorreo = false;
        String email = "";

        while (!checkCorreo) {
            System.out.println("Ingrese el correo electronico de la persona: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try{
                email = CheckString.check(scanner.nextLine());
                if (email.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                } else {
                    checkCorreo = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        
        
        boolean checkGenero = false;
        int gender = 0;

        while (!checkGenero) {
            System.out.println("Ingrese el genero de la persona(1 para Hombre, 2 para Mujer): ");
            System.out.println("Escriba -1 si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                gender = CheckInt.check(scanner.nextLine());
                if (gender == -1) {
                    System.out.println("Registro Cancelado");
                    return;
                } else if (gender > 0) {
                    checkGenero  = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        

        Person person = new Person();
        person.setName(name);
        person.setLastname(lastname);
        person.setId_city(id_city);
        person.setAddress(address);
        person.setAge(age);
        person.setEmail(email);
        person.setGender(gender);

        createPersonUseCase.execute(person);

        System.out.println("Persona registrada correctamente!");

    }

    private void BorrarPersona(Scanner scanner) {

        boolean checkDeleteName = false;
        String name = "";

        while (!checkDeleteName) {
            System.out.println("Por favot ingrese el nombre de la persona que desea borrar: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try{
                name = CheckString.check(scanner.nextLine());
                if (name.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                } else {
                    checkDeleteName = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        
        }

        Person person = new Person();
        person.getName();

        deletePersonUseCase.execute(person);

    }

    private void ActualizarPersona(Scanner scanner) {
        List<String> listRegisteredName = this.existeNombreExtraccion.executeExtrac();
        
        boolean checkNameTrue = false;
        String name = "";

        while (!checkNameTrue) {
            System.out.println("Ingrese el nombre de la persona que va a modificar:");
            try {
                name = CheckString.check(scanner.nextLine());
                if (name.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                    return;
                }

                if (listRegisteredName.contains(name)) {
                    System.out.println("Este nombre existe.");
                } else {
                    checkNameTrue = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        boolean checkLastname = false;
        String lastname = "";

        while (!checkLastname) {
            System.out.println("Ingrese el apellido de la persona que va a modificar: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                lastname = CheckString.check(scanner.nextLine());
                if(lastname.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                    return;
                } else {
                    checkLastname = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean checkCity = false;
        int id_city = 0;

        while (!checkCity) {
            System.out.println("Ingrese el id de la ciudad donde vive (del 1 al 84 siendo 1: Leticia y 84: Plato): ");
            System.out.println("Escriba -1 si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                id_city = CheckInt.check(scanner.nextLine());
                if (id_city == -1) {
                    System.out.println("Registro Cancelado");
                    return;
                } else if (id_city > 0) {
                    checkCity  = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean checkDirrecion = false;
        String address = "";

        while (!checkDirrecion) {
            System.out.println("Ingrese la dirrecion de la persona: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try{
                address = CheckString.check(scanner.nextLine());
                if (address.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                } else {
                    checkDirrecion = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        boolean checkEdad = false;
        int age = 0;

        while (!checkEdad) {
            System.out.println("Ingrese la edad de la persona: ");
            System.out.println("Escriba -1 si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                age = CheckInt.check(scanner.nextLine());
                if (age == -1) {
                    System.out.println("Registro Cancelado");
                    return;
                } else if (age > 0) {
                    checkEdad  = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean checkCorreo = false;
        String email = "";

        while (!checkCorreo) {
            System.out.println("Ingrese el correo electronico de la persona: ");
            System.out.println("Escriba salir si quiere cancelar el registro");
            System.out.println("=======================================");
            try{
                email = CheckString.check(scanner.nextLine());
                if (email.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                } else {
                    checkCorreo = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        
        
        boolean checkGenero = false;
        int gender = 0;

        while (!checkGenero) {
            System.out.println("Ingrese el genero de la persona(1 para Hombre, 2 para Mujer): ");
            System.out.println("Escriba -1 si quiere cancelar el registro");
            System.out.println("=======================================");
            try {
                gender = CheckInt.check(scanner.nextLine());
                if (gender == -1) {
                    System.out.println("Registro Cancelado");
                    return;
                } else if (gender > 0) {
                    checkGenero  = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        

        Person person = new Person();
        person.setName(name);
        person.setLastname(lastname);
        person.setId_city(id_city);
        person.setAddress(address);
        person.setAge(age);
        person.setEmail(email);
        person.setGender(gender);

        updatePersonUseCase.execute(person);

        System.out.println("Persona registrada correctamente!");
    }
}

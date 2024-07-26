package com.filtro;

import java.util.Scanner;

import application.CreatePersonUseCase;
import application.CreateSkillUseCase;
import domain.service.PersonService;
import domain.service.SkillService;
import infrastucture.in.PersonController;
import infrastucture.in.SkillController;
import infrastucture.out.PersonRepository;
import infrastucture.out.SkillRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido!");
            System.out.println("1. Personas");
            System.out.println("2. Habilidades");
            System.out.println("3. Salir");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    PersonService personService = new PersonRepository();
                    CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
                    PersonController personController = new PersonController(createPersonUseCase);
                    personController.MenuPersona();

                    break;
                
                case 2:
                    SkillService skillService = new SkillRepository();
                    CreateSkillUseCase createSkillUseCase = new CreateSkillUseCase(skillService);
                    SkillController skillController = new SkillController(createSkillUseCase);
                    skillController.MenuHabilidad();
                    break;

                case 3:
                    System.out.println("Vuelva pronto");
                    scanner.close();
                    return;
                default:
                    break;
            }
        }
    }
}
package infrastucture.in;

import java.util.Scanner;

import application.CreateSkillUseCase;

public class SkillController {
    private CreateSkillUseCase createSkillUseCase;

    public SkillController(CreateSkillUseCase createSkillUseCase) {
        this.createSkillUseCase = createSkillUseCase;
    }

        public void MenuHabilidad() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("1. Agregar Habilidad");
        System.out.println("2. Asignar Habilidad a Persona");
        System.out.println("3. Consultar Personas por Habilidad");
        System.out.println("4. Volver");
        System.out.println("=======================");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
            
                break;
            
            case 2:

                break;

            case 3:

                break;
            
            case 4:
            System.out.println("Volviendo...");
                return;
            default:
                System.out.println("Opcion no valida vuelva a intentar");
                break;
        }
    }

}

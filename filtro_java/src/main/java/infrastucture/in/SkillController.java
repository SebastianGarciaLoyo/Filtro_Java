package infrastucture.in;

import java.util.Scanner;

import application.CreateSkillUseCase;
import application.verifiers.CheckString;
import domain.entity.Skill;

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
                CrearHabilidad(scanner);
                break;
            
            case 2:
                AsignarSkill(scanner);
                break;

            case 3:
                ConsultarPorSkill(scanner);
                break;
            
            case 4:
            System.out.println("Volviendo...");
                return;
            default:
                System.out.println("Opcion no valida vuelva a intentar");
                break;
        }
    }

        private void CrearHabilidad(Scanner scanner) {

            boolean checkname = false;
            String name = "";

            while (!checkname) {
                System.out.println("Ingrese el nombre de la habilidad: ");
                System.out.println("Escriba salir si quiere cancelar el registro");
                System.out.println("=======================================");
                try{
                name = CheckString.check(scanner.nextLine());
                if (name.equalsIgnoreCase("salir")) {
                    System.out.println("Registro Cancelado");
                    return;
                } else {
                checkname = true;
                }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
            }

            

            Skill skill = new Skill();
            skill.setName(name);

            createSkillUseCase.execute(skill);

            System.out.println("Habilidad registrada exitosamente!");
        }

        private void ConsultarPorSkill(Scanner scanner) {
            
        }

        private void AsignarSkill(Scanner scanner) {
        
        }

}

package infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.entity.Skill;
import domain.service.SkillService;
import infrastucture.config.DatabaseConfigPerson;

public class SkillRepository implements SkillService {

    @Override
    public void CreateSkill(Skill skill) {
        String sql = "INSERT INTO skill(name) VALUES (?)";

        try(Connection connection = DatabaseConfigPerson.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, skill.getName());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                
            } else {
                throw new SQLException("Hubo un error al crear la habilidad.");
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar el estado SQL " + e.getMessage());
        }
    }
}

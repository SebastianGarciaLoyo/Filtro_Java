package infrastucture.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.entity.Person;
import domain.service.PersonService;
import infrastucture.config.DatabaseConfigPerson;

public class PersonRepository implements PersonService {

    @Override
    public void CreatePerson(Person person) {
              String sql = "INSERT INTO persons(name,lastname,idcity,address,age,email,idgender) VALUES(?,?,?,?,?,?,?)";
       
       try(Connection connection = DatabaseConfigPerson.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastname());
            statement.setInt(3, person.getId_city());
            statement.setString(4, person.getAddress());
            statement.setInt(5, person.getAge());
            statement.setString(6, person.getEmail());
            statement.setInt(7, person.getGender());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                
            } else {
                throw new SQLException("Hubo un error al crear a la persona.");
            }
       } catch (SQLException e) {
        System.err.println("Error al ejecutar el estado SQL " + e.getMessage());
       }
    }

    @Override
    public void DeletePersonByName(Person person) {
        String sql = "DELETE FROM persons WHERE name = ?";

        try (Connection connection = DatabaseConfigPerson.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, person.getName());
            int rowsDeleted = statement.executeUpdate();
            
            if(rowsDeleted > 0) {
                System.out.println("Datos borrados correctamente.");
            } else {
                System.out.println("No se encontro ningun dato con ese nombre.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }

    @Override
    public void UpdatePerson(Person person) {
        String sql = "UPDATE persons SET name = ?,lastname = ?,idcity = ?,address = ?,age = ?,email = ?,idgender = ? ";
        try(Connection connection = DatabaseConfigPerson.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastname());
            statement.setInt(3, person.getId_city());
            statement.setString(4, person.getAddress());
            statement.setInt(5, person.getAge());
            statement.setString(6, person.getEmail());
            statement.setInt(7, person.getGender());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                
            } else {
                throw new SQLException("Hubo un error al crear a la persona.");
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar el estado SQL " + e.getMessage());
        }
    }
}

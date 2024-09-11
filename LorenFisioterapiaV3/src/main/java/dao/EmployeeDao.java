package dao;

import model.Employee;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private List<Employee> employees = new ArrayList<>();

    public static void createEmployeeDB(Employee employee) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            //esta es la conexion

            PreparedStatement ps = null;

            try{
                String query = "INSERT INTO employee(typeDoc, document, namePerson, lastName, gender, birthday, mobile, email, address, position)VALUES(?,?,?,?,?,?,?,?,?,?)";

                ps = connection.prepareStatement(query);

                ps.setString(1, employee.getTypeDoc());
                ps.setInt(2, employee.getDocument());
                ps.setString(3, employee.getNamePerson());
                ps.setString(4, employee.getLastName());
                ps.setString(5, employee.getGender());
                ps.setString(6, employee.getBirthday());
                ps.setString(7, employee.getMobile());
                ps.setString(8, employee.getEmail());
                ps.setString(9, employee.getAddress());
                ps.setString(10, employee.getPosition());

                ps.executeUpdate();
                System.out.println("Registro de empleado exitoso");

            } catch (SQLException e) {
                System.out.println(e);
            }

            //esta es la conexion
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    //Traer datos de la DB

    public static void listingEmployeeDB() {
        Conexion conexion = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try(Connection connection = conexion.get_connection() ){

            String query = "SELECT * FROM employee";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("Id Empleado: "          + rs.getInt("idPerson"));
                System.out.println("Tipo de documento: "    + rs.getString("typeDoc"));
                System.out.println("Numero documento: "     + rs.getInt("document"));
                System.out.println("Nombres: "              + rs.getString("namePerson"));
                System.out.println("Apellidos: "            + rs.getString("lastName"));
                System.out.println("Genero: "               + rs.getString("gender"));
                System.out.println("Fecha Nacimiento: "     + rs.getString("birthday"));
                System.out.println("Numero Celular: "       + rs.getString("mobile"));
                System.out.println("Correo Electronico: "   + rs.getString("email"));
                System.out.println("Direccion: "            + rs.getString("address"));
                System.out.println("Cargo: "                + rs.getString("position"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //Borrar Empleado
    public static void deleteEmployeeDB(int idPerson) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM employee WHERE employee.idPerson = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1, idPerson);

                ps.executeUpdate();

                System.out.println("El registro ha sido borrado exitosamente");

            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se eliminó el registro");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Actualizar Empleado

    public static void updateEmployee(Employee employee) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            if(employee.getOpc() == 1) {
                try {
                    String query ="UPDATE employee SET namePerson = ? WHERE idPerson = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, employee.getNamePerson());
                    ps.setInt(2, employee.getIdPerson());

                    ps.executeUpdate();

                    System.out.println("Nombre Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else if (employee.getOpc() == 2) {
                try {
                    String query ="UPDATE employee SET position = ? WHERE idPerson = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, employee.getPosition());
                    ps.setInt(2, employee.getIdPerson());

                    ps.executeUpdate();

                    System.out.println("Cargo actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }

            }
             else {
                System.out.printf("Falta informacion para actualizar");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Employee findById(int id) {
        return employees.stream().filter(e -> e.getIdPerson() == id).findFirst().orElse(null);
    }

}

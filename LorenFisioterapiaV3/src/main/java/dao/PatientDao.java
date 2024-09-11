package dao;

import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {


    public static void createPatientDB(Patient patient) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            //esta es la conexion

            PreparedStatement ps = null;

            try{
                String query = "INSERT INTO patient(typeDoc, document, namePerson, lastName, gender, birthday, mobile, email, address, typePatient)VALUES(?,?,?,?,?,?,?,?,?,?)";

                ps = connection.prepareStatement(query);

                ps.setString(1, patient.getTypeDoc());
                ps.setInt(2, patient.getDocument());
                ps.setString(3, patient.getNamePerson());
                ps.setString(4, patient.getLastName());
                ps.setString(5, patient.getGender());
                ps.setString(6, patient.getBirthday());
                ps.setString(7, patient.getMobile());
                ps.setString(8, patient.getEmail());

                ps.setString(9, patient.getAddress());
                ps.setString(10, patient.getTypePatient());

                ps.executeUpdate();
                System.out.println("Registro de paciente exitoso");

            } catch (SQLException e) {
                System.out.println(e);
            }


            //esta es la conexion
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //Traer datos de la DB

    public static void listingPatientsDB() {
        Conexion conexion = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try(Connection connection = conexion.get_connection() ){

            String query = "SELECT * FROM patient";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println("Id Paciente: "          + rs.getInt("idPerson"));
                System.out.println("Tipo de documento: "    + rs.getString("typeDoc"));
                System.out.println("Numero documento: "     + rs.getInt("document"));
                System.out.println("Nombres: "              + rs.getString("namePerson"));
                System.out.println("Apellidos: "            + rs.getString("lastName"));
                System.out.println("Genero: "               + rs.getString("gender"));
                System.out.println("Fecha Nacimiento: "     + rs.getString("birthday"));
                System.out.println("Numero Celular: "       + rs.getString("mobile"));
                System.out.println("Correo Electronico: "   + rs.getString("email"));
                System.out.println("Direccion: "            + rs.getString("address"));
                System.out.println("Tipo de Paciente: "     + rs.getString("typePatient"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //Borrar Pacientes
    public static void deletePatientDB(int idPerson) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM patient WHERE patient.idPerson = ?";

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

    //Actualizar paciente

    public static void updatePatient(Patient patient) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            if(patient.getOpc() == 1) {
                try {
                    String query ="UPDATE patient SET namePerson = ? WHERE idPerson = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, patient.getNamePerson());
                    ps.setInt(2, patient.getIdPerson());

                    ps.executeUpdate();

                    System.out.println("Nombre Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else if (patient.getOpc() == 2) {
                try {
                    String query ="UPDATE patient SET mobile = ? WHERE idPerson = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, patient.getMobile());
                    ps.setInt(2, patient.getIdPerson());

                    ps.executeUpdate();

                    System.out.println("Celular Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }

            } else if (patient.getOpc()==3) {
                try {
                    String query ="UPDATE patient SET address = ? WHERE idPerson = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, patient.getAddress());
                    ps.setInt(2, patient.getIdPerson());

                    ps.executeUpdate();

                    System.out.println("Dirección Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }

            } else {
                System.out.printf("Falta informacion para actualizar");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }


}

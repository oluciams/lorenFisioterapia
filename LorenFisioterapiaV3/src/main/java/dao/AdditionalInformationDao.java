package dao;

import model.Patient;
import model.AdditionalInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdditionalInformationDao {
    public static void createAdditionalInformationDB(AdditionalInformation additionalInformation) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            //esta es la conexion

            PreparedStatement ps = null;

            try{
                String query = "INSERT INTO additionalInformation(surgicalAnts, height, weight, diagnosis, observations )VALUES(?,?,?,?,?)";

                ps = connection.prepareStatement(query);

                ps.setString(1, additionalInformation.getSurgicalAnts());
                ps.setDouble(2, additionalInformation.getHeight());
                ps.setDouble(3, additionalInformation.getWeight());
                ps.setString(4, additionalInformation.getDiagnosis());
                ps.setString(5, additionalInformation.getObservations());

                ps.executeUpdate();
                System.out.println("Registro de informacion adicional exitoso");

            } catch (SQLException e) {
                System.out.println(e);
            }

            //esta es la conexion
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //traer datos de la base de datos
    public static void listingAdditionalInformationDB() {
        Conexion conexion = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try(Connection connection = conexion.get_connection() ){

            String query = "SELECT * FROM additionalInformation";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("Id informacion adicional: " + rs.getInt("addInformationId"));
                System.out.println("Cirugias: "                 + rs.getString("surgicalAnts"));
                System.out.println("Estatura: "                 + rs.getDouble("height"));
                System.out.println("Peso: "                     + rs.getDouble("weight"));
                System.out.println("Diagnostico: "              + rs.getString("diagnosis"));
                System.out.println("Observaciones: "            + rs.getString("observations"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //eliminar datos

    public static void deleteAdditionalInformationDB(int addInformationId) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM additionalInformation WHERE additionalInformation.addInformationId = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1, addInformationId);

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

    public static void updateAdditionalInformationDB(AdditionalInformation additionalInformation) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            if(additionalInformation.getOpc() == 1) {
                try {
                    String query ="UPDATE additionalInformation SET diagnosis = ? WHERE addInformationId = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, additionalInformation.getDiagnosis());

                    ps.setInt(2, additionalInformation.getAddInformationId());

                    ps.executeUpdate();

                    System.out.println("Diagnostico Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }
            }else {
                System.out.println("Algo salio mal");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static AdditionalInformation getAdditionalInformationById(int id) {
        Conexion conexion = new Conexion();
        AdditionalInformation additionalInformation = null;

        try (Connection connection = conexion.get_connection()) {
            String query = "SELECT * FROM additionalInformation WHERE addInformationId = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                additionalInformation = new AdditionalInformation();
                additionalInformation.setAddInformationId(rs.getInt("addInformationId"));
                additionalInformation.setSurgicalAnts(rs.getString("surgicalAnts"));
                additionalInformation.setHeight(rs.getDouble("height"));
                additionalInformation.setWeight(rs.getDouble("weight"));
                additionalInformation.setDiagnosis(rs.getString("diagnosis"));
                additionalInformation.setObservations(rs.getString("observations"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return additionalInformation;
    }



}

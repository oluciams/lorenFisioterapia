package dao;

import model.Plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanDao {

    public static void createPlanDB(Plan plan) {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.get_connection()) {
            //esta es la conexion

            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO plan(namePlan, price, quantityAppointment, treatmentArea, treatmentType)VALUES(?,?,?,?,?)";

                ps = connection.prepareStatement(query);

                ps.setString(1, plan.getNamePlan());
                ps.setDouble(2, plan.getPrice());
                ps.setInt(3, plan.getQuantityAppointment());
                ps.setString(4, plan.getTreatmentArea());
                ps.setString(5, plan.getTreatmentType());

                ps.executeUpdate();
                System.out.println("Registro de Plan exitoso");

            } catch (SQLException e) {
                System.out.println(e);
            }

            //esta es la conexion
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    //Traer datos de la base de datos
    public static void listingPlansDB() {
        Conexion conexion = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try(Connection connection = conexion.get_connection() ){

            String query = "SELECT * FROM plan";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println("id del plan: "          + rs.getInt("planId"));
                System.out.println("Nombre de plan: "       + rs.getString("namePlan"));
                System.out.println("Precio: "               + rs.getDouble("price"));
                System.out.println("Duración: "             + rs.getInt("quantityAppointment"));
                System.out.println("Area de Tratamiento: "  + rs.getString("treatmentArea"));
                System.out.println("Tipo de tratamiento: "  + rs.getString("treatmentType"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //eliminar datos

    public static void deletePlanDB(int planId) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM plan WHERE plan.planId = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1, planId);

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

    public static void updatePlanDB(Plan plan) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            if(plan.getOpc() == 1) {
                try {
                    String query ="UPDATE plan SET namePlan = ? WHERE planId = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, plan.getNamePlan());

                    ps.setInt(2, plan.getPlanId());

                    ps.executeUpdate();

                    System.out.println("Nombre Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else if (plan.getOpc() == 2) {
                try {
                    String query ="UPDATE plan SET price = ? WHERE planId = ?";

                    ps = connection.prepareStatement(query);

                    ps.setDouble(1, plan.getPrice());
                    ps.setInt(2, plan.getPlanId());

                    ps.executeUpdate();

                    System.out.println("Precio Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }

            } else {
                System.out.println("Error al digitar datos");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}

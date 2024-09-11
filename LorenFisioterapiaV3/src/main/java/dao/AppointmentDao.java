package dao;

import model.Appointment;
import model.Employee;
import model.Patient;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentDao {

    public static void createAppointmentDB(Appointment appointment) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ) {
            //esta es la conexion

            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO appointment(appointmentType, duration, reason, price, appointmentDate)VALUES(?,?,?,?,?)";

                ps = connection.prepareStatement(query);

                ps.setString(1, appointment.getAppointmentType());
                ps.setInt(2, appointment.getDuration());
                ps.setString(3, appointment.getReason());
                ps.setDouble(4, appointment.getPrice());
                ps.setString(5, appointment.getAppointmentDate());

                ps.executeUpdate();
                System.out.println("Registro de Cita exitoso");

            } catch (SQLException e) {
                System.out.println(e);
            }

            //esta es la conexion
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static ArrayList<Appointment> listingAppointmentDB() {
        Conexion conexion = new Conexion();

        ArrayList<Appointment> appointments = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection connection = conexion.get_connection() ){

            String query = "SELECT * FROM appointment";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointmentId"));
                appointment.setAppointmentType(rs.getString("appointmentType"));
                appointment.setDuration(rs.getInt("duration"));
                appointment.setReason(rs.getString("reason"));
                appointment.setPrice(rs.getDouble("price"));
                appointment.setAppointmentDate(rs.getString("appointmentDate"));

                appointments.add(appointment);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return appointments;
    }

    public static void deleteAppointmentDB(int appointmentId) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM appointment WHERE appointment.appointmentId = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1,appointmentId);

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

    public static void updateAppointment(Appointment appointment) {
        Conexion conexion = new Conexion();

        try(Connection connection = conexion.get_connection() ){
            PreparedStatement ps = null;

            if(appointment.getOpc() == 1) {
                try {
                    String query ="UPDATE appointment SET price = ? WHERE appointmentId = ?";

                    ps = connection.prepareStatement(query);

                    ps.setDouble(1, appointment.getPrice());

                    ps.setInt(2, appointment.getAppointmentId());

                    ps.executeUpdate();

                    System.out.println("Precio Actualizado correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }
            } else if (appointment.getOpc() == 2) {
                try {
                    String query ="UPDATE appointment SET appointmentDate = ? WHERE appointmentId = ?";

                    ps = connection.prepareStatement(query);

                    ps.setString(1, appointment.getAppointmentDate());
                    ps.setInt(2, appointment.getAppointmentId());

                    ps.executeUpdate();

                    System.out.println("Fecha Actualizada correctamente");

                } catch (SQLException e) {
                    System.out.println(e);
                }

            }else {

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static double getTotalPriceOfAppointments() {
        Conexion conexion = new Conexion();
        double total = 0.0;

        try (Connection connection = conexion.get_connection()) {
            String query = "SELECT SUM(price) AS total FROM appointment";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return total;
    }

}

package service;

import dao.AppointmentDao;
import model.Appointment;

import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentService {

    Scanner sc = new Scanner(System.in);
    
    public void createAppointment(Appointment appointment) {
        System.out.println("Ingresa los datos de la cita: ");
      
        System.out.println("Tipo de Cita:");
        String appointmentType = sc.nextLine();
        System.out.println("Duración Cita:");
        int duration = sc.nextInt();
        sc.nextLine();
        System.out.println("Descripción:");
        String reason = sc.nextLine();
        System.out.println("Precio:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Fecha:");
        String appointmentDate = sc.nextLine();

        appointment.setAppointmentType(appointmentType);
        appointment.setDuration(duration);
        appointment.setReason(reason);
        appointment.setPrice(price);
        appointment.setAppointmentDate(appointmentDate);

        AppointmentDao.createAppointmentDB(appointment);
    }

    public void listingAppointments() {
        ArrayList<Appointment> appointments = AppointmentDao.listingAppointmentDB();

        for (Appointment appointment: appointments) {
            System.out.println("Id de la cita: " + appointment.getAppointmentId());
            System.out.println("Tipo de cita: "  + appointment.getAppointmentType());
            System.out.println("Duración cita: " + appointment.getDuration());
            System.out.println("Descripcion: "   + appointment.getReason());
            System.out.println("Precio: "        + appointment.getPrice());
            System.out.println("Fecha: "         + appointment.getAppointmentDate());

        }
    }

    public void deleteAppointment() {
        System.out.println("ingrese el id de la cita a eliminar");
        int appointmentId = sc.nextInt();

        AppointmentDao.deleteAppointmentDB(appointmentId);

    }

    public void updateAppointment(Appointment appointment) {

        System.out.println("ingrese el id de la cita a actualizar");
        int appointmentId = sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione : \n" +
                "1.Actualizar Precio\n" +
                "2.Actualizar Fecha\n"
        );

        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                appointment.setOpc(opc);
                System.out.println("Indique el nuevo precio");
                double price = sc.nextDouble();
                appointment.setPrice(price);
                appointment.setAppointmentId(appointmentId);
                AppointmentDao.updateAppointment(appointment);
                break;
            case 2:
                appointment.setOpc(opc);
                System.out.println("Indique la nueva fecha");
                String appointmentDate = sc.nextLine();
                appointment.setAppointmentDate(appointmentDate);
                appointment.setAppointmentId(appointmentId);
                AppointmentDao.updateAppointment(appointment);
                break;
            default:
                System.out.println("seleccione una opcion valida");
                break;

        }
    }

    public double getTotalPriceOfAppointments() {
        return AppointmentDao.getTotalPriceOfAppointments();
    }


    public void showTotalPriceOfAppointments() {
        double totalPrice = AppointmentDao.getTotalPriceOfAppointments();
        System.out.println("El precio total de todas las citas es: " + totalPrice);
    }
}

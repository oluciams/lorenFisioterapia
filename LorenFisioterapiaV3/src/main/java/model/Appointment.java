package model;

import java.util.Date;

public class Appointment {

    private int appointmentId;
    private String appointmentType;
    private int duration; // duración en minutos
    private String reason;
    private double price;
    private String appointmentDate;
    private int opc;
    private String errorMessage;


    public Appointment() {
    }
    public Appointment(int appointmentId, String appointmentType, int duration, String reason, double price, String appointmentDate, int opc) {

        this.appointmentId = appointmentId;
        this.appointmentType = appointmentType;
        this.duration = duration;
        this.reason = reason;
        this.price = price;
        this.appointmentDate = appointmentDate;
        this.opc = opc;

        if (!setPrice(price)){
            System.out.println("Error al crear la cita " + getErrorMessage());
        };


    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if(price <= 0) {
            errorMessage = "El precio debe ser mayor o igual a 0";
            System.out.println("El precio debe ser mayor o igual a 0");
            return false;
        }
        this.price = price;
        return true;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getOpc() { return opc; }

    public void setOpc(int opc) { this.opc = opc; }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

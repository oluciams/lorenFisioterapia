package model;

public class Plan {
    private int planId;
    private String namePlan;
    private double price;
    private int quantityAppointment;
    private String treatmentArea;
    private String treatmentType;
    private int opc;

    public Plan() {
    }

    public Plan(int planId, String namePlan, double price, int quantityAppointment, String treatmentArea, String treatmentType, int opc) {
        this.planId = planId;
        this.namePlan = namePlan;
        this.price = price;
        this.quantityAppointment = quantityAppointment;
        this.treatmentArea = treatmentArea;
        this.treatmentType = treatmentType;
        this.opc = opc;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityAppointment() {
        return quantityAppointment;
    }

    public void setQuantityAppointment(int quantityAppointment) {
        this.quantityAppointment = quantityAppointment;
    }

    public String getTreatmentArea() {
        return treatmentArea;
    }

    public void setTreatmentArea(String treatmentArea) {
        this.treatmentArea = treatmentArea;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

    public void aplicarDescuento() {
        this.price = this.price * 0.2;
    }
}

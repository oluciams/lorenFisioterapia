package model;

public class AdditionalInformation {
    private int addInformationId;
    private String surgicalAnts;
    private double height;
    private double weight;
    private String diagnosis;
    private String observations;
    private int opc;

    public AdditionalInformation() {
    }

    public AdditionalInformation(int addInformationId, String surgicalAnts, double height, double weight, String diagnosis, String observations, int opc) {
        this.addInformationId = addInformationId;
        this.surgicalAnts = surgicalAnts;
        this.height = height;
        this.weight = weight;
        this.diagnosis = diagnosis;
        this.observations = observations;
        this.opc = opc;
    }

    public int getAddInformationId() {
        return addInformationId;
    }

    public void setAddInformationId(int addInformationId) {
        this.addInformationId = addInformationId;
    }

    public String getSurgicalAnts() {
        return surgicalAnts;
    }

    public void setSurgicalAnts(String surgicalAnts) {
        this.surgicalAnts = surgicalAnts;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

    public double calcularIMC() {
        if (height > 0) {
            return weight / (height * height);
        } else {
            throw new IllegalArgumentException("La altura debe ser mayor a cero para calcular el IMC.");
        }
    }

}


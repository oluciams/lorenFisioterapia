package model;

public class Patient extends Person {
    public Patient() {}
    private String typePatient;
    private int opc;

    public Patient(int idPerson, String typeDoc, int document, String namePerson, String lastName, String gender, String birthday, String mobile, String email, String address, String typePatient, int opc) {
        super(idPerson, typeDoc, document, namePerson, lastName, gender, birthday, mobile, email, address);
        this.typePatient = typePatient;
        this.opc = opc;
    }

    public String getTypePatient() {
        return typePatient;
    }

    public void setTypePatient(String typePatient) {
        this.typePatient = typePatient;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }


}

package model;

public class Employee extends Person {
    private String position;
    private int opc;

    public Employee() {
    }

    public Employee(int idPerson, String typeDoc, int document, String namePerson, String lastName, String gender, String birthday, String mobile, String email, String address, String position, int opc) {
        super(idPerson, typeDoc, document, namePerson, lastName, gender, birthday, mobile, email, address);
        this.position = position;
        this.opc = opc;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }
}



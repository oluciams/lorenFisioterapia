package model;

public class Person {
    protected int idPerson;
    protected String typeDoc;
    protected int document;
    protected String namePerson;
    protected String lastName;
    protected String gender;
    protected String birthday;
    protected String mobile;
    protected String email;
    protected String address;

    public Person() {
    }

    public Person(int idPerson, String typeDoc, int document, String namePerson, String lastName, String gender, String birthday, String mobile, String email, String address) {
        this.idPerson = idPerson;
        this.typeDoc = typeDoc;
        this.document = document;
        this.namePerson = namePerson;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() { return mobile; }

    public void setMobile(String mobile) {
        if (mobile.length() > 8) {
            System.out.println("El numero debe ser de 8 digitos");
        } else {
            this.mobile = mobile;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

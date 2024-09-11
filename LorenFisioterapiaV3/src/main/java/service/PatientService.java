package service;

import dao.PatientDao;
import model.Patient;

import java.util.Scanner;

public class PatientService {
    Scanner sc = new Scanner(System.in);
    private PatientDao patientDao = new PatientDao();

    public void createPatient(Patient patient) {
        System.out.println("Ingresa los datos del paciente: ");
       // System.out.println("id:");
       // int idPerson = sc.nextInt();
        System.out.println("Tipo Documento (CC, CE, TI):");
        String typeDoc = sc.nextLine();
        System.out.println("Numero Documento:");
        int document = sc.nextInt();
        sc.nextLine();
        System.out.println("Nombre:");
        String namePerson = sc.nextLine();
        System.out.println("Apellido:");
        String lastName = sc.nextLine();
        System.out.println("Genero:");
        String gender = sc.nextLine();
        System.out.println("fecha Nacimiento:");
        String birthday = sc.nextLine();
        System.out.println("Numero Celular:");
        String mobile = sc.nextLine();
        System.out.println("Correo electronico:");
        String email = sc.nextLine();
        System.out.println("Direccion:");
        String address = sc.nextLine();
        System.out.println("Tipo de paciente:");
        String typePatient = sc.nextLine();

        //patient.setIdPerson(idPerson);
        patient.setTypeDoc(typeDoc);
        patient.setDocument(document);
        patient.setNamePerson(namePerson);
        patient.setLastName(lastName);
        patient.setGender(gender);
        patient.setBirthday(birthday);
        patient.setMobile(mobile);
        patient.setEmail(email);
        patient.setAddress(address);
        patient.setTypePatient(typePatient);


        PatientDao.createPatientDB(patient);
    }

    public void listingPatients() { PatientDao.listingPatientsDB(); }

    public void deletePatients() {
        System.out.println("Ingrese el id del paciente a eliminar");
        int idPerson = sc.nextInt();

        PatientDao.deletePatientDB(idPerson);
    }

    public void updatePatient(Patient patient) {
        System.out.println("Ingrese el id del paciente para actualizar");
        int idPerson = sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione : \n" +
                "1.Actualizar nombre\n" +
                "2.Actualizar número celular\n" +
                "3.Actualizar Direccion\n"
        );

        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                patient.setOpc(opc);
                System.out.println("Escriba el nuevo nombre");
                String namePerson= sc.nextLine();
                patient.setNamePerson(namePerson);
                patient.setIdPerson(idPerson);
                PatientDao.updatePatient(patient);
                break;
            case 2:
                patient.setOpc(opc);
                System.out.println("Escriba el nuevo número de telefono");
                String mobile = sc.nextLine();
                patient.setMobile(mobile);
                patient.setIdPerson(idPerson);
                PatientDao.updatePatient(patient);
                break;
            case 3:
                patient.setOpc(opc);
                System.out.println("Escriba la nueva Dirección");
                String address = sc.nextLine();
                patient.setAddress(address);
                patient.setIdPerson(idPerson);
                PatientDao.updatePatient(patient);
                break;
            default:
                System.out.println("Seleccione una opción válida");
                break;
        }
    }


}

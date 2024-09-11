package service;

import dao.EmployeeDao;
import dao.PatientDao;
import model.Employee;
import model.Patient;

import java.util.Scanner;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    private EmployeeDao employeeDao = new EmployeeDao();

    public void createEmployee(Employee employee) {
        System.out.println("Ingresa los datos del Empleado: \n");

        System.out.println("Tipo Documento: (C.C, C.E, T.I)");
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
        System.out.println("Cargo:");
        String position = sc.nextLine();

        employee.setTypeDoc(typeDoc);
        employee.setDocument(document);
        employee.setNamePerson(namePerson);
        employee.setLastName(lastName);
        employee.setGender(gender);
        employee.setBirthday(birthday);
        employee.setMobile(mobile);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPosition(position);

        EmployeeDao.createEmployeeDB(employee);

    }

    public void listingEmployee() { EmployeeDao.listingEmployeeDB(); }

    public void deleteEmployee() {
        System.out.println("Ingrese el id del empleado a eliminar");
        int idPerson = sc.nextInt();

        EmployeeDao.deleteEmployeeDB(idPerson);
    }

    public void updateEmployee(Employee employee) {
        System.out.println("Ingrese el id del empleado para actualizar");
        int idPerson = sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione : \n" +
                "1.Actualizar nombre\n" +
                "2.Actualizar Cargo\n"

        );

        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                employee.setOpc(opc);
                System.out.println("Escriba el nuevo nombre");
                String namePerson= sc.nextLine();
                employee.setNamePerson(namePerson);
                employee.setIdPerson(idPerson);
                EmployeeDao.updateEmployee(employee);
                break;
            case 2:
                employee.setOpc(opc);
                System.out.println("Escriba el nuevo Cargo");
                String position = sc.nextLine();
                employee.setPosition(position);
                employee.setIdPerson(idPerson);
                EmployeeDao.updateEmployee(employee);
                break;
            default:
                System.out.println("Seleccione una opción válida");
                break;
        }
    }


}

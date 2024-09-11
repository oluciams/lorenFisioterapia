package view;

import dao.*;
import model.*;
import service.*;

import java.util.Scanner;

public class Aplication {
    Scanner sc = new Scanner(System.in);

    Patient patient = new Patient();
    PatientService patientService = new PatientService();
    PatientDao patientDao = new PatientDao();

    Employee employee = new Employee();
    EmployeeService employeeService = new EmployeeService();
    EmployeeDao employeeDao = new EmployeeDao();

    Plan plan = new Plan();
    PlanService planService = new PlanService();
    PlanDao planDao = new PlanDao();

    Appointment appointment = new Appointment();
    AppointmentService appointmentService = new AppointmentService();
    AppointmentDao appointmentDao = new AppointmentDao();


    AdditionalInformation additionalInformation = new AdditionalInformation();
    AdditionalInformationService additionalInformationService = new AdditionalInformationService();
    AdditionalInformationDao additionalInformationDao = new AdditionalInformationDao();
    //private static AdditionalInformationService additionalInformationService = new AdditionalInformationService();


    public void lorenFisioterapiaApp() {
        System.out.println("Presione 1 para iniciar");

        int init = sc.nextInt();
        sc.nextLine();

      while (init != 0) {
        System.out.println("Seleccione una opción:\n" +
                "1. Paciente\n" +
                "2. Empleado\n" +
                "3. Citas\n" +
                "4. Planes\n" +
                "5. Información Adicional\n" +
                "0. Salir");

        int mainOption = sc.nextInt();
        sc.nextLine();

        switch (mainOption) {
            case 1:
                managePatients();
                break;
            case 2:
                manageEmployees();
                break;
            case 3:
                manageAppointments();
                break;
            case 4:
                managePlans();
                break;
            case 5:
                manageAdditionalInformation();
                break;
            case 0:
                init = 0;
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Ingrese una opción válida");
        }
    }
}

    private void managePatients() {
        int patientOption = -1;
        while (patientOption != 0) {
            System.out.println("Seleccione una opción para Paciente:\n" +
                    "1. Crear Paciente\n" +
                    "2. Ver Paciente\n" +
                    "3. Actualizar Paciente\n" +
                    "4. Eliminar Paciente\n" +
                    "0. Volver al menú principal");

            patientOption = sc.nextInt();
            sc.nextLine();

            switch (patientOption) {
                case 1:
                    System.out.println("Crear Paciente");
                    patientService.createPatient(patient);
                    break;
                case 2:
                    System.out.println("Listar Pacientes");
                    patientService.listingPatients();
                    break;
                case 3:
                    System.out.println("Actualizar Paciente");
                    patientService.updatePatient(patient);
                    break;
                case 4:
                    System.out.println("Borrar Paciente");
                    patientService.deletePatients();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    private void manageEmployees() {
        int employeeOption = -1;
        while (employeeOption != 0) {
            System.out.println("Seleccione una opción para Empleado:\n" +
                    "1. Crear Empleado\n" +
                    "2. Ver Empleado\n" +
                    "3. Actualizar Empleado\n" +
                    "4. Eliminar Empleado\n" +
                    "0. Volver al menú principal");

            employeeOption = sc.nextInt();
            sc.nextLine();

            switch (employeeOption) {
                case 1:
                    System.out.println("Crear Empleado");
                    employeeService.createEmployee(employee);
                    break;
                case 2:
                    System.out.println("Listar Empleados");
                    employeeService.listingEmployee();
                    break;
                case 3:
                    System.out.println("Actualizar Empleado");
                    employeeService.updateEmployee(employee);
                    break;
                case 4:
                    System.out.println("Borrar Empleado");
                    employeeService.deleteEmployee();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    private void managePlans() {
        int planOption = -1;
        while (planOption != 0) {
            System.out.println("Seleccione una opción para Plan:\n" +
                    "1. Crear Plan\n" +
                    "2. Ver Plan\n" +
                    "3. Actualizar Plan\n" +
                    "4. Eliminar Plan\n" +
                    "0. Volver al menú principal");

            planOption = sc.nextInt();
            sc.nextLine();

            switch (planOption) {
                case 1:
                    System.out.println("Crear Plan");
                    planService.createPlan(plan);
                    break;
                case 2:
                    System.out.println("Listar Planes");
                    planService.listingPlans();
                    break;
                case 3:
                    System.out.println("Actualizar Plan");
                    planService.updatePlan(plan);
                    break;
                case 4:
                    System.out.println("Borrar Plan");
                    planService.deletePlans();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    private void manageAppointments() {
        int appointmentOption = -1;
        while (appointmentOption != 0) {
            System.out.println("Seleccione una opción para Cita\n" +
                    "1. Crear Cita\n" +
                    "2. Ver Cita\n" +
                    "3. Actualizar Cita\n" +
                    "4. Eliminar Cita\n" +
                    "5. Ver total precio de citas\n" +
                    "0. Volver al menú principal");

            appointmentOption = sc.nextInt();
            sc.nextLine();

            switch (appointmentOption) {
                case 1:
                    System.out.println("Crear Cita");
                    appointmentService.createAppointment(appointment);
                    break;
                case 2:
                    System.out.println("Listar Citas");
                    appointmentService.listingAppointments();
                    break;
                case 3:
                    System.out.println("Actualizar Cita");
                    appointmentService.updateAppointment(appointment);
                    break;
                case 4:
                    System.out.println("Borrar Cita");
                    appointmentService.deleteAppointment();
                    break;
                case 5:
                    System.out.println("Ver Total Precio de citas");
                    appointmentService.showTotalPriceOfAppointments();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }

    private void manageAdditionalInformation() {
        int informationOption = -1;
        while (informationOption != 0) {
            System.out.println("Seleccione una opción para Informacion Adicional:\n" +
                    "1. Crear Información Adicional\n" +
                    "2. Ver Información Adicional\n" +
                    "3. Actualizar Información Adicional\n" +
                    "4. Eliminar Información Adicional\n" +
                    "5. Calcular IMC\n" +
                    "0. Volver al menú principal");

            informationOption = sc.nextInt();
            sc.nextLine();

            switch (informationOption) {
                case 1:
                    System.out.println("Crear Información Adicional");
                    additionalInformationService.createAdditionalInformation(additionalInformation);
                    break;
                case 2:
                    System.out.println("Listar Información Adicional");
                    additionalInformationService.listingAdditionalInformation();
                    break;
                case 3:
                    System.out.println("Actualizar Información Adicional");
                    additionalInformationService.updateAdditionalInformation(additionalInformation);
                    break;
                case 4:
                    System.out.println("Borrar Información Adicional");
                    additionalInformationService.deleteAdditionalInformation();
                    break;
                case 5:
                    System.out.println("Calcular IMC");
                    additionalInformationService.calcularIMC();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        }
    }


}

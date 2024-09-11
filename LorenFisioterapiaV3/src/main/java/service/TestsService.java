package service;

import model.AdditionalInformation;
import model.Employee;
import model.Patient;
import model.Plan;

public class TestsService {
    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        Patient patient = new Patient();

        //patientService.createPatient(patient);

       EmployeeService employeeService = new EmployeeService();
       Employee employee = new Employee();

       //employeeService.createEmployee(employee);

       PlanService planService = new PlanService();
       Plan plan = new Plan();

       //planService.createPlan(plan);

       AdditionalInformationService additionalInformationService = new AdditionalInformationService();
       AdditionalInformation additionalInformation = new AdditionalInformation();

       additionalInformationService.createAdditionalInformation(additionalInformation);

    }
}

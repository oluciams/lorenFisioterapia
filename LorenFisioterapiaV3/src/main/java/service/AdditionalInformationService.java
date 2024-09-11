package service;


import dao.AdditionalInformationDao;
import dao.PatientDao;
import model.AdditionalInformation;
import model.Patient;


import java.util.Scanner;

public class AdditionalInformationService {
    Scanner sc = new Scanner(System.in);
    public void createAdditionalInformation(AdditionalInformation additionalInformation) {
        System.out.println("Ingresa los datos adicionales del paciente: \n");

        System.out.println("Cirugias:");
        String surgicalAnts = sc.nextLine();
        System.out.println("Estatura:");
        double height = sc.nextDouble();
        System.out.println("Peso:");
        sc.nextLine();
        double weight = sc.nextDouble();
        sc.nextLine();
        System.out.println("Diagnostico:");
        String diagnosis = sc.nextLine();        
        System.out.println("Observaciones:");
        String observations = sc.nextLine();

        additionalInformation.setSurgicalAnts(surgicalAnts);
        additionalInformation.setHeight(height);
        additionalInformation.setWeight(weight);
        additionalInformation.setDiagnosis(diagnosis);
        additionalInformation.setObservations(observations);

        AdditionalInformationDao.createAdditionalInformationDB(additionalInformation);
    }

    public void listingAdditionalInformation() {
        AdditionalInformationDao.listingAdditionalInformationDB();
    }

    public void deleteAdditionalInformation() {
        System.out.println("ingrese el id de la informacion adicional a eliminar");
        int addInformationId = sc.nextInt();

        AdditionalInformationDao.deleteAdditionalInformationDB(addInformationId);
    }

    public void updateAdditionalInformation(AdditionalInformation additionalInformation) {

        System.out.println("ingrese el id de la informacion adiciona para actualizar");
        int addInformationId = sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione : \n" +
                "1.Actualizar Diagnostico\n"
        );

        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                additionalInformation.setOpc(opc);
                System.out.println("indique el nuevo Diagnostico");
                String diagnosis = sc.nextLine();
                additionalInformation.setDiagnosis(diagnosis);
                additionalInformation.setAddInformationId(addInformationId);
                AdditionalInformationDao.updateAdditionalInformationDB(additionalInformation);
                break;
            default:
                System.out.println("seleccione una opcion valida");
                break;
        }
    }

    public void calcularIMC() {
        System.out.println("Ingrese el ID de la información adicional para calcular el IMC:");
        int addInformationId = sc.nextInt();
        sc.nextLine();

        AdditionalInformation additionalInformation = AdditionalInformationDao.getAdditionalInformationById(addInformationId);

        if (additionalInformation != null) {
            double imc = additionalInformation.calcularIMC();
            System.out.println("El IMC del paciente es: " + imc);
        } else {
            System.out.println("Información adicional no encontrada.");
        }
    }
}

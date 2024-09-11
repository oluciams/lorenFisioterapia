package service;

import dao.PlanDao;
import model.Plan;

import java.util.Scanner;

public class PlanService {
    Scanner sc = new Scanner(System.in);
    public void createPlan(Plan plan) {
        System.out.println("Ingresa los datos del plan: \n");
     
        System.out.println("Nombre del Plan");
        String namePlan = sc.nextLine();
        System.out.println("Precio:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Duración Cita:");
        int quantityAppointment = sc.nextInt();
        sc.nextLine();
        System.out.println("Area Afectada:");
        String treatmentArea = sc.nextLine();
        System.out.println("Tipo de Tratamiento:");
        String treatmentType = sc.nextLine();

        plan.setNamePlan(namePlan);
        plan.setPrice(price);
        plan.setQuantityAppointment(quantityAppointment);
        plan.setTreatmentArea(treatmentArea);
        plan.setTreatmentType(treatmentType);

        PlanDao.createPlanDB(plan);
    }

    public void listingPlans() {
        PlanDao.listingPlansDB();
    }

    public void deletePlans() {
        System.out.println("Ingrese el id del plan a eliminar");
        int planId = sc.nextInt();

        PlanDao.deletePlanDB(planId);

    }

    public void updatePlan(Plan plan) {

        System.out.println("Ingrese el id del plan a actualizar");
        int planId = sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione : \n" +
                "1.Actualizar nombre\n" +
                "2.Actualizar precio\n"
        );

        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1:
                plan.setOpc(opc);
                System.out.println("Indique el nuevo nombre del plan");
                String namePlan = sc.nextLine();
                plan.setNamePlan(namePlan);
                plan.setPlanId(planId);
                PlanDao.updatePlanDB(plan);
                break;
            case 2:
                plan.setOpc(opc);
                System.out.println("indique el nuevo precio");
                double price = sc.nextDouble();
                plan.setPrice(price);
                plan.setPlanId(planId);
                PlanDao.updatePlanDB(plan);
                break;
            default:
                System.out.println("seleccione una opcion valida");
                break;

        }
    }


}

import java.util.ArrayList; 
import java.util.Scanner;

public class PatientTesterRead {
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    public static void main(String[] args) {
        
        System.out.println("Reading list of patients from file patients.bin");
        patientList=Utils.readPatientsFromDisk("patients.bin");

        for (Patient patient: patientList) {
                    System.out.println(patient);
                    System.out.println();
        }

        System.out.println("Reading list of consultants from file consultants.bin");
        consultantList=Utils.readConsultantsFromDisk("consultants.bin");

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }



       

    }
}
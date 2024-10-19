import java.util.ArrayList; 

public class PatientTesterRead {
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    public static void main(String[] args) {
        

        String consultantsFile = "files/consultants.bin";
        String patientsFile = "files/patients.bin";

        System.out.println("Reading list of patients from file"+ patientsFile);
        patientList=Utils.readPatientsFromDisk(patientsFile);

        for (Patient patient: patientList) {
                    System.out.println(patient);
                    System.out.println();
        }

        System.out.println("Reading list of consultants from file"+ consultantsFile);
        consultantList=Utils.readConsultantsFromDisk(consultantsFile);

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }
    }
}
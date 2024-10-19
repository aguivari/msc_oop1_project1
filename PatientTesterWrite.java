import java.util.ArrayList; 
import java.util.Scanner;

public class PatientTesterWrite {
    static Scanner keyboardIn = new Scanner(System.in);
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    public static void main(String[] args) {

        String consultantsFile = "files/consultants.bin";
        String patientsFile = "files/patients.bin";
        
        patientList.add(new Patient("Ivan", "The Terrible", 18,10,1985, Gender.MALE, 173,90,105));
        patientList.add(new Patient("John", "Snow", 18,10,1985, Gender.MALE, 173,60,90));
        patientList.add(new Patient("Joanne", "Blizzard", 19,10,1984, Gender.FEMALE, 174,55,100));
        patientList.add(new Patient("Joan", "Heavyslit", 20,10,1984, Gender.FEMALE, 173,75,85));

        for (Patient patient: patientList) {
                    System.out.println(patient);
                    System.out.println();
        }

        System.out.println("Writing list of patients to file "+patientsFile);
        Utils.writePatientsToDisk(patientsFile, patientList);


        consultantList.add(new Consultant());
        consultantList.add(new Consultant("John", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Joanne", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Ivan", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }

        System.out.println("Writing list of consultants to file "+consultantsFile);
        Utils.writeConsultantsToDisk(consultantsFile, consultantList);


       

    }
}
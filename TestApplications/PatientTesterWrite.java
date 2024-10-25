package TestApplications;
import java.util.ArrayList; 

import  AuxClasses.Utils;
import  BaseClasses.Patient;
import  Enums.Gender;

public class PatientTesterWrite {
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public static void main(String[] args) {

        String patientsFile = "files/patients.bin";
        
        patientList.add(new Patient("Ivan", "The Terrible", 24,10,1985, Gender.MALE, 173,90,105));
        patientList.add(new Patient("John", "Snow", 23,10,1984, Gender.MALE, 173,60,90));
        patientList.add(new Patient("Joanne", "Blizzard", 24,10,1984, Gender.FEMALE, 174,55,100));
        patientList.add(new Patient("Joan", "Heavyslit", 25,10,1984, Gender.FEMALE, 173,75,85));

        for (Patient patient: patientList) {
                    System.out.println(patient);
                    System.out.println();
        }

        System.out.println("Writing list of patients to file "+patientsFile);
        Utils.writePatientsToDisk(patientsFile, patientList);       

    }
}
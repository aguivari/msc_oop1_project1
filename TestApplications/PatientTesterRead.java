package TestApplications;
import java.util.ArrayList;

import  AuxClasses.Utils;
import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality; 

public class PatientTesterRead {
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    public static void main(String[] args) {

        String patientsFile = "files/patients.bin";
        int max;
        
        System.out.println("Reading list of patients from file"+ patientsFile);
        patientList=Utils.readPatientsFromDisk(patientsFile);

        for (Patient patient: patientList) {
            System.out.println(patient);
            System.out.println();
        }

        max=Utils.getMaxPatientNo(patientList);
        System.out.println("Resetting basePatientNo to "+max);
        patientList.get(0).resetBasePatientNo(max);

        patientList.add(new Patient("Ivan", "The Terrible", 18,10,1985, Gender.MALE, 173,90,105));
        patientList.add(new Patient("John", "Snow", 18,10,1985, Gender.MALE, 173,60,90));
        patientList.add(new Patient("Joanne", "Blizzard", 19,10,1984, Gender.FEMALE, 174,55,100));
        patientList.add(new Patient("Joan", "Heavyslit", 20,10,1984, Gender.FEMALE, 173,75,85));
        for (Patient patient: patientList) {
            System.out.println(patient);
            System.out.println();
        }
    }
}
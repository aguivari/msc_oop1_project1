package TestApplications;
import java.util.ArrayList;

import AuxClasses.Utils;
import BaseClasses.Patient;
import Enums.Gender;
import Interfaces.PatientAPI;

public class PatientTesterRead {
    public static void main(String[] args) {
        String patientsFile = "files/patients.bin";
        int max;
        PatientAPI patients=new PatientAPI();

        System.out.println("Reading list of patients from file"+ patientsFile);
        patients.readFromDisk(patientsFile);

        for (Patient patient: patients.getAll()) {
            System.out.println(patient);
            System.out.println();
        }

        patients.add(new Patient("Ivan", "The Terrible", 18,10,1985, Gender.MALE, 173,90,105));
        patients.add(new Patient("John", "Snow", 18,10,1985, Gender.MALE, 173,60,90));
        patients.add(new Patient("Joanne", "Blizzard", 19,10,1984, Gender.FEMALE, 174,55,100));
        patients.add(new Patient("Joan", "Heavyslit", 20,10,1984, Gender.FEMALE, 173,75,85));
        for (Patient patient: patients.getAll()) {
            System.out.println(patient);
            System.out.println();
        }
    }
}
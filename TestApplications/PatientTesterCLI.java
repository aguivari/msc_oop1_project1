package TestApplications;
import java.util.ArrayList;
import java.util.Scanner;

import  AuxClasses.Utils;
import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality;

public class PatientTesterCLI {
    static Scanner keyboardIn = new Scanner(System.in);
    static ArrayList<Patient> patientList = new ArrayList<Patient>();
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    public static void main(String[] args) {
        //mainMenu();
        patientList.add(new Patient("Ivan", "The Terrible", 18,10,1985, Gender.MALE, 173,90,105));
        patientList.add(new Patient("John", "Snow", 18,10,1985, Gender.MALE, 173,60,90));
        patientList.add(new Patient("Joanne", "Blizzard", 19,10,1984, Gender.FEMALE, 174,55,100));
        patientList.add(new Patient("Joan", "Heavyslit", 20,10,1984, Gender.FEMALE, 173,75,85));

        for (Patient patient: patientList) {
                    System.out.println(patient);
                    System.out.println();
        }

        //Utils.dumpPatientsCSV(patientList);

        System.out.println("Average Heigth: "+Utils.averageHeigth(patientList.get(1), patientList.get(2), patientList.get(3)));
        System.out.println("Average Weigth: "+Utils.averageWeigth(patientList.get(1), patientList.get(2), patientList.get(3)));
        System.out.println("Average Abdominal Circunference: "+Utils.averageAbdCirc(patientList.get(1), patientList.get(2), patientList.get(3)));

        consultantList.add(new Consultant());
        consultantList.add(new Consultant("John", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }

        consultantList.get(1).setContractType(ContractType.TEMPORARY);
        consultantList.get(1).setSpeciality(Speciality.PHYSIOTHERAPY);
        System.out.println(consultantList.get(1));
        System.out.println();

    }

    public static void mainMenu() {
        int input=-1;
        while (input!=0) {
            System.out.print("MENU\n");
            System.out.print("1 - Patient Management\n");
            System.out.print("2 - Patient Operations\n");
            System.out.print("3 - Database Operations\n");
            System.out.print("0 - Exit Program\n");
            System.out.print("Your option: ");
            try {
                input = keyboardIn.nextInt();
                switch (input) {
                    case 1:
                        patientManagementMenu();
                        break;
                    case 2:
                        patientOperationsMenu();
                        break;
                    case 3:
                        databaseOperationsMenu();
                        break;
                    case 0:
                        System.out.print("Exitting Program!\n");
                        System.exit(0);;
                        break;
                    default:
                        System.out.print("Invalid Option!\n");
                }
            }
            catch (Exception exc) {
                input = -1;
                keyboardIn.next();


            }


        }
    }

    public static void patientManagementMenu() {
        System.out.print("Patient Management\n");
        System.out.print("1 - Insert new Patient\n");
        System.out.print("2 - Edit Existing Patient Details\n");
        System.out.print("3 - Remove Existing Patient\n");
        System.out.print("0 - Exit Menu\n");
        System.out.print("Your option: ");
    }

    public static void patientOperationsMenu() {
        System.out.print("Patient Operations\n");
        System.out.print("1 - Display IMC\n");
        System.out.print("2 - Calculate Risk\n");
        System.out.print("3 - Remove Existing Patient\n");
        System.out.print("0 - Exit Menu\n");
        System.out.print("Your option: ");
    }

    public static void databaseOperationsMenu() {
        System.out.print("Database Operations\n");
        System.out.print("1 - Clear Database\n");
        System.out.print("2 - Load Database\n");
        System.out.print("3 - Save Database\n");
        System.out.print("0 - Exit Menu\n");
        System.out.print("Your option: ");
    }
}
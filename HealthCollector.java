import java.time.LocalDate;
import java.lang.Math;
import java.io.File;

import Interfaces.MeasurementAPI;
import Interfaces.PatientAPI;
import Interfaces.ConsultantAPI;

import BaseClasses.Patient;
import BaseClasses.Consultant;

import Enums.ContractType;
import Enums.Gender;
import Enums.Speciality;

import Records.Measurement;

import AuxClasses.Date;
import AuxClasses.Utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class HealthCollector {
    
    public static void main(String[] args) {

        Boolean consultantsFileExist, patientsFileExist, measurementsFileExist;

        String consultantsFile = "files/consultants.bin";
        String patientsFile = "files/patients.bin";
        String measurementsFile = "files/measurements.bin";

        MeasurementAPI measurements=new MeasurementAPI();
        ConsultantAPI consultants=new ConsultantAPI();
        PatientAPI patients=new PatientAPI();

        Locale locale = Locale.getDefault(); 

        ResourceBundle appResourceBundle = ResourceBundle.getBundle("HealthCollector", locale);
        System.out.println(appResourceBundle.getString("SystemLocale")+": "+locale); 

        System.out.println(appResourceBundle.getString("Consultant")+": "+appResourceBundle.getString("CheckingDatabase"));
        consultantsFileExist=checkFile(consultantsFile);
        if (consultantsFileExist) {
            System.out.println(appResourceBundle.getString("Consultant")+": "+appResourceBundle.getString("ReadingDatabaseFromFile")+": "+ consultantsFile);
            consultants.readFromDisk(consultantsFile);
        } else {
            System.out.println(appResourceBundle.getString("Consultant")+": "+appResourceBundle.getString("NoDatabaseFound"));
        }

        System.out.println(appResourceBundle.getString("Patient")+": "+appResourceBundle.getString("CheckingDatabase"));
        patientsFileExist=checkFile(patientsFile);
        if (patientsFileExist) {
            System.out.println(appResourceBundle.getString("Patient")+": "+appResourceBundle.getString("ReadingDatabaseFromFile")+": "+ patientsFile);
            patients.readFromDisk(patientsFile);
        } else {
            System.out.println(appResourceBundle.getString("Patient")+": "+appResourceBundle.getString("NoDatabaseFound"));
        }

        System.out.println(appResourceBundle.getString("Measurements")+": "+appResourceBundle.getString("CheckingDatabase"));
        measurementsFileExist=checkFile(measurementsFile);
        if (measurementsFileExist) {
            System.out.println(appResourceBundle.getString("Measurements")+": "+appResourceBundle.getString("ReadingDatabaseFromFile")+": "+ measurementsFile);
            measurements.readFromDisk(measurementsFile);
        } else {
            System.out.println(appResourceBundle.getString("Measurements")+": "+appResourceBundle.getString("NoDatabaseFound"));
        }

        if (patientsFileExist & consultantsFileExist & measurementsFileExist) {
            //show data read from files into memory
            for (Consultant consultant: consultants.getAll()) {
                System.out.println(consultant);
                System.out.println();
            }

            for (Patient patient: patients.getAll()) {
                System.out.println(patient);
                System.out.println();
            }

            for (Measurement measurement: measurements.getAll()) {
                System.out.println(measurement);
            }

            System.out.println(appResourceBundle.getString("AddingEntries")+":");
            consultants.add(new Consultant("John", "Snow", 23,10,1985, Gender.MALE, Speciality.PHYSIOTHERAPY, ContractType.PERMANENT));
            patients.add(new Patient("Ivan", "The Terrible", 24,10,1985, Gender.MALE, 173,90,105));
            patients.add(new Patient("John", "Snow", 23,10,1984, Gender.MALE, 183,60,90));
            System.out.println(appResourceBundle.getString("Adding"));
            for (Consultant consultant: consultants.getAll()) {
                System.out.println(appResourceBundle.getString("Using")+" "+appResourceBundle.getString("Consultant")+": "+consultant.getName()+" "+consultant.getSurname());
                for (Patient patient: patients.getAll()) {
                    System.out.println(appResourceBundle.getString("Using")+" "+appResourceBundle.getString("Patient")+": "+patient.getName()+" "+patient.getSurname());
                    LocalDate today = LocalDate.now();
                    int day = today.getDayOfMonth();
                    int month = today.getMonthValue();
                    int year = today.getYear();
                    Date date = new Date(day, month, year);
                    measurements.add(new Measurement(patient, consultant, date, Utils.round2digits(50+60*Math.random()), Utils.round2digits(50+150*Math.random()),Utils.round2digits(50+100*Math.random())));
                }
            }

            System.out.println(appResourceBundle.getString("ShowingCurrentContents"));
            for (Consultant consultant: consultants.getAll()) {
                System.out.println(consultant);
                System.out.println();
            }

            for (Patient patient: patients.getAll()) {
                System.out.println(patient);
                System.out.println();
            }

            for (Measurement measurement: measurements.getAll()) {
                System.out.println(measurement);
            }

            System.out.println(appResourceBundle.getString("Measurements")+": "+appResourceBundle.getString("WritingListToFile")+" "+measurementsFile);
            measurements.writeToDisk(measurementsFile);

            System.out.println(appResourceBundle.getString("Consultant")+": "+appResourceBundle.getString("WritingListToFile")+" "+consultantsFile);
            consultants.writeToDisk(consultantsFile);

            System.out.println(appResourceBundle.getString("Patient")+": "+appResourceBundle.getString("WritingListToFile")+" "+patientsFile);
            patients.writeToDisk(patientsFile);
        } else {
            //Nothing found on files, adding some entries
            System.out.println(appResourceBundle.getString("Consultant")+": "+appResourceBundle.getString("AddingEntries"));
            consultants.add(new Consultant("Joanne", "Winter", 24,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
            consultants.add(new Consultant("Ivan", "Hall", 25,10,1985, Gender.MALE, Speciality.PAEDIATRICIAN, ContractType.PERMANENT));

            for (Consultant consultant: consultants.getAll()) {
                System.out.println(consultant);
                System.out.println();
            }

            System.out.println(appResourceBundle.getString("Patient")+": "+appResourceBundle.getString("AddingEntries"));
            patients.add(new Patient("Joanne", "Blizzard", 24,10,1984, Gender.FEMALE, 174,55,100));
            patients.add(new Patient("Joan", "Heavyslit", 25,10,1984, Gender.FEMALE, 173,75,85));

            for (Patient patient: patients.getAll()) {
                System.out.println(patient);
                System.out.println();
            }

            System.out.println(appResourceBundle.getString("Measurements")+": "+appResourceBundle.getString("AddingEntries"));
            for (Consultant consultant: consultants.getAll()) {
                System.out.println(appResourceBundle.getString("Using")+" "+appResourceBundle.getString("Consultant")+": "+consultant.getName()+" "+consultant.getSurname());
                for (Patient patient: patients.getAll()) {
                    System.out.println(appResourceBundle.getString("Using")+" "+appResourceBundle.getString("Patient")+": "+patient.getName()+" "+patient.getSurname());
                    LocalDate today = LocalDate.now();
                    int day = today.getDayOfMonth();
                    int month = today.getMonthValue();
                    int year = today.getYear();
                    Date date = new Date(day, month, year);
                    measurements.add(new Measurement(patient, consultant, date, Utils.round2digits(50+60*Math.random()), Utils.round2digits(50+150*Math.random()),Utils.round2digits(50+100*Math.random())));
                }
            }

            for (Measurement measurement: measurements.getAll()) {
                System.out.println(measurement);
            }

            System.out.println(appResourceBundle.getString("Measurements")+": "+appResourceBundle.getString("WritingListToFile")+" "+measurementsFile);
            measurements.writeToDisk(measurementsFile);

            System.out.println(appResourceBundle.getString("Consultant")+": "+appResourceBundle.getString("WritingListToFile")+" "+consultantsFile);
            consultants.writeToDisk(consultantsFile);

            System.out.println(appResourceBundle.getString("Patient")+": "+appResourceBundle.getString("WritingListToFile")+" "+patientsFile);
            patients.writeToDisk(patientsFile);
        }

        System.out.println("List of Patients");
        
        for (Patient patient: patients.getAll()) {
            System.out.println(patient);
            System.out.println();
        }
        System.out.println("Skinniest Patient");
        System.out.println(patients.getMinWeightPatient(1));
        System.out.println("4 Skinniest Patients");
        patients.getMinWeightPatient(4).stream().forEach(System.out::print); 
        System.out.println("Fattest Patient");
        System.out.println(patients.getMaxWeightPatient());
        System.out.println("Shortest Patient");
        System.out.println(patients.getMinHeightPatient());
        System.out.println("Talles Patient");
        System.out.println(patients.getMaxHeightPatient());

        System.out.println(consultants.getConsultantCountBySpecialty());
        System.out.println(consultants.getConsultantCountBySpecialty(Speciality.PAEDIATRICIAN));
        System.out.println(patients.getPatientCountBySurname());
        System.out.println(patients.getPatientCountBySurname("Snow"));

    }

    public static Boolean checkFile(String fileName) {
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) { 
            return true;
        } else {
            return false;
        }
    }

}
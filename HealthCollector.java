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

public class HealthCollector {
    public static void main(String[] args) {

        Boolean consultantsFileExist, patientsFileExist, measurementsFileExist;

        String consultantsFile = "files/consultants.bin";
        String patientsFile = "files/patients.bin";
        String measurementsFile = "files/measurements.bin";

        MeasurementAPI measurements=new MeasurementAPI();
        ConsultantAPI consultants=new ConsultantAPI();
        PatientAPI patients=new PatientAPI();

        System.out.println("Checking for consultants database");

        consultantsFileExist=checkFile(consultantsFile);
        if (consultantsFileExist) {
            System.out.println("Reading list of consultants from file"+ consultantsFile);
            consultants.readFromDisk(consultantsFile);
        } else {
            System.out.println("No consultants database found, starting anew");
        }
        patientsFileExist=checkFile(patientsFile);
        if (patientsFileExist) {
            System.out.println("Reading list of patients from file"+ patientsFile);
            patients.readFromDisk(patientsFile);
        } else {
            System.out.println("No database found, starting anew");
        }
        System.out.println("Checking for measurements database");
        measurementsFileExist=checkFile(measurementsFile);
        if (measurementsFileExist) {
            System.out.println("Reading list of measurements from file"+ measurementsFile);
            measurements.readFromDisk(measurementsFile);
        } else {
            System.out.println("No measurements database found, starting anew");
        }

        if (patientsFileExist & consultantsFileExist && measurementsFileExist) {
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

            System.out.println("Adding new entries in each category:");
            consultants.add(new Consultant("John", "Snow", 23,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
            patients.add(new Patient("Ivan", "The Terrible", 24,10,1985, Gender.MALE, 173,90,105));
            patients.add(new Patient("John", "Snow", 23,10,1984, Gender.MALE, 173,60,90));
            System.out.println("Adding more random measurements");
            for (Consultant consultant: consultants.getAll()) {
                System.out.println("Using consultant:"+consultant.getName()+" "+consultant.getSurname());
                for (Patient patient: patients.getAll()) {
                    System.out.println("Using patient:"+patient.getName()+" "+patient.getSurname());
                    LocalDate today = LocalDate.now();
                    int day = today.getDayOfMonth();
                    int month = today.getMonthValue();
                    int year = today.getYear();
                    Date date = new Date(day, month, year);
                    measurements.add(new Measurement(patient, consultant, date, Utils.round2digits(50+60*Math.random()), Utils.round2digits(50+150*Math.random()),Utils.round2digits(50+100*Math.random())));
                }
            }

            System.out.println("Showing Current Contents");
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

            System.out.println("Writing list of measurements to file "+measurementsFile);
            measurements.writeToDisk(measurementsFile);

            System.out.println("Writing list of consultants to file "+consultantsFile);
            consultants.writeToDisk(consultantsFile);

            System.out.println("Writing list of patients to file "+patientsFile);
            patients.writeToDisk(patientsFile);
        } else {
            //Nothing found on files, adding some entries
            System.out.println("Creating some Consultants");
            consultants.add(new Consultant("Joanne", "Winter", 24,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
            consultants.add(new Consultant("Ivan", "Hall", 25,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

            for (Consultant consultant: consultants.getAll()) {
                System.out.println(consultant);
                System.out.println();
            }

            System.out.println("Creating some Patients");
            patients.add(new Patient("Joanne", "Blizzard", 24,10,1984, Gender.FEMALE, 174,55,100));
            patients.add(new Patient("Joan", "Heavyslit", 25,10,1984, Gender.FEMALE, 173,75,85));

            for (Patient patient: patients.getAll()) {
                System.out.println(patient);
                System.out.println();
            }

            System.out.println("Adding some random measurements");
            for (Consultant consultant: consultants.getAll()) {
                System.out.println("Using consultant:"+consultant.getName()+" "+consultant.getSurname());
                for (Patient patient: patients.getAll()) {
                    System.out.println("Using patient:"+patient.getName()+" "+patient.getSurname());
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

            System.out.println("Writing list of measurements to file "+measurementsFile);
            measurements.writeToDisk(measurementsFile);

            System.out.println("Writing list of consultants to file "+consultantsFile);
            consultants.writeToDisk(consultantsFile);

            System.out.println("Writing list of patients to file "+patientsFile);
            patients.writeToDisk(patientsFile);
        }
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
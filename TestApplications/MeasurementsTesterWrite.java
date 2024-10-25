package TestApplications;
import java.util.ArrayList; 
import java.time.LocalDate;
import java.lang.Math;

import AuxClasses.Utils;
import BaseClasses.Consultant;
import BaseClasses.Date;
import BaseClasses.Patient;
import Enums.ContractType;
import Enums.Gender;
import Enums.Speciality;
import Records.Measurement;

public class MeasurementsTesterWrite {
    static ArrayList<Measurement> measurementList = new ArrayList<Measurement>();
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    static ArrayList<Patient> patientList = new ArrayList<Patient>();

    public static void main(String[] args) {

        String measurementsFile = "files/measurements.bin";
        
        //set list of patients
        patientList.add(new Patient("Ivan", "The Terrible", 24,10,1985, Gender.MALE, 173,90,105));
        patientList.add(new Patient("John", "Snow", 23,10,1984, Gender.MALE, 173,60,90));
        patientList.add(new Patient("Joanne", "Blizzard", 24,10,1984, Gender.FEMALE, 174,55,100));
        patientList.add(new Patient("Joan", "Heavyslit", 25,10,1984, Gender.FEMALE, 173,75,85));

        //set list of consultants
        consultantList.add(new Consultant("John", "Snow", 23,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Ivan", "Snow", 25,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        //add some measurements
        for (Consultant consultant: consultantList) {
            System.out.println("Using consultant:"+consultant.getName()+" "+consultant.getSurname());
            
            for (Patient patient: patientList) {
                System.out.println("Using patient:"+patient.getName()+" "+patient.getSurname());
                LocalDate today = LocalDate.now();
                int day = today.getDayOfMonth();
                int month = today.getMonthValue();
                int year = today.getYear();
                Date date = new Date(day, month, year);
                measurementList.add(new Measurement(patient, consultant, date, Utils.round2digits(50+60*Math.random()), Utils.round2digits(50+150*Math.random()),Utils.round2digits(50+100*Math.random())));
            }
        }

        for (Measurement measurement: measurementList) {
            System.out.println(measurement);
        }
        System.out.println("Writing list of consultants to file "+measurementsFile);
        Utils.writeMeasurementsToDisk(measurementsFile, measurementList);
             

    }
}
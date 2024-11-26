package TestApplications;

import java.time.LocalDate;
import java.lang.Math;

import AuxClasses.Date;
import AuxClasses.Utils;
import BaseClasses.Consultant;
import BaseClasses.Patient;
import Enums.ContractType;
import Enums.Gender;
import Enums.Speciality;
import Records.Measurement;
import Interfaces.MeasurementAPI;
import Interfaces.ConsultantAPI;
import Interfaces.PatientAPI;

public class MeasurementsTesterWrite {
    public static void main(String[] args) {
        String measurementsFile = "files/measurements.bin";
        MeasurementAPI measurements=new MeasurementAPI();
        ConsultantAPI consultants=new ConsultantAPI();
        PatientAPI patients=new PatientAPI();

        //set list of patients
        patients.add(new Patient("Ivan", "The Terrible", 24,10,1985, Gender.MALE, 173,90,105));
        patients.add(new Patient("John", "Snow", 23,10,1984, Gender.MALE, 173,60,90));
        patients.add(new Patient("Joanne", "Blizzard", 24,10,1984, Gender.FEMALE, 174,55,100));
        patients.add(new Patient("Joan", "Heavyslit", 25,10,1984, Gender.FEMALE, 173,75,85));

        //set list of consultants
        consultants.add(new Consultant("John", "Snow", 23,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultants.add(new Consultant("Ivan", "Snow", 25,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        //add some measurements
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

        System.out.println(measurements.getLast());

        System.out.println("Writing list of measurements to file "+measurementsFile);
        measurements.writeToDisk(measurementsFile);
    }
}
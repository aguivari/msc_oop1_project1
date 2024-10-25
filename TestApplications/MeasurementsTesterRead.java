package TestApplications;
import java.util.ArrayList;

import  AuxClasses.Utils;
import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality;
import Records.Measurement; 

public class MeasurementsTesterRead {
    static ArrayList<Measurement> measurementList = new ArrayList<Measurement>();
    public static void main(String[] args) {
        String measurementsFile = "files/measurements.bin";

        System.out.println("Reading list of patients from file"+ measurementsFile);
        measurementList=Utils.readMeasurementsFromDisk(measurementsFile);

        for (Measurement measurement: measurementList) {
            System.out.println(measurement);
            System.out.println();
        }
    }
}
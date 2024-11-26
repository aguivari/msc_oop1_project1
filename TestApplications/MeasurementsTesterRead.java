package TestApplications;

import Records.Measurement;
import Interfaces.MeasurementAPI;

public class MeasurementsTesterRead {
    public static void main(String[] args) {
        String measurementsFile = "files/measurements.bin";

        MeasurementAPI measurements = new MeasurementAPI();

        System.out.println("Reading list of patients from file"+ measurementsFile);
        measurements.readFromDisk(measurementsFile);

        for (Measurement measurement: measurements.getAll()) {
            System.out.println(measurement);
            System.out.println();
        }
    }
}
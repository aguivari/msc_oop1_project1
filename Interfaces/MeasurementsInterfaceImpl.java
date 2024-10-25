package Interfaces;

import java.util.ArrayList;

import Records.Measurement;

public class MeasurementsInterfaceImpl implements MeasurementsInterface {
    private ArrayList<Measurement> measurementList;


    public void createMeasurementList() {
        measurementList = new ArrayList<Measurement>();
    }

    public void addMeasurement(Measurement measurement) {
        measurementList.add(measurement);
    }

    public ArrayList<Measurement> getMeasurements() {
        return measurementList;
    }

    public ArrayList<Measurement> getMeasurementsByDate() {
        return measurementList;
    }

    public ArrayList<Measurement> getMeasurementsByConsultant() {
        return measurementList;
    }

    public ArrayList<Measurement> getMeasurementsByPatient() {
        return measurementList;
    }

    public ArrayList<Measurement> getMeasurementsByPatientAge() {
        return measurementList;
    }
}

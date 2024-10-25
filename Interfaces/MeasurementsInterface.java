package Interfaces;

import java.util.ArrayList;

import Records.Measurement;

public interface MeasurementsInterface {
    public void createMeasurementList();
    public void addMeasurement(Measurement measurement);
    public ArrayList<Measurement> getMeasurements();
    public ArrayList<Measurement> getMeasurementsByDate();
    public ArrayList<Measurement> getMeasurementsByConsultant();
    public ArrayList<Measurement> getMeasurementsByPatient();
    public ArrayList<Measurement> getMeasurementsByPatientAge();
}

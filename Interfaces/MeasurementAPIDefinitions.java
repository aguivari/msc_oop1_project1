package Interfaces;

import java.util.ArrayList;

import Records.Measurement;
import AuxClasses.Date;

public interface MeasurementAPIDefinitions {
    public void trim();
    public int getSize();
    public void add(Measurement measurement);
    public ArrayList<Measurement> getAll();
    public Measurement getLast();
    public ArrayList<Measurement> getAllByDate(Date argument);
    public ArrayList<Measurement> getAllByConsultant(int argument);
    public ArrayList<Measurement> getAllByPatient(int argument);
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
}

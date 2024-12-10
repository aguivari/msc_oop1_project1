package Interfaces;

import java.util.ArrayList;

import Records.Measurement;
import BaseClasses.Consultant;
import BaseClasses.Patient;
import AuxClasses.Date;

public interface MeasurementAPIDefinitions {
    public void trim();
    public int getSize();
    public void add(Measurement measurement);
    public Measurement getLast();
    public ArrayList<Measurement> getAll();
    public ArrayList<Measurement> getAll(Date argument);
    public ArrayList<Measurement> getAll(Patient argument);
    public ArrayList<Measurement> getAll(Consultant argument);
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
}

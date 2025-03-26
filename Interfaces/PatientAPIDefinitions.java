package Interfaces;

import java.util.ArrayList;

import BaseClasses.Patient;

public sealed interface PatientAPIDefinitions permits PatientAPI {
    public void trim();
    public int getSize();
    public void add(Patient patient);
    public ArrayList<Patient> getAll();
    public Patient getLast();
    public Patient getMinWeightPatient();
    public Patient getMaxWeightPatient();
    public Patient getMinHeightPatient();
    public Patient getMaxHeightPatient();
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
    public void dumpCSV();
}

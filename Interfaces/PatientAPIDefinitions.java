package Interfaces;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

import BaseClasses.Patient;

public sealed interface PatientAPIDefinitions permits PatientAPI {
    public void trim();
    public int getSize();
    public void add(Patient patient);
    public ArrayList<Patient> getAll();
    public Patient getLast();
    public Patient getMinWeightPatient();
    public ArrayList<Patient> getMinWeightPatient(int n);
    public Patient getMaxWeightPatient();
    public ArrayList<Patient> getMaxWeightPatient(int n);
    public Patient getMinHeightPatient();
    public ArrayList<Patient> getMinHeightPatient(int n);
    public Patient getMaxHeightPatient();
    public ArrayList<Patient> getMaxHeightPatient(int n);
    public long getPatientCountBySurname(String argument);
    public Map<String, Long> getPatientCountBySurname();
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
    public void dumpCSV();
}

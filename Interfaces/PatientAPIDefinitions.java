package Interfaces;

import java.util.ArrayList;
import java.util.stream.Stream;

import BaseClasses.Patient;

public sealed interface PatientAPIDefinitions permits PatientAPI {
    public void trim();
    public int getSize();
    public void add(Patient patient);
    public ArrayList<Patient> getAll();
    public Patient getLast();
    public Patient getMinWeightPatient();
    public Stream<Patient> getMinWeightPatient(int n);
    public Patient getMaxWeightPatient();
    public Stream<Patient> getMaxWeightPatient(int n);
    public Patient getMinHeightPatient();
    public Stream<Patient> getMinHeightPatient(int n);
    public Patient getMaxHeightPatient();
    public Stream<Patient> getMaxHeightPatient(int n);
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
    public void dumpCSV();
}

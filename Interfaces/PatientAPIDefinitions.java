package Interfaces;

import java.util.ArrayList;

import BaseClasses.Patient;

public interface PatientAPIDefinitions {
    public void trim();
    public int getSize();
    public void add(Patient measurement);
    public ArrayList<Patient> getAll();
    public Patient getLast();
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
}

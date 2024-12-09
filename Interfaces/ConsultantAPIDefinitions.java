package Interfaces;

import java.util.ArrayList;

import BaseClasses.Consultant;

public interface ConsultantAPIDefinitions {
    public void trim();
    public int getSize();
    public void add(Consultant consultant);
    public ArrayList<Consultant> getAll();
    public Consultant getLast();
    public void writeToDisk(String filename);
    public void readFromDisk(String filename);
}

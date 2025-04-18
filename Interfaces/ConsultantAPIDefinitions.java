package Interfaces;

import java.util.ArrayList;
import java.util.Map;

import BaseClasses.Consultant;
import Enums.Specialty;

public sealed interface ConsultantAPIDefinitions permits ConsultantAPI {
    public void trim();

    public int getSize();

    public void add(Consultant consultant);

    public ArrayList<Consultant> getAll();

    public Map<Specialty, Long> getConsultantCountBySpecialty();

    public long getConsultantCountBySpecialty(Specialty argument);

    public Consultant getLast();

    public void writeToDisk(String filename);

    public void readFromDisk(String filename);
}

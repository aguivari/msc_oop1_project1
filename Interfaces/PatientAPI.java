package Interfaces;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import BaseClasses.Patient;

public class PatientAPI implements PatientAPIDefinitions {
    private ArrayList<Patient> patientList;

    public PatientAPI() {
        patientList = new ArrayList<Patient>();
    }

    public void trim() {
        patientList.clear();

    };
   
    public int getSize() {
        return this.patientList.size();
    };

    public void add(Patient patient) {
        patientList.add(patient);
    }

    public ArrayList<Patient> getAll() {
        return patientList;
    }

    public Patient getLast() {
        return patientList.get(patientList.size()-1);
    }

    public void writeToDisk(String filename) {
        try{
            FileOutputStream writeData = new FileOutputStream(filename);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(this.patientList);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromDisk(String filename) {
        this.trim();
        ArrayList<Patient> tempList = new ArrayList<Patient>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            try {
                tempList = (ArrayList<Patient>)readStream.readObject();
            } catch (EOFException e) {
                System.out.println("error: reached end of file");
            }
            readStream.close();
            for (Patient patient: tempList) {
                this.add(patient);
            }
            int max=getMaxIndex();
            System.out.println("Resetting basePatientNo to "+max);
            patientList.get(0).resetBasePatientNo(max);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getMaxIndex() {
        int maxIndex=0;
        for (Patient patient: this.patientList) {
            if (patient.getPatientNo()>maxIndex) {
                maxIndex=patient.getPatientNo();
            }
        }
        return maxIndex;
    }
}

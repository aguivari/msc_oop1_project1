package Interfaces;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Locale;
import java.util.ResourceBundle;

import BaseClasses.Patient;


public final class PatientAPI implements PatientAPIDefinitions {
    private ArrayList<Patient> patientList;

    public PatientAPI() {
        patientList = new ArrayList<>();
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

    @SuppressWarnings("unchecked")
    public void readFromDisk(String filename) {
        this.trim();
        ResourceBundle patientAPIResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());
        var tempList = new ArrayList<Patient>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            try {
                tempList = (ArrayList<Patient>)readStream.readObject();
            } catch (EOFException e) {
                System.out.println(patientAPIResourceBundle.getString("ErrorEOF"));
            }
            readStream.close();
            for (Patient patient: tempList) {
                this.add(patient);
            }
            int max=getMaxIndex();
            System.out.println(patientAPIResourceBundle.getString("ResetBasePatientNo")+" "+max);
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

    public void dumpCSV() {
        //generates CSV list of patients
        //print header
        System.out.println("Patient Number,Name,Surname,DoB,Age,Gender,Heigth,Weigth,Abdominal Circunference,IMC,IMC Classification,Abdominal Risk Classification");
        for (Patient patient: this.patientList) {
            System.out.print(patient.getPatientNo()+",");
            System.out.print(patient.getName()+",");
            System.out.print(patient.getSurname()+",");
            System.out.print(patient.getFullDate()+",");
            System.out.print(patient.getAge()+",");
            System.out.print(patient.getGender().label+",");
            System.out.print(patient.getHeight()+",");
            System.out.print(patient.getWeight()+",");
            System.out.print(patient.getCMI()+",");
            System.out.print(patient.getCMIClass()+",");
            System.out.print(patient.getAbdCirc()+",");
            System.out.println(patient.getAbdCircRisk());
        }
    }




}

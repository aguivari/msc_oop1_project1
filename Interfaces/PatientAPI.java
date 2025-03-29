package Interfaces;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.List;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import BaseClasses.Patient;
import Enums.Speciality;

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
        return new ArrayList<Patient>(patientList);
    }

    public Patient getLast() {
        //return defensive copy of patient
        return new Patient(patientList.get(patientList.size()-1));
    }

    public Patient getMinWeightPatient() {
        return patientList
                .stream()
                .min(Comparator.comparing(Patient::getWeight))
                .orElseThrow(NoSuchElementException::new);
    }

    public ArrayList<Patient> getMinWeightPatient(int n) {
        return new ArrayList<Patient>(patientList
                .stream()
                .sorted(Patient::compareWeight)
                .limit(n)
                .collect(Collectors.toList()));
    }
    
    public Patient getMaxWeightPatient() {
        return patientList
                .stream()
                .max(Comparator.comparing(Patient::getWeight))
                .orElseThrow(NoSuchElementException::new);
    }

    public ArrayList<Patient>  getMaxWeightPatient(int n) {
        return new ArrayList<Patient>(patientList
                .stream()
                .sorted(Patient::compareWeight)
                .limit(n)
                .collect(Collectors.toList()));
    }

    public Patient getMinHeightPatient() {
        return patientList
                .stream()
                .min(Comparator.comparing(Patient::getHeight))
                .orElseThrow(NoSuchElementException::new);
    }

    public ArrayList<Patient> getMinHeightPatient(int n) {
        return new ArrayList<Patient>(patientList
                .stream()
                .sorted(Patient::compareHeight)
                .limit(n)
                .collect(Collectors.toList()));
    }

    public Patient getMaxHeightPatient() {
        return patientList
                .stream()
                .max(Comparator.comparing(Patient::getHeight))
                .orElseThrow(NoSuchElementException::new);
    }

    public ArrayList<Patient>  getMaxHeightPatient(int n) {
        return new ArrayList<Patient>(patientList
                .stream()
                .sorted(Patient::compareHeight)
                .limit(n)
                .collect(Collectors.toList()));
    }


    public long getPatientCountBySurname(String argument) {
        long  patientCountBySurname = patientList
        .stream()
        .filter(c -> c.getSurname() == argument)
        .count();
        return patientCountBySurname;
    }

    public Map<String, Long> getPatientCountBySurname() {
        Map<String, Long> patientCountBySurname = patientList
        .stream()
        .collect(Collectors.groupingBy(Patient::getSurname,
                 Collectors.counting()));
        return patientCountBySurname;
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

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

import Records.Measurement;
import BaseClasses.Consultant;
import BaseClasses.Patient;

import AuxClasses.Date;

public final class MeasurementAPI implements MeasurementAPIDefinitions {
    private ArrayList<Measurement> measurementList;

    public MeasurementAPI() {
        measurementList = new ArrayList<>();
    }

    public void trim() {
        measurementList.clear();

    };
   
    public int getSize() {
        return this.measurementList.size();
    };

    public void add(Measurement measurement) {
        measurementList.add(measurement);
    }

    public Measurement getLast() {
        return measurementList.get(measurementList.size()-1);
    }

    public ArrayList<Measurement> getAll() {
        return measurementList;
    }

    public ArrayList<Measurement> getAll(Date argument) {
        var tempList = new ArrayList<Measurement>();
        for (Measurement measurement: measurementList) {
            if (measurement.measurementDate() == argument) {
                tempList.add(measurement);
            }
        }
        return tempList;
    }

    public ArrayList<Measurement> getAll(Consultant argument) {
        ArrayList<Measurement> tempList = new ArrayList<>();
        for (Measurement measurement: measurementList) {
            if (measurement.consultant().getConsultantNo() == argument.getConsultantNo()) {
                tempList.add(measurement);
            }
        }
        return tempList;
    }

    public ArrayList<Measurement> getAll(Patient argument) {
        ArrayList<Measurement> tempList = new ArrayList<>();
        for (Measurement measurement: measurementList) {
            if (measurement.patient().getPatientNo() == argument.getPatientNo()) {
                tempList.add(measurement);
            }
        }
        return tempList;
    }

    public void writeToDisk(String filename) {
        try{
            FileOutputStream writeData = new FileOutputStream(filename);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(this.measurementList);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void readFromDisk(String filename) {
        this.trim();
        ResourceBundle measurementAPIResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());
        ArrayList<Measurement> tempList = new ArrayList<>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            try {
                tempList = (ArrayList<Measurement>)readStream.readObject();
            } catch (EOFException e) {
                System.out.println(measurementAPIResourceBundle.getString("ErrorEOF"));
            }
            readStream.close();
            for (Measurement measurement: tempList) {
                this.add(measurement);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
